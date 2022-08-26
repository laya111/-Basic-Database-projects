package Connection;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Delete {
	private static String DELETE_QUERY="delete from anml where Name='Lion'";
	private static String driver ="com.mysql.jdbc.Driver";
	private static String Url="jdbc:mysql:///Animal";
	private static String user ="root";
	private static String pwd=null;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 Connection con=null;
         Statement st=null;
         try {
      	   Class.forName(driver);
      	   con=DriverManager.getConnection(Url,user,pwd);
      	    st=con.createStatement();
      	    int recordCount= st.executeUpdate(DELETE_QUERY);
      	    System.out.println(recordCount+"Records deleted...");
         }catch(SQLException e)
         {
      	   e.printStackTrace();
         }catch(Exception e) {
      	   e.printStackTrace();
         }
        finally {
      	  try {
      		  st.close();
      	  }catch(SQLException e) {
      		  e.printStackTrace();
      	  }
	}

}
}
