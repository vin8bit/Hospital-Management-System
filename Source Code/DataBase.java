import java.sql.*;


public class DataBase
{
	String username="system";
	String password="system";
	PreparedStatement stm;
	PreparedStatement preparedStmt;
	public DataBase()
	{
		try{
				Class.forName("oracle.jdbc.driver.OracleDriver");
				Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe",username,password);
				String query = "CREATE TABLE  LOGIN (USERNAME VARCHAR2(100), PASSWORD VARCHAR2(100))";
      				preparedStmt = conn.prepareStatement(query);
      				preparedStmt.execute();
				stm =  conn.prepareStatement("insert into login values(?,?)");
			                stm.setString(1,"123");
				stm.setString(2,"romi");
				stm.executeUpdate();
				String query2 = "CREATE TABLE  REGISTRATION (REGISTRATIONID VARCHAR2(100), PATIENTID VARCHAR2(100), NAME VARCHAR2(100), GENDER VARCHAR2(100), AGE VARCHAR2(100), PHONE VARCHAR2(100), ADDRESS VARCHAR2(100), STATUS VARCHAR2(100), BUILDING VARCHAR2(100), ROOMNO VARCHAR2(100), ROOMTYPE VARCHAR2(100), PRICE VARCHAR2(100), DATE1 VARCHAR2(100), DOB VARCHAR2(100))";
      				preparedStmt = conn.prepareStatement(query2);
      				preparedStmt.execute();				
				String query3 = "CREATE TABLE  RECEIPT (REGISTRATIONID VARCHAR2(100), RECEIPT VARCHAR2(100), RECEIPTDATE VARCHAR2(100), DIAGNOSISFEES VARCHAR2(100), XRAYFESS VARCHAR2(100), EGGFESS VARCHAR2(100), NAME VARCHAR2(100), AGE VARCHAR2(100), LABTESTFEES VARCHAR2(100), GASTROSCOPTFEES VARCHAR2(100), USGFESS VARCHAR2(100), GENDER VARCHAR2(100), INDOOR VARCHAR2(100), CALONOSCOPYFEES VARCHAR2(100), TOTALFEES VARCHAR2(100), TIME VARCHAR2(100), DOB VARCHAR2(100))";
      				preparedStmt = conn.prepareStatement(query3);
      				preparedStmt.execute();
				String query4 = "CREATE TABLE  ROOM (ROOMNO VARCHAR2(100), BUILDING VARCHAR2(100), ROOMTYPE VARCHAR2(100), PRICE VARCHAR2(100), DATE2 VARCHAR2(100), TIME VARCHAR2(100), BED_NO VARCHAR2(100))";
      				preparedStmt = conn.prepareStatement(query4);
      				preparedStmt.execute();
				String query5 = "CREATE TABLE  STAFF (ID VARCHAR2(100), NAME VARCHAR2(100), GENDER VARCHAR2(100), POSITION VARCHAR2(100), SALARY VARCHAR2(100), PHONE VARCHAR2(100), ADDRESS VARCHAR2(100), QUALIFICATION VARCHAR2(100), DOB VARCHAR2(100), ID_PROOF VARCHAR2(100))";
      				preparedStmt = conn.prepareStatement(query5);
      				preparedStmt.execute();
				String query6 = "CREATE TABLE  WARD (ROOMNO VARCHAR2(100), FLOOR VARCHAR2(100), BUILDING VARCHAR2(100), ROOMTYPE VARCHAR2(100), NUMBEROFBED VARCHAR2(100), UNITPRICE VARCHAR2(100))";
      				preparedStmt = conn.prepareStatement(query6);
      				preparedStmt.execute();
				System.out.println("Create");

				
				    }
				catch(Exception v) {    }
		}
public static void main(String []args)
	{  new DataBase();  }
}