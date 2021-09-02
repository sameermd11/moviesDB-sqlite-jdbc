import java.sql.*;
public class connect {
	public static void connect1()
	{
		Connection con=null;
		try {
			String url="jdbc:sqlite:C:/sqlite/MoviesInfo.db";
			con=DriverManager.getConnection(url);
			System.out.println("Connection Successful");
		}
		catch(SQLException e){
			System.out.println(e.getMessage());
			}
		finally {
			try {
				if(con!=null)
					con.close();
				}
			catch(SQLException ex) {
				System.out.println(ex.getMessage());
			}
		}
	}
	public static void main(String[] args)
	{
		connect1();
	}

}
