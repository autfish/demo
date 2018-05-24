package com.autfish.demo.service.std;

import com.autfish.demo.domain.User;
import com.autfish.demo.mapper.UserMapper;
import com.autfish.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("userService")
public class UserServiceStdImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User findWithLoginName(String loginName) {
        return userMapper.findWithLoginName(loginName);
    }
}
