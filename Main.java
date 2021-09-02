import java.sql.*;
public class Main 
{
	public static void createnewDatabase(String fileName)
	{
		String url="jdbc:sqlite:C:/sqlite/"+fileName;
        try(Connection con=DriverManager.getConnection(url))
        {
        	if(con!=null)
        	{
        		DatabaseMetaData meta=con.getMetaData();
        		System.out.println("The driver name is" + meta.getDriverName());
        		System.out.println("A new database has been created.");
        	}
        }catch(SQLException e) {
			System.out.println(e.getMessage());
		}
	}
	public static void main(String[] args)
	{
		createnewDatabase("MoviesInfo.db");
	}
}


