

import java.awt.*;
import java.awt.event.*;

public class ChatClient extends Frame{
	/*
	 * 聊天客户端宽和高
	 * */
	private static final int FRAMEWIDTH = 400;
	private static final int FRAMEHEIGHT = 300;
	
	private TextField textFieldIn = new TextField();
	private TextArea textAreaOut = new TextArea();
	
	class TextInToOutListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			String s = textFieldIn.getText().trim();
			textAreaOut.setText(s+"\n");
			textFieldIn.setText("");
		}
	}
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
		
		add(textFieldIn, BorderLayout.SOUTH);
		add(textAreaOut, BorderLayout.NORTH);
		pack();
		
		textFieldIn.addActionListener(new TextInToOutListener());
		
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
