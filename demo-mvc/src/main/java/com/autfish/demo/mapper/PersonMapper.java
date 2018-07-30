package com.autfish.demo.mapper;

import com.autfish.demo.domain.Person;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;
import java.util.Map;

/**
 * Mybatis演示
 */
public interface PersonMapper {

    @Select("SELECT * FROM t_person WHERE ID=#{id}")
    @Results({
            @Result(id = true, column = "id", property = "id"),
            @Result(column = "name", property = "name"),
            @Result(column = "sex", property = "sex"),
            @Result(column = "age", property = "age"),
            @Result(column = "cardId", property = "card",
                    one = @One(select = "com.autfish.demo.mapper.CardMapper.selectCardById", fetchType = FetchType.EAGER
                    )),
            @Result(column = "id", property = "friends",
                    many = @Many(select = "com.autfish.demo.mapper.PersonMapper.selectFriendsByPersonId", fetchType = FetchType.LAZY
                    )),
    })
    Person selectPersonById(Integer id);

    @Select("SELECT * FROM t_person WHERE ID in(SELECT friendId FROM t_friend WHERE personId=#{id})")
    List<Person> selectFriendsByPersonId(Integer id);

    @SelectProvider(type = PersonDynaSqlProvider.class, method = "selectWithParam")
    List<Person> selectWithParam(Map<String, Object> param);
}
