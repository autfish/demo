package com.autfish.demo.web.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import com.autfish.demo.domain.Goods;

/**
 * 各种RequestMapping
 */
@Controller
@RequestMapping("/mapping")
@PropertySource("classpath:system.properties")
public class MappingController {

	Logger logger = LogManager.getLogger(MappingController.class);

	@RequestMapping(value = { "/standard", "/second" })
	public void standard(HttpServletResponse resp) throws IOException {
		resp.getWriter().write("standard");
	}

	//仅匹配GET请求
	@GetMapping("/get")
	public void getOnly(HttpServletResponse resp) throws IOException {
		resp.getWriter().write("get");
	}

	//请求的HTTP 头的Content-Type 媒体类型与consumes 的值匹配
	//如ajax设置  contentType:"application/son",
	@GetMapping(value = "/consumes", consumes = "application/json")
	public void consumes(HttpServletResponse resp) throws IOException {
		resp.getWriter().write("consumes");
	}

	//produces 属性对应于HTTP 请求的Accept 字段, 只有匹配得上的方法才能被调用
	@GetMapping(value = "/produces", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public void produces(HttpServletResponse resp) throws IOException {
		resp.getWriter().write("produces");
	}

	// Ant风格 * 匹配一层路径
	@RequestMapping("/oneStar/*")
	public void oneStar(HttpServletResponse resp) throws IOException {
		resp.getWriter().write("oneStar");
	}

	// Ant风格 ** 匹配任意层次路径
	@RequestMapping("/twoStar/**")
	public void twoStar(HttpServletResponse resp) throws IOException {
		resp.getWriter().write("twoStar");
	}

	// Ant风格 ? 匹配一个字符
	@RequestMapping("/questionMark/???")
	public void questionMark(HttpServletResponse resp) throws IOException {
		resp.getWriter().write("questionMark");
	}

	// 占位符
	@RequestMapping("/placeholder/{pathParam}")
	public void placeholder(@PathVariable("pathParam") String pathParam,
			HttpServletResponse resp) throws IOException {
		resp.getWriter().write("placeholder:" + pathParam);
	}

	// 根据请求参数映射请求
	// params = "reqId1" 必须包含reqId1参数
	// params = "!reqId1" 不能包含reqId1参数
	// 绑定请求参数
	@RequestMapping(value = "/bindRequestParam", method = RequestMethod.GET, params = "reqId1")
	public void bindRequestParam(@RequestParam("reqId1") String reqId1,
			@RequestParam(value = "reqId2", required = false) String reqId2,
			HttpServletResponse resp) throws IOException {
		resp.getWriter().write("bindRequestParam: reqId1=" + reqId1);
		resp.getWriter().write("bindRequestParam: reqId2=" + reqId2);
	}

	// 绑定Cookie值
	@RequestMapping(value = "/bindCookie")
	public void bindCookie(
			@CookieValue(value = "JSESSIONID", required = false) String sessionId,
			HttpServletResponse resp) throws IOException {
		resp.getWriter().write("bindCookie: JSESSIONID=" + sessionId);
	}

	// 绑定Header值
	@RequestMapping(value = "/bindHeader")
	public void bindHeader(@RequestHeader(value= "Keep-Alive", required = false) String keepAlive,
			@RequestHeader(value = "Accept-Language") String acceptLanguage,
			HttpServletResponse resp) throws IOException {
		resp.getWriter().write("bindHeader: Keep-Alive=" + keepAlive);
		resp.getWriter().write("bindHeader: Accept-Language=" + acceptLanguage);
	}
	
	//把请求参数或表单参数转换为对象
	//?id=1&name=book&price=10
	@RequestMapping(value = "/toModel")
	public void toModel(Goods goods, HttpServletResponse resp) throws IOException {
		resp.getWriter().write("toModel: goods=" + goods);
	}

	@Value("${debug}")
	String testValue;

	@RequestMapping(value = "/testValue")
	public void testValue(HttpServletResponse resp) throws IOException {
		resp.getWriter().write("testValue: testValue=" + testValue);
	}

	//请求和返回都是String
	@RequestMapping("/stringConverter")
	@ResponseBody
	public String stringConverter(@RequestBody String requestBody) {
		System.out.println("stringConverter: requestBody=" + requestBody);
		return "hi, " + requestBody;
	}

	@RequestMapping("/byteArrayConverter")
	@ResponseBody
	public byte[] byteArrayConverter(@RequestBody byte[] requestBody) {
		System.out.println("byteArrayConverter: requestBody=" + new String(requestBody));
		return ("hi, " + new String(requestBody)).getBytes();
	}

	@RequestMapping("/jsonConverter")
	@ResponseBody
	public Map<String, Object> jsonConverter(@RequestBody Goods requestBody) {
		System.out.println("jsonConverter: requestBody=" + requestBody);
		Map<String, Object> map = new HashMap<>();
		map.put("id", requestBody.getId());
		map.put("name", requestBody.getName());
		map.put("price", requestBody.getPrice());
		return map;
	}

	@RequestMapping("/log") //跳转到error.jsp
	@ResponseBody
	public String log() {
		logger.trace("trace");
		logger.debug("debug");
		logger.info("info");
		logger.warn("warn");
		logger.error("error");
		logger.fatal("fatal");
		return "ok";
	}

	@RequestMapping("/toError") //跳转到error.jsp
	@ResponseBody
	public String toError() throws IOException {
		int x = 3 / 0;
		return "value is " + x;
	}
}
