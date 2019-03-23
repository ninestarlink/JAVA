package com.yychatServer.controller;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

import com.yychat.modal.Message;
import com.yychat.modal.User;

public class StartServer {
	ServerSocket ss;
	Socket s;
	public StartServer(){
		try {
			ss = new ServerSocket(3456);
			System.out.println("服务器已经启动，监听3456端口");
			while(true){
				s = ss.accept();//客户端
				System.out.println(s);
				
				ObjectInputStream ois = new ObjectInputStream(s.getInputStream());
				User user = (User)ois.readObject();
				System.out.println(user.getUserName());
				System.out.println(user.getPassword());
				Message mess = new Message();
				mess.setSender("Server");
				mess.setReceiver(user.getUserName());
				if(user.getPassword().equals("123456")){
					
					mess.setMessageType("1");
				}
				else{
					
					mess.setMessageType("0");
				}
				
				ObjectOutputStream oos = new ObjectOutputStream(s.getOutputStream());
				oos.writeObject(mess);
			}
		
			
		} catch (IOException | ClassNotFoundException e) {
			
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		

	}

}
