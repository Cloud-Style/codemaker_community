package com.codemaker.community.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author 马洁
 * @date 2020/7/29 - 23:08
 */
@Controller
public class HelloController {
    @GetMapping("/hello")
    public String hello(@RequestParam(name = "name", defaultValue = "") String name,
                        Model model) {
        model.addAttribute("name", name);
        return "hello";
    }
}
