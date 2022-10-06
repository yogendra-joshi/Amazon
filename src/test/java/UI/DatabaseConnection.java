package UI;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseConnection {
	public static void main(String args[]) throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con=DriverManager.getConnection(
				"jdbc:mysql://localhost:3306/amazon_db","root","password");
				
		Statement stmt=con.createStatement();
		/*ResultSet rs=stmt.executeQuery("select * from product_details");
		
		while(rs.next()){
			System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3));  
			con.close();  
			}*/
		String sql = "insert into product_details "
				+"(id, brand, model, amount)"
				+" values('2', 'samsung', 'a13', '16000')";
		stmt.executeUpdate(sql);
		
	}
}