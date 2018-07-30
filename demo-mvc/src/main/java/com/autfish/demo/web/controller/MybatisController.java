package com.autfish.demo.web.controller;

import com.autfish.demo.domain.Person;
import com.autfish.demo.domain.User;
import com.autfish.demo.service.MybatisService;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/mybatis")
public class MybatisController {

    @Autowired
    private MybatisService mybatisService;

    @RequestMapping(value = "/user", method = RequestMethod.GET)
    @ResponseBody
    public Map getUser(@RequestParam int id) {
        User user = mybatisService.selectUserById(id);
        System.out.println(ToStringBuilder.reflectionToString(user));
        Map<String, String> map = new HashMap<>();
        map.put("result", "1");
        return map;
    }

    @RequestMapping(value = "/person", method = RequestMethod.GET)
    @ResponseBody
    public Map getPerson(@RequestParam int id) {
        Person person = mybatisService.selectPersonById(id);

        System.out.println(ToStringBuilder.reflectionToString(person));

        System.out.println(ToStringBuilder.reflectionToString(person.getCard()));

        person.getFriends().forEach(f -> {
            System.out.println(ToStringBuilder.reflectionToString(f));
        });

        Map<String, String> map = new HashMap<>();
        map.put("result", "1");
        return map;
    }

    @RequestMapping(value = "/persons", method = RequestMethod.GET)
    @ResponseBody
    public Map getPersons() {
        Map<String, Object> param = new HashMap<>();
        param.put("sex", "male");
        param.put("age", 31);
        List<Person> persons = mybatisService.selectWithParam(param);
        persons.forEach(person -> {
            System.out.println(ToStringBuilder.reflectionToString(person));
        });

        Map<String, String> map = new HashMap<>();
        map.put("result", "1");
        return map;
    }
}
