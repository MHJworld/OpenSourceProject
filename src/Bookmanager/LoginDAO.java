// �α��� �� �Էµ� �й��� ��й�ȣ�� DB ���� �˻�

package Bookmanager;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

public class LoginDAO {
	private Statement stmt = null;
	private int result=0;

	public LoginDAO(LoginBean inform) {

		Connection conn = null;

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test1?characterEncoding=UTF-8&serverTimezone=UTC","root","1234");

			String qu="select * from test1_1";
			stmt = (Statement) conn.createStatement();
			ResultSet rs=stmt.executeQuery(qu);

			while(rs.next()) {

				String id=rs.getString("id");
				String pw=rs.getString("pw");

				if(id.equals(inform.getId())&&pw.equals(inform.getPw())) {
					JOptionPane.showMessageDialog(null,"�α����� �Ϸ�Ǿ����ϴ�.");
					result=1;
					break;
				}
			}

			// �α��� �� �й��� ��й�ȣ�� ��ġ���� ���� ��
			if(result==0)
				JOptionPane.showMessageDialog(null,"�й��̳� ��й�ȣ�� �߸� �Է��ϼ̽��ϴ�.");


		}
		catch(ClassNotFoundException cnfe){
			System.out.println("�ش� Ŭ������ ã�� �� �����ϴ�." + cnfe.getMessage());
		}

		catch(SQLException se){
			System.out.println(se.getMessage());
		}

		try{

			conn.close();
		}
		catch(SQLException ee){
			System.out.println(ee.getMessage());
		}
	}
}
