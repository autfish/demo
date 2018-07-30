package com.autfish.demo.web.controller;

import com.autfish.demo.service.PushService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.async.DeferredResult;

@Controller
public class AysncController {

    @Autowired
    PushService pushService;

    @RequestMapping("/async")
    public String async() {
        return "async/async";
    }

    @RequestMapping("/defer")
    @ResponseBody
    public DeferredResult<String> deferredCall() {
        return pushService.getAsyncUpdate();
    }
}
