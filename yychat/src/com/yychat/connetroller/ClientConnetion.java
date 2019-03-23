package com.yychat.connetroller;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

import com.yychat.modal.Message;
import com.yychat.modal.User;

public class ClientConnetion {
	Socket s;
	public ClientConnetion(){
		try {
			s = new Socket("127.0.0.1",3456);
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	}
	public Message loginValidate(User user){
		ObjectOutputStream oos;
		Message mess = null;
		try {
			 oos = new ObjectOutputStream(s.getOutputStream());
			 oos.writeObject(user);//发送给服务器端
			 
			 ObjectInputStream ois = new ObjectInputStream(s.getInputStream());
			 mess = (Message)ois.readObject();
			 
			 
		} catch (IOException | ClassNotFoundException e) {
			
			e.printStackTrace();
		}
		return mess;
	}
}
