package com.yychatServer.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import com.yychatServer.controller.StartServer;

public class ChatServer extends JFrame implements ActionListener{
	JButton jb1;
	JButton jb2;
	JPanel jp;
	public ChatServer(){
		jb1 = new JButton("启动服务器");
		jb1.addActionListener(this);
		jb2 = new JButton("停止服务器");
		jp = new JPanel();
		jp.add(jb1);
		jp.add(jb2);
		
		this.add(jp);
		this.setTitle("YyChat服务器");
		this.setSize(240, 240);
		
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	public static void main(String[] args) {
		 ChatServer  chatServer = new  ChatServer();

	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		new StartServer();
		
	}

}
