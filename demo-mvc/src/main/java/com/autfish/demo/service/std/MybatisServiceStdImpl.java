package com.autfish.demo.service.std;

import com.autfish.demo.domain.Person;
import com.autfish.demo.domain.User;
import com.autfish.demo.mapper.PersonMapper;
import com.autfish.demo.mapper.UserMapper;
import com.autfish.demo.service.MybatisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;


@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT)
@Service("mybatisService")
public class MybatisServiceStdImpl implements MybatisService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private PersonMapper personMapper;

    @Override
    public int saveUser(User user) {
        return userMapper.saveUser(user);
    }

    @Override
    public int removeUser(Integer id) {
        return userMapper.removeUser(id);
    }

    @Override
    public void modifyUser(User user) {
        userMapper.modifyUser(user);
    }

    @Override
    public User selectUserById(Integer id) {
        return userMapper.selectUserById(id);
    }

    @Override
    public Person selectPersonById(Integer id) {
        return personMapper.selectPersonById(id);
    }

    @Override
    public List<Person> selectWithParam(Map<String, Object> param) {
        return personMapper.selectWithParam(param);
    }


}
