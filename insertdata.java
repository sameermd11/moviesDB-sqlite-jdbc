import java.sql.*;
public class insertdata {
	private Connection connect() {
		String url="jdbc:sqlite:C:/sqlite/MoviesInfo.db";
		Connection con=null;
		try {
			con=DriverManager.getConnection(url);
		} catch(SQLException e) {
			System.out.println(e.getMessage());
		}
		return con;
	}
	public void insert(String moviename,String actor,String actress,String director, String year) 
	{
		String sql="INSERT INTO movies (moviename,actor,actress,director,year) VALUES(?,?,?,?,?)";
		try(Connection con=this.connect();
				PreparedStatement pstmt=con.prepareStatement(sql)){
			pstmt.setString(1, moviename);
			pstmt.setString(2, actor);
			pstmt.setString(3, actress);
			pstmt.setString(4, director);
			pstmt.setString(5, year);
			pstmt.executeUpdate();
			System.out.println("Inserted");
		} catch(SQLException e) {
			System.out.println(e.getMessage());
		}

	}
	public static void main(String[] args)
	{
		insertdata in=new insertdata();
		in.insert("Krishh", "Roshan", "Priyanka", "Kumar", "2008");
		in.insert("Krishh 2", "Roshan", "Priyanka", "Kumar", "2012");
		in.insert("Bahubali", "Prabhas", "Anushka", "Rajmouli", "2015");
		in.insert("Bahubali 2", "Prabhas", "Anushka", "Rajmouli", "2017");
				
	}

}
