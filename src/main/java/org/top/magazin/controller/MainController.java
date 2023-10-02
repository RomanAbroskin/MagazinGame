package org.top.magazin.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class MainController {
    @GetMapping("")
    public String Index(){
        return "index";
    }
    @PostMapping("")
    public String postIndex(){
        return "redirect:/";
    }
}
