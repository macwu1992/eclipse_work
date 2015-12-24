import java.sql.*;


public class TestJDBC {

	public static void main(String[] args) throws Exception {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/samp_db","root","");
			System.out.println("conn--------" + conn);
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("select * from dept");
			while(rs.next()){
				System.out.println(rs.getString("dname"));
			}
		}
}
