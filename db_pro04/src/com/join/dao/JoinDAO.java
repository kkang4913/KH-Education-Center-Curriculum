package com.join.dao;

import java.io.File;
import java.sql.ResultSet;

import com.conn.db.DBConn;
import com.join.vo.JoinVo;

public class JoinDAO {
	private DBConn db;
	
	public JoinDAO() {
		//local / docker
		try {
			db = new DBConn(new File(System.getProperty("user.home") + "/oracle_db.conf"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	} 
	//오라클 클라우드
//	try {
//		db = new DBConn(new File(System.getProperty("user.home") + "/oracle_db2.conf"));
//	} catch (Exception e) {
//		e.printStackTrace();
//	}
//}
//	public JoinDAO() {
//		try {
//			db = new DBConn("localhost","1521","XEPDB1","puser1","Kangsl4913112");
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}
//	try {
//		db = new DBConn("db202204211937_low","1521","rkdtmdgh","Tmdghrkd12345678");
//	} catch (Exception e) {
//		e.printStackTrace();
//	}
//}
	public boolean add(JoinVo data) {
		// 데이터 추가(회원가입)
		String query = String.format("INSERT INTO accounts VALUES('%s', '%s', '%s', '%c', %d, SYSDATE)"
					,data.getUserid()
					,data.getUserpw()
					,data.getUsername()
					,data.getGender()
					,data.getAge()
				); 
		
		try {
			int result = db.sendInsertQuery(query);
			
			if (result == 1) {
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public boolean modify(JoinVo data) {
		// 데이터 수정
		String query = "" 
				+ "UPDATE accounts "
				+ "SET PW ='" + data.getUserpw() + "'"
				+ "    ,NAME ='" +data.getUsername() + "'"
				+ "	   ,GENDER ='" + data.getGender() + "'"
				+ "    ,AGE = " + data.getAge()
				+ "    WHERE ID = '" + data.getUserid() + "'";
		try {
			int rs = db.sendUpdateQuery(query);
			
			if (rs ==1) {
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	
	public boolean remove(JoinVo data) {
		// 데이터 삭제(탈퇴)
		String query = "" 
				+ "DELETE FROM accounts "
				+ "    WHERE ID = '" + data.getUserid() + "'";
		try {
			int rs = db.sendDeletetQuery(query);
			
			if (rs ==1) {
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	
	
	public JoinVo get(String userid) {
		// 단일 데이터 조회
		String query = String.format("SELECT * FROM accounts WHERE ID = '%s'", userid); 
	
	try {
		ResultSet rs = db.sendSelectQuery(query);
		
		if (rs.next()) {
			JoinVo data = new JoinVo();
			data.setUserid(rs.getString("ID"));
			data.setUserpw(rs.getString("PW"));
			data.setUsername(rs.getString("NAME"));
			data.setGender(rs.getString("GENDER").charAt(0));
			data.setAge(rs.getInt("AGE"));
			data.setCreateDate(rs.getDate("CREATEDATE"));
			return data;
		}
	} catch (Exception e) {
		e.printStackTrace();
	}
	return null;
}		
	}
	
	

