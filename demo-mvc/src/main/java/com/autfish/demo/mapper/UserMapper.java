package com.autfish.demo.mapper;

import com.autfish.demo.domain.User;
import org.apache.ibatis.annotations.Select;
import org.springframework.data.repository.query.Param;

public interface UserMapper {

    @Select("select * from t_user where loginName=#{loginName}")
    User findWithLoginName(@Param("loginName") String loginName);
}