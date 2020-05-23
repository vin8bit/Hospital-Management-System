import java.sql.*;
import java.io.*;

class Count1
{ 
	String sys="system";
	String pass="system";
	 Connection con;
	 Statement stm;
	 ResultSet rs;
	 String names,roll_no1;
	 int column,h;
	 String n[]=new String[4];
	int rowCount,rowCount2,rowCount3,rowCount4,rowCount5;
	int r;
	public Count1() throws Exception
	{         
	}
	public  int call()throws Exception
	{
		
			Class.forName("oracle.jdbc.driver.OracleDriver");
		            
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe",sys,pass);
			stm= con.createStatement(); 
			rs= stm.executeQuery("SELECT COUNT(*)  FROM registration ");
			rs.next();
			int rowCount=rs.getInt(1);	
			rs.close();
			stm.close();
			con.close();
			
			return rowCount;
	}
	
	public  int call2()throws Exception
	{
		
			Class.forName("oracle.jdbc.driver.OracleDriver");
		            
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe",sys,pass);
			stm= con.createStatement(); 
			rs= stm.executeQuery("SELECT COUNT(*)  FROM receipt ");
			rs.next();
			int rowCount2=rs.getInt(1);	
			rs.close();
			stm.close();
			con.close();
			
			return rowCount2;
	}
	
	public  int call3()throws Exception
	{
		
			Class.forName("oracle.jdbc.driver.OracleDriver");
		            
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe",sys,pass);
			stm= con.createStatement(); 
			rs= stm.executeQuery("SELECT COUNT(*)  FROM staff ");
			rs.next();
			int rowCount3=rs.getInt(1);	
			rs.close();
			stm.close();
			con.close();
			
			return rowCount3;
	}
	
	public  int call4()throws Exception
	{
		
			Class.forName("oracle.jdbc.driver.OracleDriver");
		            
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe",sys,pass);
			stm= con.createStatement(); 
			rs= stm.executeQuery("SELECT COUNT(*)  FROM room ");
			rs.next();
			int rowCount4=rs.getInt(1);	
			rs.close();
			stm.close();
			con.close();
			
			return rowCount4;
	}
	
	public  int call5()throws Exception
	{
		
			Class.forName("oracle.jdbc.driver.OracleDriver");
		            
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe",sys,pass);
			stm= con.createStatement(); 
			rs= stm.executeQuery("SELECT COUNT(*)  FROM ward ");
			rs.next();
			int rowCount5=rs.getInt(1);	
			rs.close();
			stm.close();
			con.close();
			
			return rowCount5;
	}
	
public static void main(String []args) throws Exception
	{
		Count1 d=new Count1();	
	}
}	





















