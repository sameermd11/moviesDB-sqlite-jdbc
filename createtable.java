import java.sql.*;
public class createtable {
	public static void createNewTable()
	{
		String url="jdbc:sqlite:C:/sqlite/MoviesInfo.db";
		String sql="CREATE TABLE movies ("
				+"moviename	TEXT NOT NULL,"
				+"actor	TEXT NOT NULL,"
				+"actress	TEXT NOT NULL,"
				+"director	TEXT NOT NULL,"
				+"year	TEXT NOT NULL,"
				+"PRIMARY KEY(moviename)"
			+");";
		try(Connection con=DriverManager.getConnection(url);
				Statement stmt=con.createStatement()) {
			stmt.execute(sql);
			System.out.println("Table created");
		} catch(SQLException e) {
			System.out.println(e.getMessage());
		}
		
	}
	public static void main(String[] args)
	{
		createNewTable();
	}

}
