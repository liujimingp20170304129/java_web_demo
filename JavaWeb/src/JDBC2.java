import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

//�����ݱ�student�в�����������
public class JDBC2 {

	@SuppressWarnings("unused")
	public static void main(String[] args) throws Exception{
		//���ز�ע�����ݿ�����
		Class.forName("com.mysql.jdbc.Driver");
		String url = "jdbc:mysql://localhost:3306/chapter01";
		String username = "root";
		String password = "admin";
		//��ȡ���ݿ�����
		Connection conn = DriverManager.getConnection(url, username, password);
		//��дsql���
		String sql = "insert into student (sname,age,course) values (?,?,?)";
		//��ȡִ�ж���
		PreparedStatement pstat = conn.prepareStatement(sql);
			for (int i=0; i<=2; i++) {
				//Ϊ�ֶθ�ֵ
				pstat.setString(1, "name"+i);
				pstat.setString(2, "22");
				pstat.setString(3, "java");
				//��ӽ���
				pstat.addBatch();
				if(1 %10 == 0) {
					pstat.executeBatch();
					pstat.clearBatch();
				}
			}
			pstat.executeBatch();
			//�ر���Դ
			pstat.close();
			conn.close();
	}

}
