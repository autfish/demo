package com.autfish._spring.step04.beans;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/*
 * 基于Java类配置
 */
@Configuration //声明当前类是一个配置类
@ComponentScan("com.autfish._spring.step04.beans") //自动扫描包下所有使用@Service,@Component,@Repository,@Controller的类注册为Bean
public class JavaConfigDemo {
}
