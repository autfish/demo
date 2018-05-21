package com.autfish.demo.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Administrator on 2017/7/27.
 */
@Controller
@RequestMapping("/angular")
public class AngularController {

    @RequestMapping("/demo")
    public String demo() {
        return "angular/demo";
    }
}
