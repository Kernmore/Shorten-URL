package com.example.shortenurl.controllers;

import com.example.shortenurl.UrlService;
import com.example.shortenurl.UrlStatDTO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class MyController {

    private final UrlService urlService;

    public MyController(UrlService urlService) {
        this.urlService = urlService;
    }

    //Task 2
    /**
     * The initial method for the View: index.html
     * @param model
     * @return the page
     */
    @GetMapping("/")
    public String onIndex(Model model) {
        List<UrlStatDTO> stats = urlService.getStatistics();

        model.addAttribute("dtos", stats);
        return "index";
    }


}
