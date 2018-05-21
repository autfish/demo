package com.autfish.demo.web.controller;

import com.autfish.demo.web.model.AdminModel;
import com.autfish.demo.web.model.ErrorModel;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;

@Controller
@SessionAttributes("adminUser")
public class AdminController {

    @RequestMapping(value="/login", method = RequestMethod.GET)
    public String login(@ModelAttribute("adminModel") AdminModel adminModel) {
        return "authority/login";
    }

    @RequestMapping(value="/login", method = RequestMethod.POST)
    public String login(Model model, @ModelAttribute("adminModel") AdminModel adminModel, @RequestParam("backUrl") String backUrl) {
        ErrorModel errorModel = new ErrorModel();
        boolean valid = true;
        if(adminModel == null) {
            errorModel.setMessage("非法操作");
            valid = false;
        } else if (!adminModel.getUsername().equals("admin")) {
            errorModel.setMessage("用户名不存在");
            valid = false;
        } else if (!adminModel.getPassword().equals("123456")) {
            errorModel.setMessage("密码不正确");
            valid = false;
        }

        if(!valid) {
            errorModel.setPage("返回上一页", "javascript:history.back();");
            model.addAttribute("errorModel", errorModel);
            return "comm/error";
        } else {
            model.addAttribute("adminUser", adminModel.getUsername());
            return "redirect:" + backUrl;
        }
    }

    @RequestMapping(value="/logout")
    public String logout(SessionStatus sessionStatus) {
        sessionStatus.setComplete();
        return "authority/login";
    }
}
