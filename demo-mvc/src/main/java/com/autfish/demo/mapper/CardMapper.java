package com.autfish.demo.mapper;

import com.autfish.demo.domain.Card;
import org.apache.ibatis.annotations.Select;

public interface CardMapper {

    @Select("SELECT * FROM t_card WHERE id=#{id}")
    Card selectCardById(Integer id);
}
