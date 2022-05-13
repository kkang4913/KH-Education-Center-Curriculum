package com.join.dao;

import java.io.File;
import java.sql.PreparedStatement;
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
		// 데이터 추가(회원가입)					//문자열,숫자 상관없이 ? 작성
		String query = "INSERT INTO accounts VALUES(?, ?, ?, ?, ?,  SYSDATE)";
//					,data.getUserid()
//					,data.getUserpw()
//					,data.getUsername()
//					,data.getGender()
//					,data.getAge()
//				); 
		
		try {
			// try 안으로 이동
			PreparedStatement pstat = db.getPstat(query);
			pstat.setString(1, data.getUserid());		//첫 번째 ? , 들어갈 값
			pstat.setString(2, data.getUserpw());		//두 번째 ? , 들어갈 값 ...등
			pstat.setString(3, data.getUsername());
			pstat.setString(4, Character.toString(data.getGender()));  //문자열로 변경
			pstat.setInt(5, data.getAge());		
			
			int result = db.sendInsertQuery();
			
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
		String query =""
				+ "UPDATE accounts"
				+ "   SET USERPW = ?"
				+ "     , USERNAME = ?"
				+ "     , GENDER = ?"
				+ "     , AGE = ?"
				+ " WHERE USERID = ?";
		try {
			PreparedStatement pstat = db.getPstat(query);
			pstat.setString(1, data.getUserpw());
			pstat.setString(2, data.getUsername());
			pstat.setString(3, Character.toString(data.getGender()));
			pstat.setInt(4, data.getAge());
			pstat.setString(5, data.getUserid());
			
			int rs = db.sendUpdateQuery();
			
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
		String query = "DELETE FROM accounts WHERE ID = ?";
		try {
			PreparedStatement pstat = db.getPstat(query);
			pstat.setString(1, data.getUserid());
		
			int rs = db.sendDeletetQuery();
			
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
		String query ="SELECT * FROM accounts WHERE ID = ?";
	
	try {
		PreparedStatement pstat = db.getPstat(query);
		pstat.setString(1, userid);
		
		ResultSet rs = db.sendSelectQuery();
		
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
	
	

