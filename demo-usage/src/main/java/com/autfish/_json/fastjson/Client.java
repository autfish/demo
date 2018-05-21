package com.autfish._json.fastjson;

import java.util.HashMap;
import java.util.Map;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;

public class Client {

	public static void main(String[] args) {
		new Client().catchException();
		new Client().toJSONObject();
		new Client().toObject();
		new Client().mapToJson();
	}
	
	public void catchException() {
		//源字符串为null或空白, 返回null
		JSONObject jo = JSON.parseObject(null);
		System.out.println("parse(null)=" + jo); //parse(null)=null
		String json = "";
		jo = JSON.parseObject(json);
		System.out.println("parse(\"\")=" + jo); //parse("")=null
		
		//源字符串不符合json规范, 抛异常
		json = "a";
		try {
			jo = JSON.parseObject(json);
			System.out.println("parse(\"a\")=" + jo);
		} catch (JSONException e) {
			System.out.println("parse(\"a\")=exception"); //parse("a")=exception
		}
		json = "{";
		try {
			jo = JSON.parseObject(json);
			System.out.println("parse(\"{\")=" + jo);
		} catch (JSONException e) {
			System.out.println("parse(\"{\")=exception"); //parse("{")=exception
		}
		json = "{a}";
		try {
			jo = JSON.parseObject(json);
			System.out.println("parse(\"{a}\")=" + jo);
		} catch (JSONException e) {
			System.out.println("parse(\"{a}\")=exception"); //parse("{a}")=exception
		}
		//OK
		json = "{}";
		try {
			jo = JSON.parseObject(json);
			System.out.println("parse(\"{}\")=" + jo);
		} catch (JSONException e) {
			System.out.println("parse(\"{}\")=exception"); //parse("{}")={}
		}
		//整数和字符串
		json = "{\"a\":1,\"b\":\"2\"}";
		jo = JSON.parseObject(json);
		System.out.println(jo.getString("a")); //1
		System.out.println(jo.getIntValue("a")); //1
		System.out.println(jo.getInteger("a")); //1
		System.out.println((String)jo.getOrDefault("a", "0")); //ClassCastException
		System.out.println(jo.getString("b")); //2
		System.out.println(jo.getIntValue("b")); //2
		System.out.println(jo.getInteger("b")); //2
		System.out.println((int)jo.getOrDefault("b", 1)); //ClassCastException
		//大小写
		System.out.println(jo.getString("A")); //null
	}

	public void toJSONObject() {
		String json = "{\"id\":20130001,\"phone\":\"13579246810\",\"name\":\"Jason\"}";
		JSONObject jo = JSON.parseObject(json);
		System.out.println("jo.get(\"not exists key\")=" + jo.get("not exists key"));
		System.out.println("jo.getOrDefault(\"not exists key\")=" + jo.getOrDefault("not exists key", ""));
		System.out.println("jo.get(\"id\")=" + jo.get("id"));
	}
	
	public void toObject() {
		String json = "{\"id\":20130001,\"phone\":\"13579246810\",\"name\":\"Jason\"}";
		Card card = JSON.parseObject(json, Card.class);
		System.out.println(card);
		System.out.println(JSON.toJSONString(card));
	}
	
	public void mapToJson() {
		Map<String, Object> map = new HashMap<>();
		map.put("id", 20130001);
		map.put("phone", "13579246810");
		map.put("name", "Jason");
		System.out.println(JSON.toJSONString(map));
	}
}
