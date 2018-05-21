package com.autfish._spring.step11.mongodb;

import org.bson.Document;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * Created by Administrator on 2017/2/20.
 */
public class MongoDemo {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("_spring/step11/mongodb/spring-mongo.xml");
        MongoTemplate template = (MongoTemplate)context.getBean("mongoTemplate");
        Document doc1 = new Document("title", "good day").append("owner", "tom").append("words", 300).append("createTime", convertToUnixStamp(new Date()));
        template.insert(doc1);
        Document doc2 = template.findOne(new Query(Criteria.where("title").is("good day")), Document.class);
        System.out.println(doc2);
        Document doc3 = template.findOne(new Query(Criteria.where("title").is("good day").where("createTime").gt(0)), Document.class);
        System.out.println(doc3);
    }

    public static long convertToUnixStamp(Date dt) {
        return TimeUnit.SECONDS.convert(dt.getTime(), TimeUnit.MILLISECONDS);
    }
}
