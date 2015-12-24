import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.*;
import java.net.*;

/*
 * 这是服务器端
 * */
public class ChatServer extends Frame{
	
	private static final int SERVERWIDTH = 300;
	private static final int SERVERHRIGHT = 400;
	private static ServerSocket ss ;
	
	public void lauchFrame(){
		this.setTitle("聊天程序 服务器端");
		this.setLocation(100, 100);
		this.setSize(SERVERWIDTH, SERVERHRIGHT);
		this.setVisible(true);
		
		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e){
				System.exit(0);
			}
		});
		
		/**
		 * 创建端口号
		 */
		try{
			ss = new ServerSocket(8888);
			while(true){
				Socket s = ss.accept();
System.out.println("a client conneted");
			}
		}catch(IOException e){
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args){
		ChatServer cs = new ChatServer();
		cs.lauchFrame();
	}
}
