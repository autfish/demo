package com.autfish.demo.service;

import com.autfish.demo.domain.Person;
import com.autfish.demo.domain.User;

import java.util.List;
import java.util.Map;

public interface MybatisService {

    int saveUser(User user);

    int removeUser(Integer id);

    void modifyUser(User user);

    User selectUserById(Integer id);

    Person selectPersonById(Integer id);

    List<Person> selectWithParam(Map<String, Object> param);
}
