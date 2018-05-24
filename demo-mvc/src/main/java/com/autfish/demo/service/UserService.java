package com.autfish.demo.service;

import com.autfish.demo.domain.User;

public interface UserService {

    User findWithLoginName(String loginName);
}
