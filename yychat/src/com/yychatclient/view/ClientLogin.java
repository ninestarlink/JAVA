package com.yychatclient.view;//����

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

public class ClientLogin extends JFrame implements ActionListener {  //��   extends ....�̳�
	JLabel jlbl1;  // �����ǩ 1
	JButton jb1,jb2,jb3; //�ײ���ư�ť����¼������ע�᡿����ȡ����
	JTabbedPane jtp1,jtp2,jtp3; // �м�����
	JPanel jp2,jp3,jp4;// ���м������б༭�İ��
	JLabel jlbl2,jlbl3,jlbl4,jlbl5;// �м������б༭�ĵط�
	JTextField jtf1,jtf2,jtf3;//���ֱ༭�������˺��õġ�
	JPasswordField jpf1,jpf2,jpf3;//���ֱ༭�����������õġ�
	JButton jb4;//���м������������
	JCheckBox jcb1,jcb2,jcb3,jcb4,jcb5;//���м������빴ѡ��
	JCheckBox jcb6,jcb7,jcb8;
	JPanel jp1; //    �ײ����
	JLabel jlbl6,jlbl7,jlbl8,jlbl9;
	JLabel jlbl10,jlbl11,jlbl12,jlbl13;
	JPanel jp5,jp6,jp7;
	public ClientLogin(){
		//�������
		JLabel jlbl1 = new JLabel(new ImageIcon("image/tou.gif"));
		this.add(jlbl1,"North");
		//�м����
		jtp1 = new JTabbedPane(); // �����м�������
		jp2 = new JPanel(new GridLayout(3,3));// ��������
		jp3 = new JPanel(new GridLayout(3,3));//����
		jp4 = new JPanel(new GridLayout(3,3));//����
		//jtp1.add(jp2,"YY����");jtp1.add(jp3,"�ֻ�����");jtp1.add(jp4,"��������");
		jlbl2 = new JLabel("YY����",JLabel.CENTER);//����
		jlbl3 = new JLabel("YY����",JLabel.CENTER);//����
		jlbl4 = new JLabel("��������",JLabel.CENTER);//����
		jlbl4.setForeground(Color.BLUE);//����
		jlbl5 = new JLabel("���뱣��",JLabel.CENTER);//����
		jtf1 = new JTextField();//����
		jpf1 = new JPasswordField();//����
		//�ֻ�ҳ��
		jlbl6 = new JLabel("�ֻ�����",JLabel.CENTER);
		jlbl7 = new JLabel("������֤��",JLabel.CENTER);
		jlbl8 = new JLabel("������֤��",JLabel.CENTER);
		jlbl7.setForeground(Color.BLUE);
		jlbl9 = new JLabel("ȡ��",JLabel.CENTER);
		jlbl9.setForeground(Color.BLACK);
		jtf2 = new JTextField();
		jpf2 = new JPasswordField();
		jcb6 = new JCheckBox("�Զ���¼");
		jcb7 = new JCheckBox("��ס�ֻ�");
		jcb8 = new JCheckBox("�����¼");
		jp3.add(jlbl6);jp3.add(jtf2);jp3.add(jlbl7);
		jp3.add(jlbl8);jp3.add(jpf2);jp3.add(jlbl9);
		jp3.add(jcb6);jp3.add(jcb7);jp3.add(jcb8);
//		this.add(jp3);
		//��������
		jlbl10 = new JLabel("�����ַ",JLabel.CENTER);
		jlbl11 = new JLabel("��������",JLabel.CENTER);
		jlbl12 = new JLabel("���",JLabel.CENTER);
		jlbl13 = new JLabel("��������",JLabel.CENTER);
		jtf3 = new JTextField();
		jpf3 = new JPasswordField();
		jcb3 = new JCheckBox("��ס����");
		jcb4 = new JCheckBox("�Զ���¼");
		jcb3 = new JCheckBox("��ס����");
		jcb5 = new JCheckBox("�����¼");
		jp4.add(jlbl10);jp4.add(jtf3);jp4.add(jlbl12);
		jp4.add(jlbl11);jp4.add(jpf3);jp4.add(jlbl13);
		jp4.add(jcb3);jp4.add(jcb4);jp4.add(jcb5);
		
		jb4 = new JButton(new ImageIcon("image/clear.gif"));//����
		jcb1 = new JCheckBox("�����¼");//����
		jcb2 = new JCheckBox("��������");//����
		jp2.add(jlbl2);jp2.add(jtf1);jp2.add(jb4);//�������
		jp2.add(jlbl3);jp2.add(jpf1);jp2.add(jlbl4);//
		jp2.add(jcb1);jp2.add(jcb2);jp2.add(jlbl5);//
		jtp1.add(jp2,"YY����");jtp1.add(jp3,"�ֻ�����");jtp1.add(jp4,"��������");//��ҳ
		
		this.add(jtp1);
		
		//�ײ����
		jb1 = new JButton(new ImageIcon("image/denglu.gif"));//����
		jb1.addActionListener(this);//������¼��ť
		jb2 = new JButton(new ImageIcon("image/zhuce.gif"));//����
		jb3 = new JButton(new ImageIcon("image/quxiao.gif"));//����
		jp1 = new JPanel();//����
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
			
			//������֤
			Message mess =  new ClientConnetion().loginValidate(user);
			if(mess.getMessageType().equals("1")){
				new FriendList(userName);
				this.dispose(); 
			}else{
				JOptionPane.showMessageDialog(this,"�������");
			}
			
			
			
		}
			
		
	}

}
