package com.yychatclient.view;//包名

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javafx.scene.image.Image;

import javax.swing.*;

import com.yychat.connetroller.ClientConnetion;
import com.yychat.modal.*;
//import com.sun.corba.se.impl.protocol.giopmsgheaders.Message;
//import com.sun.corba.se.impl.protocol.giopmsgheaders.Message;
//import com.yychat.connetroller.ClientConnetion;
//import com.yychat.connetroller.ClientConnetion;
import com.yychat.modal.User;

public class ClientLogin extends JFrame implements ActionListener {  //类   extends ....继承
	JLabel jlbl1;  // 顶层标签 1
	JButton jb1,jb2,jb3; //底层设计按钮【登录】、【注册】、【取消】
	JTabbedPane jtp1,jtp2,jtp3; // 中间的面板
	JPanel jp2,jp3,jp4;// 在中间面板进行编辑的版块
	JLabel jlbl2,jlbl3,jlbl4,jlbl5;// 中间面板进行编辑的地方
	JTextField jtf1,jtf2,jtf3;//文字编辑框【输入账号用的】
	JPasswordField jpf1,jpf2,jpf3;//文字编辑框【输入密码用的】
	JButton jb4;//在中间面板插入清除键
	JCheckBox jcb1,jcb2,jcb3,jcb4,jcb5;//在中间面板插入勾选框
	JCheckBox jcb6,jcb7,jcb8;
	JPanel jp1; //    底部面板
	JLabel jlbl6,jlbl7,jlbl8,jlbl9;
	JLabel jlbl10,jlbl11,jlbl12,jlbl13;
	JPanel jp5,jp6,jp7;
	public ClientLogin(){
		//顶层设计
		JLabel jlbl1 = new JLabel(new ImageIcon("image/tou.gif"));
		this.add(jlbl1,"North");
		//中间设计
		jtp1 = new JTabbedPane(); // 构建中间整体框架
		jp2 = new JPanel(new GridLayout(3,3));// 构建网格
		jp3 = new JPanel(new GridLayout(3,3));//构建
		jp4 = new JPanel(new GridLayout(3,3));//构建
		//jtp1.add(jp2,"YY号码");jtp1.add(jp3,"手机号码");jtp1.add(jp4,"电子邮箱");
		jlbl2 = new JLabel("YY号码",JLabel.CENTER);//构建
		jlbl3 = new JLabel("YY密码",JLabel.CENTER);//构建
		jlbl4 = new JLabel("忘记密码",JLabel.CENTER);//构建
		jlbl4.setForeground(Color.BLUE);//构建
		jlbl5 = new JLabel("密码保护",JLabel.CENTER);//构建
		jtf1 = new JTextField();//构建
		jpf1 = new JPasswordField();//构建
		//手机页面
		jlbl6 = new JLabel("手机号码",JLabel.CENTER);
		jlbl7 = new JLabel("发送验证码",JLabel.CENTER);
		jlbl8 = new JLabel("输入验证码",JLabel.CENTER);
		jlbl7.setForeground(Color.BLUE);
		jlbl9 = new JLabel("取消",JLabel.CENTER);
		jlbl9.setForeground(Color.BLACK);
		jtf2 = new JTextField();
		jpf2 = new JPasswordField();
		jcb6 = new JCheckBox("自动登录");
		jcb7 = new JCheckBox("记住手机");
		jcb8 = new JCheckBox("隐身登录");
		jp3.add(jlbl6);jp3.add(jtf2);jp3.add(jlbl7);
		jp3.add(jlbl8);jp3.add(jpf2);jp3.add(jlbl9);
		jp3.add(jcb6);jp3.add(jcb7);jp3.add(jcb8);
//		this.add(jp3);
		//电子邮箱
		jlbl10 = new JLabel("邮箱地址",JLabel.CENTER);
		jlbl11 = new JLabel("邮箱密码",JLabel.CENTER);
		jlbl12 = new JLabel("清除",JLabel.CENTER);
		jlbl13 = new JLabel("忘记密码",JLabel.CENTER);
		jtf3 = new JTextField();
		jpf3 = new JPasswordField();
		jcb3 = new JCheckBox("记住密码");
		jcb4 = new JCheckBox("自动登录");
		jcb3 = new JCheckBox("记住密码");
		jcb5 = new JCheckBox("隐身登录");
		jp4.add(jlbl10);jp4.add(jtf3);jp4.add(jlbl12);
		jp4.add(jlbl11);jp4.add(jpf3);jp4.add(jlbl13);
		jp4.add(jcb3);jp4.add(jcb4);jp4.add(jcb5);
		
		jb4 = new JButton(new ImageIcon("image/clear.gif"));//构建
		jcb1 = new JCheckBox("隐身登录");//构建
		jcb2 = new JCheckBox("忘记密码");//构建
		jp2.add(jlbl2);jp2.add(jtf1);jp2.add(jb4);//网格序号
		jp2.add(jlbl3);jp2.add(jpf1);jp2.add(jlbl4);//
		jp2.add(jcb1);jp2.add(jcb2);jp2.add(jlbl5);//
		jtp1.add(jp2,"YY号码");jtp1.add(jp3,"手机号码");jtp1.add(jp4,"电子邮箱");//分页
		
		this.add(jtp1);
		
		//底层设计
		jb1 = new JButton(new ImageIcon("image/denglu.gif"));//构建
		jb1.addActionListener(this);//监听登录按钮
		jb2 = new JButton(new ImageIcon("image/zhuce.gif"));//构建
		jb3 = new JButton(new ImageIcon("image/quxiao.gif"));//构建
		jp1 = new JPanel();//构建
		jp1.add(jb1);jp1.add(jb2);jp1.add(jb3);
		this.add(jp1,"South");
		
		
		this.setLocationRelativeTo(null);
		this.setSize(360,250);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args) {
				ClientLogin clientLogin=new ClientLogin();
	}

	public void actionPerformed(ActionEvent arg0) {
		if(arg0.getSource() == jb1){
			String userName = jtf1.getText();
			String password = new String(jpf1.getPassword());
			User user = new User();
			user.setUserName(userName);
			user.setPassword(password);
			
			//密码验证
			Message mess =  new ClientConnetion().loginValidate(user);
			if(mess.getMessageType().equals("1")){
				new FriendList(userName);
				this.dispose(); 
			}else{
				JOptionPane.showMessageDialog(this,"密码错误");
			}
			
			
			
		}
			
		
	}

}
