package com.autfish.demo.mapper;

import com.autfish.demo.domain.Person;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.mapping.FetchType;

/**
 * OneToOne Mybatis演示
 */
public interface PersonMapper {

    @Select("SELECT * FROM t_person WHERE ID=#{id}")
    @Results({
            @Result(id = true, column = "id", property = "id"),
            @Result(column = "name", property = "name"),
            @Result(column = "sex", property = "sex"),
            @Result(column = "age", property = "age"),
            @Result(column = "cardId", property = "cardId",
                    one = @One(select = "com.autfish.demo.mapper.CardMapper.selectCardById", fetchType = FetchType.EAGER
                    ))
    })
    Person selectPersonById(Integer id);
}
