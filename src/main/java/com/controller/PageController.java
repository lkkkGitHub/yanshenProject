package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;


/**
 * @author lk
 * 2018/10/24 11:53
 * @description: 进行jsp页面跳转
 */
@Controller
public class PageController {

    @RequestMapping("/{page}")
    public String page(@PathVariable(value = "page") String page) {
        return page;
    }

    @RequestMapping("/")
    public String pageLogin() {
        return "index";
    }
}
