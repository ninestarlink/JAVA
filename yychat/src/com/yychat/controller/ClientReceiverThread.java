package com.yychat.controller;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;

import com.yychat.model.Message;

public class ClientReceiverThread extends Thread{
	
	Socket s;
	
	public ClientReceiverThread(Socket s){
		this.s = s;
	}
	
	public void run(){
		ObjectInputStream ois;
		Message mess;
		while(true){
			try {
				//接受服务器转发得Message
				
				ois = new ObjectInputStream( s.getInputStream());
				mess=(Message)ois.readObject();
				System.out.println(mess.getSender()+"对"+mess.getReceiver()+"说:"+mess.getContent()+"\r\n");
				
			} catch (IOException | ClassNotFoundException e) {
				
				e.printStackTrace();
			}
		}
	}
}
