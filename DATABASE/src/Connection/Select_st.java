package Connection;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Select_st {
   

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql:///Movies","root",null);
			if(con!=null) {
				System.out.println("Connection created successfully");
			}
			else
			{
				System.out.println("not created");
			}
			Statement st=con.createStatement();
		     ResultSet rs=st.executeQuery("select * from movies2");
		    while(rs.next())
		    {
		    	System.out.println(rs.getString(1)+""+rs.getString(2)+""+rs.getString(3)+""+rs.getString(4));
		    }
		}
		    catch(ClassNotFoundException e) {
		    e.printStackTrace();
		    }
		    catch(SQLException e) {
		    	e.printStackTrace();
		    }catch(Exception e) {
		    	e.printStackTrace();
		    }
	}
	}


