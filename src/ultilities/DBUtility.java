package ultilities;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.naming.NamingException;

public class DBUtility {
	
	private static Connection cn;
	
	public static Connection getConnection() throws SQLException, ClassNotFoundException{
		Class.forName("com.mysql.jdbc.Driver");
		cn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/student_info","root","");
		//DatabaseMetaData d = cn.getMetaData();
		//System.out.println(d.getDatabaseProductName());
		return cn;
	}
	/*public static void main(String[] args) throws SQLException, ClassNotFoundException {
		getConnection();
	}*/
}

