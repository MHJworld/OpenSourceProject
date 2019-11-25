package Bookmanager;

import java.awt.*;
import java.sql.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class LoginFrame extends JFrame{

	public LoginFrame() {		// ������
		// Dimension res = Toolkit.getDefaultToolkit().getScreenSize();	// ȭ�� ũ��

		JFrame frame= new JFrame("����å �뿩 ��� ���α׷�");	// JFrame frame ����

		// login panel ����
		JPanel panel = new JPanel();		

		panel.setLayout(null);

		JLabel Title=new JLabel("�ߡ� DRAG ����å �뿩 ��� ���α׷��Դϴ� �ޡ�");
		Title.setBounds(58,40,1000,25);
		panel.add(Title);

		// �й� text
		JLabel Hakbun_Lable=new JLabel("�й�");
		Hakbun_Lable.setBounds(90, 100, 80, 25);	
		panel.add(Hakbun_Lable);

		// pw text
		JLabel pw_Lable = new JLabel("PW");
		pw_Lable.setBounds(90, 130, 80, 25);	
		panel.add(pw_Lable);

		// �й� text box
		JTextField id = new JTextField(20); // �й� text box
		id.setBounds(130, 100, 160, 25);	
		panel.add(id);       

		// pw text box
		JPasswordField pw = new JPasswordField(20);
		pw.setBounds(130, 130, 160, 25);	
		panel.add(pw);

		// login button ���� & Ŭ�� �̺�Ʈ �߻� ��
		JButton login_B = new JButton("LOGIN");	
		login_B.setBounds(130,170,70,30);		
		panel.add(login_B);

		login_B.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				LoginBean loginbean = new LoginBean(id.getText(),pw.getText());
				new LoginDAO(loginbean);
			}
		});

		// join button ���� & Ŭ�� �̺�Ʈ �߻� ��
		JButton join_B = new JButton("JOIN");	
		join_B.setBounds(220,170,70,30);		
		panel.add(join_B);

		join_B.addActionListener(new ActionListener() {		
			public void actionPerformed(ActionEvent e) {
				new JoinFrame();
			}
		});

		frame.getContentPane().add(panel);

		frame.pack();
		frame.setVisible(true);	

		frame.setSize(400,300);					
		frame.setLocationRelativeTo(null);		
		frame.setResizable(false);				

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
	}

	public static void main(String[] args) {

		// ù ����
		new LoginFrame();	
<<<<<<< HEAD
		// hihihihihihihihiererer
	
=======

>>>>>>> 27071b39d295b2afce136297b106ce05513cd48f
	}


}
