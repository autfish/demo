package com.autfish.demo.mapper;

import org.apache.ibatis.jdbc.SQL;

import java.util.Map;

public class PersonDynaSqlProvider {

    public String selectWithParam(Map<String, Object> param) {
        return new SQL() {{
                SELECT("*");
                FROM("t_person");
                if(param.get("id") != null) {
                    WHERE("id=#{id}");
                }
                if(param.get("name") != null) {
                    WHERE("name=#{name}");
                }
                if(param.get("sex") != null) {
                    WHERE("sex=#{sex}");
                }
                if(param.get("age") != null) {
                    WHERE("age=#{age}");
                }
                if(param.get("cardId") != null) {
                    WHERE("cardId=#{cardId}");
                }
            }
        }.toString();

    }
}
