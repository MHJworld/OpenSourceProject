// ȸ������ �� �Էµ� ������ DB�� ����

package Bookmanager;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

public class JoinDAO {
	private Statement stmt = null;
	private ResultSet rs = null;
	private int r = 0;
	
	public JoinDAO(JoinBean inform) {
			
		Connection conn = null;

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test1?characterEncoding=UTF-8&serverTimezone=UTC","root","1234");

			stmt = (Statement) conn.createStatement();
			r = stmt.executeUpdate("insert into test1_1 " +
					"(id,pw,name,phone) value ('" +
					inform.getId() + "','" + inform.getPw() + "','" + inform.getName() +"','" +inform.getPhone()+ "')" );

			if( r == 1 )
			{
				JOptionPane.showMessageDialog(null,"ȸ�������� �Ϸ�Ǿ����ϴ�.");
			}else{
				JOptionPane.showMessageDialog(null,"ȸ�������� ���еǾ����ϴ�.");
			}

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
