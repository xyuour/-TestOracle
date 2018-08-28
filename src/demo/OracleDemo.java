package demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class OracleDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 try {
	            Class.forName("oracle.jdbc.driver.OracleDriver");
	        Connection conn=DriverManager.getConnection(
	                "jdbc:oracle:thin:@localhost:1521:YIBIN", "yibin","yibin");
//	        System.out.println("连接成功");
	        Statement st=conn.createStatement();
//	        ResultSet rs=st.executeQuery("SELECT * FROM T_WEB_LM WHERE FIRSTNO = '020139'");
	        ResultSet rs=st.executeQuery("SELECT * FROM T_WEB_LM Order by MODULENO");
//	        System.out.println();
	        int i=0;
	        while(rs.next())
	        {
	        	i += 1;
	        	String firstno = rs.getString("FIRSTNO");
	        	String moduleno = rs.getString("MODULENO");
	            String name=rs.getString("NAME");
//	            System.out.println(i+","+firstno+","+moduleno+","+name);    
	            System.out.println(i+",	"+moduleno+",	"+name);    
	        }
	        rs.close();
	        st.close();
	        conn.close();
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	}

}
