// ȸ������ �� �Էµ� ������ DB�� ����

package DB;

import Bean.Member;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

public class Join_DB {

	private int r = 0;
	
	public Join_DB(Member inform) {
			
		Connection conn = null;
	    Statement stmt = null;

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test1?characterEncoding=UTF-8&serverTimezone=UTC","root","1234");
			stmt = (Statement) conn.createStatement();
			
			// rs = �Էµ� id�� �ִ� ��ġ
			ResultSet rs = stmt.executeQuery("select id,name,pw,phone from test1_1 where id = '"+inform.getId()+"';");
			
			String id=null;
			
			while(rs.next()) {
				id=rs.getString("id");
			}
			
			if(id!=null) {					// �̹� �����ϴ� id�� ��
				stmt.executeUpdate("update test1_1 set id:='"+inform.getId()+"', name:='"+inform.getName()+"', pw:='"+inform.getPw()+"',phone:='"+inform.getPhone()+"'where id='"+inform.getId()+"';");
				for(Member obj : Member.list) {
					if(obj.getId().equals(inform.getId())) {	// �ڏ����� �ִ� ȸ�������� ����
						obj.setName(inform.getName());
						obj.setPw(inform.getPw());
						obj.setPhone(inform.getPhone());
						
						JOptionPane.showMessageDialog(null,"ȸ�������� �Ϸ�� �й��Դϴ�. ȸ�������� �����˴ϴ�.");
						break;
						
					}
				}
				return;
			}
			
			
			r = stmt.executeUpdate("insert into test1_1 (id,name,pw,phone) value ('" +
					inform.getId() + "','" + inform.getName() + "','" + inform.getPw() +"','" +inform.getPhone()+ "')" );

			if( r == 1 )
			{
				JOptionPane.showMessageDialog(null,"ȸ�������� �Ϸ�Ǿ����ϴ�.");
			}else{
				JOptionPane.showMessageDialog(null,"ȸ�������� ���еǾ����ϴ�.");
			}
			
			// �ڷᱸ���� ȸ�� ����
			Member.list.add(new Member(inform.getId(),inform.getName(),inform.getPw(),inform.getPhone(),"","",""));

		}
	      catch (ClassNotFoundException cnfe)  {
	          System.out.println("�ش� Ŭ������ ã�� �� �����ϴ�." + cnfe.getMessage());
	       }
	       catch (SQLException se)  {
	          System.out.println(se.getMessage());
	       }
	       finally  {
	          try  {
	             stmt.close();
	          }
	          catch (Exception e)  {
	          }
	          try  {
	             conn.close();
	          }
	          catch (Exception e)  {
	          }
	       }
	}
}
