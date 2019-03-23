package com.yychatclient.view;

//import java.awt.BorderLayout;
//import java.awt.GridLayout;

import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

//import javax.swing.*;

//import javax.swing.JPanel;

/*
 * 
 * @author 秦武胜
 * 
 * 
 */
public class FriendList extends JFrame implements ActionListener,MouseListener{
	//成员
	CardLayout cardlayout;
	//第一个卡片
	JPanel myFriendPanel;
	
	JButton myFriendButton;
	JScrollPane myFriendListJScrollPane;
	JPanel myFriendListJPanel;
	public static final int MYFRTENDCOUNT = 51;
	JLabel[] myFriendJLabel = new JLabel[MYFRTENDCOUNT];
	
	JPanel myStrangerBlackListPanel;
	JButton myStrangerButton;
	JButton blackListButton;
	
	//第二个卡片
	JPanel myStrangerPanel;
	JLabel[] myStrangerJLabel = new JLabel[MYFRTENDCOUNT];
	JScrollPane myStrangerJScrollPane;
	JPanel myStrangerListJPanel;
	//北部
	JPanel myFriendStrangerPanel;
	JButton myFriendButton1;
	JButton myStrangerButton1;
	JButton blackListButton1;
	
	JPanel myblackPanel;
	JLabel[] myblackJLabel = new JLabel[MYFRTENDCOUNT];
	JScrollPane myblackJScrollPane;
	JPanel myblackListJPanel;
	JPanel myFriendblackPanel;
	JButton myFriendButton2;
	JButton myStrangerButton2;
	JPanel myblackBack;
	String userName;
	public FriendList(String userName){
		this.userName = userName;
		//创建第一张卡片
		myFriendPanel = new JPanel(new BorderLayout());
		
		//北部
		myFriendButton = new JButton("我的好友");
		myFriendPanel.add(myFriendButton,"North");
		
		//中部
		myFriendListJPanel = new JPanel(new GridLayout(MYFRTENDCOUNT - 1,1));
		for(int i=1;i<MYFRTENDCOUNT;i++){
			myFriendJLabel[i] = new JLabel(i + "",new ImageIcon("image/YY1.gif"),JLabel.LEFT);
			myFriendJLabel[i].addMouseListener(this);
			myFriendListJPanel.add(myFriendJLabel[i]);
		}
		myFriendListJScrollPane = new JScrollPane(myFriendListJPanel);
		myFriendPanel.add(myFriendListJScrollPane);
		
		//南部
		myStrangerBlackListPanel = new JPanel(new GridLayout(2,1));
		myStrangerButton = new JButton("我的陌生人");
//		myStrangerButton = new JScrollBar(GridLayout(2,1));
		myStrangerButton.addActionListener(this);//事件监听器
		blackListButton = new JButton("黑名单");
		myStrangerBlackListPanel.add(myStrangerButton);
		myStrangerBlackListPanel.add(blackListButton);
		myFriendPanel.add(myStrangerBlackListPanel,"South");
//		this.add(myFriendPanel);
		
		//第二张卡片
		/*   陌生人界面          */
		myStrangerPanel = new JPanel(new BorderLayout());//边界问题，边界布局
		//北部
		myFriendStrangerPanel = new JPanel( new GridLayout(2,1));//网格布局
		myFriendButton1 = new JButton("我的好友");
		myFriendButton1.addActionListener(this);
		
		myStrangerButton1 = new JButton("我的陌生人");
		myFriendStrangerPanel.add(myFriendButton1);
		myFriendStrangerPanel.add(myStrangerButton1);
		myStrangerPanel.add(myFriendStrangerPanel,"North");
		
		//
		myStrangerListJPanel = new JPanel(new GridLayout(MYFRTENDCOUNT - 1,1));
		for(int i=1;i<MYFRTENDCOUNT;i++){
			myStrangerJLabel[i] = new JLabel(i + "",new ImageIcon("image/yy2.gif"),JLabel.LEFT);
			myStrangerListJPanel.add(myStrangerJLabel[i]);
		}
		myStrangerJScrollPane = new JScrollPane(myStrangerListJPanel);
		myStrangerPanel.add(myStrangerJScrollPane);
		
		blackListButton1 = new JButton("黑名单");
		myStrangerPanel.add(blackListButton1,"South");
		blackListButton1.addActionListener(this);
/*                                                                                                    */		
		//黑名单
		myblackPanel = new JPanel(new BorderLayout());
//		myFriendblackPanel = new JPanel(new BorderLayout());
		myFriendButton2 = new JButton("我的好友");
		myFriendButton2.addActionListener(this);
		myblackPanel.add(myFriendButton2,"North");
		myStrangerButton2 = new JButton("我的陌生人");
		myblackPanel.add(myStrangerButton2);
		myblackBack = new JPanel( new GridLayout(2,1));
		//
		myblackListJPanel = new JPanel(new GridLayout(MYFRTENDCOUNT - 1,1));
		for(int i=1;i<MYFRTENDCOUNT;i++){
			myblackJLabel[i] = new JLabel(i + "",new ImageIcon("image/yy3.gif"),JLabel.LEFT);
			myblackListJPanel.add(myblackJLabel[i]);
		}
		myblackJScrollPane = new JScrollPane(myblackListJPanel);
		myblackPanel.add(myblackJScrollPane);
		myblackBack.add(myFriendButton2);
		myblackBack.add(myStrangerButton2);
		myblackPanel.add(myblackBack);
		
		cardlayout = new CardLayout();
		this.setLayout(cardlayout);
		this.add(myFriendPanel,"1");
		this.add(myStrangerPanel,"2");
		this.add(myblackPanel,"3");
		this.setSize(180,400);
		this.setTitle(userName + "的好友列表");
		this.setIconImage(new ImageIcon("image/yy3.gif").getImage());
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		
	}
	
	public static void main(String[] args) {
//		FriendList friendList = new FriendList();
		
	}

	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==myStrangerButton)
			cardlayout.show(this.getContentPane(),"2");
		if(e.getSource()==myFriendButton1 )
			cardlayout.show(this.getContentPane(),"1");
		if(e.getSource()==blackListButton)
			cardlayout.show(this.getContentPane(),"3");
	}

	public void mouseClicked(MouseEvent arg0) {
		if(arg0.getClickCount() == 2){
			JLabel jlbl = (JLabel)arg0.getSource();
			String receiver = jlbl.getText();
			new FriendChat(this.userName,receiver); 
		}
			
	}

	public void mouseEntered(MouseEvent arg0) {
		JLabel jlbl1 = (JLabel)arg0.getSource();
		jlbl1.setForeground(Color.red);
	}

	public void mouseExited(MouseEvent arg0) {
		JLabel jlbl1 = (JLabel)arg0.getSource();
		jlbl1.setForeground(Color.BLACK);
		
	}

	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}
