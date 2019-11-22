package Bookmanager;

import Bookmanager.*;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.*;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JList;

public class Join_Frame extends JFrame {
	
	private Statement stmt = null;
	private ResultSet rs = null;
	private int r = 0;
	private JPanel panel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Join_Frame() {
		
		setTitle("ȸ�� ����");
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		setSize(400,300);	
		setLocationRelativeTo(null);	
		setResizable(false);
		
		panel = new JPanel();
		panel.setBackground(Color.WHITE);
		
		panel.setLayout(null);

		JLabel Title=new JLabel("�ߡ� ȸ������ �ޡ�");
		Title.setFont(new Font("���õ������ Bold", Font.PLAIN, 13));
		Title.setBounds(147,30,1000,25);
		panel.add(Title);

		// �й� text
		JLabel ID_Label=new JLabel("�й�");
		ID_Label.setFont(new Font("���õ������ Bold", Font.PLAIN, 12));
		ID_Label.setBounds(90, 70, 80, 25);	
		panel.add(ID_Label);

		// �̸� text
		JLabel Name_Label = new JLabel("�̸�");
		Name_Label.setFont(new Font("���õ������ Bold", Font.PLAIN, 12));
		Name_Label.setBounds(90, 100, 80, 25);
		panel.add(Name_Label);

		// pw text
		JLabel PW_Label = new JLabel("PW");
		PW_Label.setFont(new Font("���õ������ Bold", Font.PLAIN, 12));
		PW_Label.setBounds(90,130,80,25);	
		panel.add(PW_Label);

		// phone text
		JLabel Phone_Lable = new JLabel("PHONE");
		Phone_Lable.setFont(new Font("���õ������ Bold", Font.PLAIN, 12));
		Phone_Lable.setBounds(80,160,80,25);	
		panel.add(Phone_Lable);

		// �й� text box
		JTextField id = new JTextField(20); 
		id.setBackground(new Color(248, 248, 255));
		id.setBounds(130, 70, 160, 25);	
		panel.add(id);       

		// �̸� text box
		JTextField name = new JTextField(20);
		name.setBackground(new Color(248, 248, 255));
		name.setBounds(130, 100, 160, 25);	
		panel.add(name);

		// pw text box
		JTextField pw = new JTextField(20);
		pw.setBackground(new Color(248, 248, 255));
		pw.setBounds(130, 130, 160, 25);	
		panel.add(pw);

		// phone text box
		JTextField phone = new JTextField(20);
		phone.setBackground(new Color(248, 248, 255));
		phone.setBounds(130, 160, 160, 25);	
		panel.add(phone);

		// join button ���� & Ŭ�� �̺�Ʈ �߻� ��
		JButton Join_B = new JButton("JOIN");	
		Join_B.setBackground(Color.WHITE);
		Join_B.setFont(new Font("���õ������ Bold", Font.PLAIN, 12));
		Join_B.setBounds(160,200,70,30);		
		panel.add(Join_B);

		Join_B.addActionListener(new ActionListener() {		
			public void actionPerformed(ActionEvent e) {

				// �Էµ� ���� DB�� ����
				Join_Bean joinbean=new Join_Bean(id.getText(),name.getText(),pw.getText(),phone.getText());
				new Join_DAO(joinbean);
				
				setVisible(false);		
			}
		});
		
		setContentPane(panel);
		
		setVisible(true);		
	}
}
