package com.zyz.seckill.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class SampleController {
    @RequestMapping("/hello")
    public String hello(Model model){
        model.addAttribute("name","zyz");
        return "hello";

    }
}
