

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import com.mysql.jdbc.PreparedStatement;


//**************************�����ݿ����ָ����ѯ��*************************

//����һ
public class JDBCTest {


	public static void main(String[] args)  throws Exception{
		// TODO Auto-generated method stub
		//���ز�ע�����ݿ�����
		Class.forName("com.mysql.jdbc.Driver");
		String url = "jdbc:mysql://localhost:3306/chapter01";
		String username ="root";
		String password = "admin";
		//��ȡ���ݿ�����
		Connection conn
			=DriverManager.getConnection(url,username,password);
	
		//��дSQL���
		String sql = "select * from student where sname = ?";
		//��ȡִ���߶���
		PreparedStatement pstat =   (PreparedStatement) conn.prepareStatement(sql);
		//���ò���
		pstat.setString(1, "zhangsan" );
		//ִ��SQL���
		ResultSet resultSet = pstat.executeQuery();
		System.out.println("sid|sname|age|course");
		//��������
		while (resultSet.next()) {
			int sid = resultSet.getInt("sid");
			String sname = resultSet.getString("sname");
			String age = resultSet.getString("age");
			String course = resultSet.getString("course");
			System.out.println(sid + "|" + sname + "|" + age + "|"+ course );
		}
		//�ر���Դ
		resultSet.close();
		pstat.close();
		conn.close();
	}
}


//
////****************************ִ�����ݿ����sql********************************************
//public class JDBCweb {
//
//
//	public static void main(String[] args)  throws Exception{
//		// TODO Auto-generated method stub
//		//���ز�ע�����ݿ�����
//		Class.forName("com.mysql.jdbc.Driver");
//		String url = "jdbc:mysql://localhost:3306/chapter01";
//		String username ="root";
//		String password = "admin";
//		//��ȡ���ݿ�����
//		Connection conn
//			=DriverManager.getConnection(url,username,password);
//		Statement statement = conn.createStatement();
//		//��дSQL���
//		String sql = "select * from student ";
//		//ִ��SQL���
//		ResultSet resultSet = statement.executeQuery(sql);
//		System.out.println("sid|sname|age|course");
//		//��������
//		while (resultSet.next()) {
//			int sid = resultSet.getInt("sid");
//			String sname = resultSet.getString("sname");
//			String age = resultSet.getString("age");
//			String course = resultSet.getString("course");
//			System.out.println(sid + "|" + sname + "|" + age + "|"+ course );
//		}
//		//�ر���Դ
//		resultSet.close();
//		statement.close();
//		conn.close();
//	}
//}
//
