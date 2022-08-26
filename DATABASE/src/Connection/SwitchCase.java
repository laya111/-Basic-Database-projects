package Connection;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;
import java.sql.SQLException;

public class SwitchCase {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String driver ="com.mysql.jdbc.Driver";
		String Url="jdbc:mysql:///student1";
		String user ="root";
		String pwd=null;
		Scanner sc = new Scanner(System.in);
        String sql;
        ResultSet rs;
        PreparedStatement stm;
        while (true) {
            try {
                System.out.println("WELCOME TO DATABASE MANAGEMENT SYSTEM :) ");
                System.out.println("1 : To View / search Data From Table ");
                System.out.println("2 : To Add Data In the Table  ");
                System.out.println("3 : To Delete Record From Table ");
                System.out.println("4 : To Update Record In Table");
                System.out.println(" ");
                System.out.println("Enter your choice :-  ");
                int b, a = sc.nextInt();

                Class.forName(driver);

                Connection con = DriverManager.getConnection(Url,user,pwd);

                Statement stmt = con.createStatement();
                

                switch (a) {
                    case 1: {
                        System.out.println("1 : Search By Id ");
                        System.out.println("2 : Search By name ");
                        System.out.println("3 : View Entire Table ");
                        System.out.println("Enter your choice :-  ");
                        b = sc.nextInt();
                        switch (b) {
                            case 1:
                                System.out.println("Enter Id : ");
                                String id = sc.next();
                                sql = "select * from student where stud_id = ? ";
                                stm = con.prepareStatement(sql);
                                stm.setString(1, id);
                                rs = stm.executeQuery();
                                while (rs.next()) {
                                    System.out.println(rs.getInt(1) + "  " + rs.getString(2) + "  " + rs.getString(3));
                                }
                                break;

                            case 2:
                                System.out.println("Enter Name : ");
                                String name = sc.next();
                                sql = "select * from student2 where  first name = ? ";
                                stm = con.prepareStatement(sql);
                                stm.setString(1, name);
                                rs = stm.executeQuery();
                                while (rs.next()) {
                                    System.out.println(rs.getInt(1) + "  " + rs.getString(2) + "  " + rs.getString(3));
                                }
                                break;

                            case 3:
                                rs = stmt.executeQuery("select * from student2 ");
                                // st.executeUpdate(create_query);
                                while (rs.next()) {
                                    System.out.println(rs.getInt(1) + "  " + rs.getString(2) + "  " + rs.getString(3));
                                }
                                break;
                        }
                        break;
                    }
                    case 2: {
                        System.out.print("Enter Student Id ");
                        String id = sc.next();
                        System.out.print("Enter First Name ");
                        String fn = sc.next();
                        System.out.print("Enter Last Name ");
                        String ln = sc.next();
                        sql = "insert into student values(?,?,?)";
                        PreparedStatement stm1 = con.prepareStatement(sql);
                        stm1.setString(1, id);
                        stm1.setString(2, fn);
                        stm1.setString(3, ln);
                        stm1.executeUpdate();
                        rs = stmt.executeQuery("select * from student2 ");
                        while (rs.next()) {
                            System.out.println(rs.getInt(1) + "  " + rs.getString(2) + "  " + rs.getString(3));
                        }
                        break;
                    }

                    case 3: {
                        System.out.println("Enter Stud Id TO Delete Rrcord ");
                        String accno = sc.next();
                        sql = "DELETE FROM student WHERE stud_id = ?";
                        PreparedStatement stm1 = con.prepareStatement(sql);
                        stm1.setString(1, accno);
                        stm1.executeUpdate();
                        rs = stmt.executeQuery("select * from student2 ");
                        while (rs.next()) {
                            System.out.println(rs.getInt(1) + "  " + rs.getString(2) + "  " + rs.getString(3));
                        }
                        break;
                    }
                    case 4: {
                        System.out.println("1 : To Change First Name ");
                        System.out.println("2 : To Change Second Name ");
                        b = sc.nextInt();
                        if (b == 1) {
                            System.out.println("Enter Id to Change Name ");
                            String accno = sc.next();
                            System.out.println("Enter New Name to Change  ");
                            String name = sc.next();
                            sql = "update  student  set  first name  = ? where stud_id= ?";
                            stm = con.prepareStatement(sql);
                            stm.setString(1, name);
                            stm.setString(2, accno);
                            stm.executeUpdate();
                            System.out.println("After Updating Table   ");
                            rs = stmt.executeQuery("select * from student2 ");
                            while (rs.next()) {
                                System.out.println(rs.getInt(1) + "  " + rs.getString(2) + "  " + rs.getString(3));
                            }
                        } else {
                            System.out.println("Enter Id to Change Name ");
                            String accno = sc.next();
                            System.out.println("Enter New Name to Change  ");
                            String name = sc.next();
                            sql = "update  student  set  last name  = ? where stud_id= ?";
                            stm = con.prepareStatement(sql);
                            stm.setString(1, name);
                            stm.setString(2, accno);
                            stm.executeUpdate();
                            System.out.println("After Updating Table   ");
                            rs = stmt.executeQuery("select * from student2 ");
                            while (rs.next()) {
                                System.out.println(rs.getInt(1) + "  " + rs.getString(2) + "  " + rs.getString(3));
                            }
                        }
                        break;
                    }
                }
                con.close();

            } catch (ClassNotFoundException e) {
                System.out.println(e);
            } catch (SQLException e) {
                System.out.println(e);
            } catch (Exception e) {
                System.out.println(e);
            }
        }
	}

}
