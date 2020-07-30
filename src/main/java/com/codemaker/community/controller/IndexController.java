package com.codemaker.community.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author 马洁
 * @date 2020/7/30 - 9:05
 */
@Controller
public class IndexController {
    @GetMapping("")
    public String index() {
        return "index";
    }
}
