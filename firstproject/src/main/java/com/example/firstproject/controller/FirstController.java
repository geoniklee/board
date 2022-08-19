package com.example.firstproject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;

@Controller
public class FirstController {
    @GetMapping("/hi")
    public String niceToMeetYou(Model model) {
        model.addAttribute("username", "geon ik");
        return "greetings";
    }
    @GetMapping("/bye")
    public String SeeyouNext(Model model){
        model.addAttribute("nickname", "geonik lee");
        return "goodbye";
    }
}
