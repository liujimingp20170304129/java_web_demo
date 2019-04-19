import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

//向数据表student中插入三条数据
public class JDBC2 {

	@SuppressWarnings("unused")
	public static void main(String[] args) throws Exception{
		//加载并注册数据库驱动
		Class.forName("com.mysql.jdbc.Driver");
		String url = "jdbc:mysql://localhost:3306/chapter01";
		String username = "root";
		String password = "admin";
		//获取数据库连接
		Connection conn = DriverManager.getConnection(url, username, password);
		//书写sql语句
		String sql = "insert into student (sname,age,course) values (?,?,?)";
		//获取执行对象
		PreparedStatement pstat = conn.prepareStatement(sql);
			for (int i=0; i<=2; i++) {
				//为字段赋值
				pstat.setString(1, "name"+i);
				pstat.setString(2, "22");
				pstat.setString(3, "java");
				//添加进批
				pstat.addBatch();
				if(1 %10 == 0) {
					pstat.executeBatch();
					pstat.clearBatch();
				}
			}
			pstat.executeBatch();
			//关闭资源
			pstat.close();
			conn.close();
	}

}
