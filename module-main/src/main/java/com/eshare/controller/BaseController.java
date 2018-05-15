package com.eshare.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Created by liangyh on 2018/5/16.
 * Email:10856214@163.com
 */
@Controller
public class BaseController {

    @GetMapping("/index")
    public String index() {
        return "index";
    }
}
