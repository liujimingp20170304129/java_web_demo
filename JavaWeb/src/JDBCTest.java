

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import com.mysql.jdbc.PreparedStatement;


//**************************用数据库语句指定查询表*************************

//方法一
public class JDBCTest {


	public static void main(String[] args)  throws Exception{
		// TODO Auto-generated method stub
		//加载并注册数据库驱动
		Class.forName("com.mysql.jdbc.Driver");
		String url = "jdbc:mysql://localhost:3306/chapter01";
		String username ="root";
		String password = "admin";
		//获取数据库连接
		Connection conn
			=DriverManager.getConnection(url,username,password);
	
		//书写SQL语句
		String sql = "select * from student where sname = ?";
		//获取执行者对象
		PreparedStatement pstat =   (PreparedStatement) conn.prepareStatement(sql);
		//设置参数
		pstat.setString(1, "zhangsan" );
		//执行SQL语句
		ResultSet resultSet = pstat.executeQuery();
		System.out.println("sid|sname|age|course");
		//处理结果集
		while (resultSet.next()) {
			int sid = resultSet.getInt("sid");
			String sname = resultSet.getString("sname");
			String age = resultSet.getString("age");
			String course = resultSet.getString("course");
			System.out.println(sid + "|" + sname + "|" + age + "|"+ course );
		}
		//关闭资源
		resultSet.close();
		pstat.close();
		conn.close();
	}
}


//
////****************************执行数据库语句sql********************************************
//public class JDBCweb {
//
//
//	public static void main(String[] args)  throws Exception{
//		// TODO Auto-generated method stub
//		//加载并注册数据库驱动
//		Class.forName("com.mysql.jdbc.Driver");
//		String url = "jdbc:mysql://localhost:3306/chapter01";
//		String username ="root";
//		String password = "admin";
//		//获取数据库连接
//		Connection conn
//			=DriverManager.getConnection(url,username,password);
//		Statement statement = conn.createStatement();
//		//书写SQL语句
//		String sql = "select * from student ";
//		//执行SQL语句
//		ResultSet resultSet = statement.executeQuery(sql);
//		System.out.println("sid|sname|age|course");
//		//处理结果集
//		while (resultSet.next()) {
//			int sid = resultSet.getInt("sid");
//			String sname = resultSet.getString("sname");
//			String age = resultSet.getString("age");
//			String course = resultSet.getString("course");
//			System.out.println(sid + "|" + sname + "|" + age + "|"+ course );
//		}
//		//关闭资源
//		resultSet.close();
//		statement.close();
//		conn.close();
//	}
//}
//
