package com.javastudy;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Mainapp {
	public static void main(String[] args) {
//		ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
		Helloworld hello = (Helloworld) new ClassPathXmlApplicationContext("Beans.xml").getBean("Helloworld");
		hello.printMessage();
	}
}
