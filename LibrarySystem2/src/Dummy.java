import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import com.cg.dbconnection.DBConnect;

public class Dummy
{
	public static void main(String []  args) throws SQLException
	{
		Connection conn=DBConnect.GetDBConnection();
		
		String sql="INSERT INTO Book VALUES (4,'Java','9th-Edition',20,320)"; 
		Statement st=conn.createStatement();
		st.execute(sql);
	}
}
