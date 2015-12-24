

import java.awt.*;
import java.awt.event.*;

public class ChatClient extends Frame{
	/*
	 * 聊天客户端宽和高
	 * */
	private static final int FRAMEWIDTH = 400;
	private static final int FRAMEHEIGHT = 300;
	
	private TextField textAreaIn = new TextField();
	private TextArea textAreaOut = new TextArea();
	/*
	 * 启动聊天客户端窗口
	 * */
	
	public void lauchFrame(){
		this.setTitle("聊天客户端");
		this.setLocation(400, 30);
		this.setSize(FRAMEWIDTH, FRAMEHEIGHT);
		this.setResizable(false);
		this.setBackground(Color.LIGHT_GRAY);
		
		/*
		 * 设置文本框样式
		 * */
		
		add(textAreaIn, BorderLayout.SOUTH);
		add(textAreaOut, BorderLayout.NORTH);
		pack();
		
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
