package Utils;
import java.sql.*;
import java.util.*;
public class DBhelper {
		 private Connection con;
		 private Statement statement;
		 public DBhelper()
		 { 
		     String driver = "com.mysql.jdbc.Driver";
		     String url = "jdbc:mysql://127.0.0.1:3306/Hotel";
		     String user = "HotelKing";
		     String password = "123456789A";
		    try {
		        Class.forName(driver);
		        con = DriverManager.getConnection(url,user,password);
		        if(!con.isClosed())
		            System.out.println("Succeeded connecting to the Database!");
		    } catch(ClassNotFoundException e) {   
		        System.out.println("Sorry,can`t find the Driver!");   
		        e.printStackTrace();   
		        } catch(SQLException e) {
		        e.printStackTrace();  
		        }catch (Exception e) {
		        e.printStackTrace();
		    }finally{
		    	 System.out.println("数据库数据成功获取！！");
		    }
		}
		 public Connection getCon()
		 { 
		  return this.con;
		 }
		 
		 public ResultSet query(String sql)
		 {
		  try{
		      statement = con.createStatement(); 
		      ResultSet rs = statement.executeQuery(sql);
		      //con.close();
		      return rs;
		  }catch(SQLException e) {
		         e.printStackTrace();  
		         }catch (Exception e) {
		         e.printStackTrace();
		     }
		  ResultSet rstmp = null;
		  return rstmp;
		 }
}
