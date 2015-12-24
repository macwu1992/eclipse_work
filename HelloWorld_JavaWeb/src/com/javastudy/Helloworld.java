package com.javastudy;

public class Helloworld {
	private String message;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	public void printMessage() {
		System.out.println("your message:"+message);
	}
}
