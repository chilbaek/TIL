package com.hive;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class HiveTest {

	public static void main(String[] args) throws Exception {
		String url = "jdbc:hive2://192.168.111.120:10000/default";
		String userid = "root";
		String password = "111111";
		Class.forName("org.apache.hive.jdbc.HiveDriver");
		Connection con = DriverManager.getConnection(url, userid, password);
		PreparedStatement pstmt = con.prepareStatement(
				"SELECT * FROM hdi limit 10");
//				"SELECT Year, avg(ArrDelay), avg(depDelay) FROM airline_delay\r\n" + 
//				"WHERE delayYear=2007\r\n" + 
//				"GROUP BY Year");
		ResultSet rset = pstmt.executeQuery();
		while(rset.next()) {
			String s1 = rset.getString(2);
			float s2 = rset.getFloat(3);
			float s3 = rset.getFloat(4);
			float s4 = rset.getFloat(5);
			System.out.println(s1+" "+s2+" "+s3+" "+s4);
		}
		con.close();
	}
}
