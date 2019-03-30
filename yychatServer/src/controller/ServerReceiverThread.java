package controller;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.HashMap;

import com.yychat.model.Message;

public class ServerReceiverThread extends Thread{//必须要用run()
	Socket s;
	HashMap hmSocket;

	public ServerReceiverThread(Socket s,HashMap hmSocket){//s是Sender
		this.s=s;
		this.hmSocket=hmSocket;
	}
	public void run(){
		ObjectInputStream ois;
		while(true){
			try {//接受Message信息
				ois=new ObjectInputStream(s.getInputStream());
				Message mess=(Message)ois.readObject();//接收用户发送来的聊天信息，阻塞  10个用户  100毫秒
				System.out.println("等待用户发送聊天信息");
				System.out.println(mess.getSender()+"对"+mess.getReceiver()+"说:"+mess.getContent());
				
				//转发Message消息
				if(mess.getMessageType().equals(Message.message_Common)){
					Socket s1=(Socket)hmSocket.get(mess.getReceiver());
					System.out.println("s1"+s1);
					ObjectOutputStream oos=new ObjectOutputStream(s1.getOutputStream());//s1是Receiver
					oos.writeObject(mess);//转发Message
					System.out.println("服务器转发了信息"+mess.getSender()+"对"+mess.getReceiver()+"说:"+mess.getContent());
				}
				
			} catch (IOException | ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
		}
	}
}
