package com.autfish._spring.step04.beans;

import java.util.List;

import com.autfish._spring.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class AutowiredDemo {

    //有且仅有一个匹配的bean
    @Autowired(required = false)
    private ComponentDemo componentDemo;

    @Autowired
    @Qualifier("car1")
    private Car car;

    @Autowired
    public void init(ComponentDemo componentDemo, @Qualifier("car2") Car car) {

    }

    //注入所有类型匹配的bean
    @Autowired
    private List<Car> cars;
}
