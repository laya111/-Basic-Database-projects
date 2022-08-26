package Connection;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

class Create_st {
   public static String CREATE_QUERY="CREATE TABLE `student`.`stud` (`Name` VARCHAR(10) NOT NULL , `Roll_no` INT(10) NOT NULL , `Std` INT(10) NOT NULL , `Class` INT(10) NOT NULL ) ENGINE = InnoDB;";
	public static void main(String[] args) {
		// TODO Auto-generated method stub
         Connection con=null;
         Statement st=null;
         try {
        	 Class.forName("com.mysql.jdbc.Driver");
        	 con=DriverManager.getConnection("jdbc:mysql:///Student","root",null);
        	 if(con!=null) {
 				System.out.println("Connection created successfully");
 			}
 			else
 			{
 				System.out.println("not created");
 			}
 			 st=con.createStatement();
 			 st.executeUpdate(CREATE_QUERY);
 			 System.out.println("TAble created successfully");
         }catch(ClassNotFoundException e) {
 		    e.printStackTrace();
 		    }
 		    catch(SQLException e) {
 		    	e.printStackTrace();
 		    }catch(Exception e) {
 		    	e.printStackTrace();
 		    }
        
	}

}
