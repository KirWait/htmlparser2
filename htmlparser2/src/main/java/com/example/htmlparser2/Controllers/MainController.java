package com.example.htmlparser2.Controllers;

import com.example.htmlparser2.Models.ResultsDAO;
import com.example.htmlparser2.ParsingService.MyJsoapParser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Map;


@Controller
public class MainController {

    private MyJsoapParser myJsoapParser;
    private ResultsDAO resultsDAO;

    public MainController(MyJsoapParser myJsoapParser, ResultsDAO resultsDAO) {
        this.myJsoapParser = myJsoapParser;
        this.resultsDAO = resultsDAO;
    }

    @GetMapping("/")
    public String getParsed(Model model){
        model.addAttribute("results", resultsDAO.getResultsMap());


        return "start";
    }

    @PostMapping("/")
    public String showResults(@RequestParam(name = "url") String url){
        resultsDAO.deleteAll();
        resultsDAO.saveResults(myJsoapParser.parse(url));
        return "redirect:/";
    }

}
