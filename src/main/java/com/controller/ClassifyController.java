package com.controller;

import com.service.ClassifyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 * @author lk
 * 2018/10/29 10:38
 * @description:
 */
@Controller
public class ClassifyController {

    @Autowired
    private ClassifyService classifyServiceImpl;


}
