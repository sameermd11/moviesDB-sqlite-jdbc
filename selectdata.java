import java.sql.*;
public class selectdata {
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
	public void selectAll() {
		String sql="SELECT moviename, actor, actress, director, year FROM movies";
		try(Connection con=this.connect();
				Statement stmt=con.createStatement();
				ResultSet rs=stmt.executeQuery(sql)){
			while(rs.next()) {
				System.out.println(rs.getString("moviename")+ "\t" + rs.getString("actor")+ "\t" + rs.getString("actress")+ "\t" + rs.getString("director")+ "\t" + rs.getString("year"));
			}
		} catch(SQLException e) {
			System.out.println(e.getMessage());
		}
	}
	public void selectParameters(String actor) {
		String sql="SELECT moviename, actor "
				+ "FROM movies WHERE actor=?";
		try(Connection con=this.connect();
				PreparedStatement pstmt=con.prepareStatement(sql)){
			pstmt.setString(1, actor);
			ResultSet rs= pstmt.executeQuery();
		while (rs.next()) {
			System.out.println(rs.getString("moviename") + "\t" + rs.getString("actor"));
		}
		}catch(SQLException e) {
			System.out.println(e.getMessage());
		}
	}
	public static void main(String[] args)
	{
		selectdata in=new selectdata();
		in.selectAll();
		in.selectParameters("Roshan");
	}

}
