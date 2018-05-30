package com.autfish.demo.mapper;

import com.autfish.demo.domain.User;
import org.apache.ibatis.annotations.*;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * 基础Mybatis注解演示
 */
public interface UserMapper {

    @Insert("INSERT INTO t_user(name,sex,age) VALUES(#{name},#{sex},#{age})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    int saveUser(User user);

    @Delete("DELETE FROM t_user WHERE id=#{id}")
    int removeUser(@Param("id") Integer id);

    @Update("UPDATE t_user SET name=#{name},sex=#{sex},age=#{age} WHERE id=#{id}")
    void modifyUser(User user);

    @Select("SELECT * FROM t_user WHERE id=#{id}")
    @Results({
            @Result(id = true, column = "id", property = "id"),
            @Result(column = "name", property = "name"),
            @Result(column = "sex", property = "sex"),
            @Result(column = "age", property = "age")
    })
    User selectUserById(Integer id);

    @Select("SELECT * FROM t_user")
    List<User> selectAllUser();
}