package com.example.htmlparser2.ParsingService;


import com.example.htmlparser2.Models.ResultsDAO;
import org.jsoup.Jsoup;
import org.springframework.stereotype.Component;


import java.io.IOException;
import java.util.Arrays;
import java.util.Locale;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
//            Arrays.stream(Jsoup.connect(url).get().text().toUpperCase(Locale.ROOT)
//                    .replaceAll("['—','{','}','\\-','+','=','*','&','^','%','$','#','@',' ', ',', '.', '! ', '?','\"', ';', ':', '\\[', '\\]', '(', ')', '\\n+', '\\r+', '\\t+','\\d+','/','\\']", " ")
//                    .split("\\s+"))
//                    .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
//                    .entrySet().stream().sorted(Map.Entry.comparingByValue()).forEach(System.out::println);
@Component
public class MyJsoapParser {

    ResultsDAO resultsDAO = new ResultsDAO();


    public Map<String, Long> parse(String url) {
        Map<String, Long> map = null;
        try {
           map = Arrays.stream(Jsoup.connect(url).get().text().toUpperCase(Locale.ROOT)
                            .replaceAll("['>','<','/','—','{','}','\\-','+','=','*','&','^','%','$','#','@',' ', ',', '.', '! ', '?','\"', ';', ':', '\\[', '\\]', '(', ')', '\\n+', '\\r+', '\\t+','\\d+','/','\\']", " ")
                            .split("\\s+"))
                    .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));



        } catch (IOException e) {
            e.printStackTrace();
        }
    return map;

    }



    }



