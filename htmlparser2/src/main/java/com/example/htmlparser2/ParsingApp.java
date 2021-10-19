package com.example.htmlparser2;

import com.example.htmlparser2.Models.ResultsDAO;
import com.example.htmlparser2.ParsingService.MyJsoapParser;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


import java.util.Map;
import java.util.Scanner;

@SpringBootApplication
public class ParsingApp {

    public static void main(String[] args) {
        SpringApplication.run(ParsingApp.class,args);
    }

}
