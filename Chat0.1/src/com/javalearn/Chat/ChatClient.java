package com.javalearn.Chat;


import java.awt.*;
import java.awt.event.*;

public class ChatClient extends Frame{
	/*
	 * 聊天客户端宽和高
	 * */
	private static final int FRMAEWIDTH = 400;
	private static final int FRMAEHEIGHT = 600;
	
	/*
	 * 启动聊天客户端窗口
	 * */
	
	public void lauchFrame(){
		this.setTitle("聊天客户端");
		this.setLocation(40, 30);
		this.setSize(FRMAEWIDTH, FRMAEHEIGHT);
		this.setResizable(false);
		this.setBackground(Color.LIGHT_GRAY);
		setVisible(true);
		
		/*
		 * 设置窗口可以被关闭
		 * */
		
		this.addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
			
		});
	
	}

	public static void main(String[] args){
		ChatClient cc = new ChatClient();
		cc.lauchFrame();
	}
}
