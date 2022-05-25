package com.conn.db;

import java.sql.ResultSet;

import com.conn.db.DBConn;

public class Employees {

	private DBConn db;
	
	public Employees() {
//		try {
//			db = new DBConn("db202204211937_medium","C:\\Users\\kang\\eclipse\\oracle\\Wallet_DB202204211937_2","rkdtmdgh","Tmdghrkd12345678");
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
		try {
			db = new DBConn("localhost","1521","XEPDB1","puser1","Kangsl4913112");
		} catch (Exception e) {
			e.printStackTrace();
		}
		}
	public void getSalary(int salary)  {
		/*
		 * salary 에 해당하는 데이터를 조회하여 출력해보기. 출력에 사용할 컬럼은 EMPLOYEE_ID, FIRST_NAME,
		 * LAST_NAME, SALARY 로 한다.
		 */
		String query = "SELECT EMPLOYEE_ID, FIRST_NAME,LAST_NAME,SALARY FROM EMPLOYEES WHERE SALARY = " + salary;
		try {
			ResultSet rs = db.sendSelectQuery(query);
			while (rs.next()) {
				System.out.println("----------------------------------------------");
				System.out.println("EMPLOYEE_ID : " + rs.getInt("EMPLOYEE_ID"));
				System.out.println(" FIRST_NAME : " + rs.getString("FIRST_NAME"));
				System.out.println("  LAST_NAME : " + rs.getString("LAST_NAME"));
				System.out.println("     SALARY : " + rs.getInt("SALARY"));
				System.out.println("----------------------------------------------");
			}
			rs.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
		public void close() {
			try {
				db.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	public static void main(String[] args) {
		Employees emp = new Employees();
		emp.getSalary(4000);
		emp.close();
	}
}
