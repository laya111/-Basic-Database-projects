package Connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Insert {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Statement st=null;
		Connection con=null;
		
		
		// TODO Auto-generated method stub
       try {
    	   Class.forName("com.mysql.jdbc.Driver");
       }
       catch(ClassNotFoundException e){
    	   e.printStackTrace();
       }
       try {
    	  con=DriverManager.getConnection("jdbc:mysql:///DatabasePrgm","root",null);
    	  
    	   st=con.createStatement();
    	   int RecordCount=st.executeUpdate("Insert into Employee values('125','Priyanka','100000','manager')");
    	System.out.println(RecordCount+" REcords inserted .."); 
    	
       }
       catch(SQLException e){
    	  e.printStackTrace(); 
       }
       catch(Exception e) {
    	   e.printStackTrace();
       }
       finally {
    	   try {
    		   st.close();
    	   }
    	   catch(SQLException e) {
        	   e.printStackTrace();
           }
    	   try {
    		   con.close();
    	   }
    	   catch(SQLException e) {
        	   e.printStackTrace();
           }
    	   
       }
	}

}
