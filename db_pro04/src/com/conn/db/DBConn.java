package com.conn.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import oracle.net.aso.m;

public class DBConn {

	public void localConnect() throws Exception {
		//1. Driver 등록
		Class.forName("oracle.jdbc.driver.OracleDriver");
		
		//2. DBMS 연결
		Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521/XEPDB1","puser1","Kangsl4913112");
		
		//3. Statement 생성
		Statement stat = conn.createStatement();
		
		//4. SQL 질의문 전송 및 반환
		//int rowCount = stat.executeUpdate("INSERT INTO DEPARTMENTS VALUES(280, 'Tester', NULL, 1700)");
		//int rowCount = stat.executeUpdate("UPDATE DEPARTMENTS SET DEPARTMENT_NAME = 'Dept Tester' WHERE DEPARTMENT_ID = 280");
		int rowCount = stat.executeUpdate("DELETE FROM DEPARTMENTS WHERE DEPARTMENT_ID =280");
		System.out.println(rowCount + "개 행이 반영되었습니다.");
		
		ResultSet rs = stat.executeQuery("SELECT * FROM DEPARTMENTS" );
		while(rs.next()) {
				System.out.print(rs.getString(1) + "\t");
				System.out.print(rs.getString(2) + "\t");
				System.out.print(rs.getString(3) + "\t");
				System.out.print(rs.getString(4) + "\n");
		}
		
		//5. 객체 반환
		rs.close();
		stat.close();
		conn.close();
	}
	public void cloudConnect() throws Exception {
		//1. Driver 등록
		Class.forName("oracle.jdbc.driver.OracleDriver");
		
		//2. DBMS 연결
		Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@db202204211937_low?TNS_ADMIN=C:\\Users\\kang\\eclipse\\oracle\\Wallet_DB202204211937_2","rkdtmdgh","Tmdghrkd12345678");
		
		//3. Statement 생성
		Statement stat = conn.createStatement();
		
		//4. SQL 질의문 전송 및 반환
		ResultSet rs = stat.executeQuery("SELECT 'Hello Cloud' FROM DUAL" );
		if(rs.next()) {
			System.out.println(rs.getString(1));
		}
		
		//5. 객체 반환
		rs.close();
		stat.close();
		conn.close();
	}
	
	public static void main(String[] args) throws Exception {
		DBConn myDB = new DBConn();
		myDB.localConnect();
		myDB.cloudConnect();
		
	}

}
