package com.autfish._spring.step01.resource;

import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;

public class FileSystemResourceDemo {

	public static void main(String[] args) {
		String filePath = System.getProperty("user.dir") + "\\config\\simple.xml";
		Resource res1 = new FileSystemResource(filePath);
		System.out.println(res1.getFilename());
	}
}
