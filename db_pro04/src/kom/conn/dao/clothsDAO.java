package kom.conn.dao;

import java.io.File;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.conn.db.DBConn;
import com.join.vo.JoinVo;

import kom.conn.VO.clothsVO;

public class clothsDAO {
	private DBConn db;
	
	public clothsDAO() {
		//local / docker
		try {
			db = new DBConn(new File(System.getProperty("user.home") + "/oracle_db.conf"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	} 
	public boolean adminAdd(clothsVO data) {
		
		String query ="INSERT INTO TB_SYSTEM VALUES(?, ?)";
				
		try {
			PreparedStatement pstat = db.getPstat(query);
			pstat.setString(1, data.getAdminid());
			pstat.setString(2, data.getPassword());
			
			int result = db.sendInsertQuery();
			
			if(result ==1)
				return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public boolean add(clothsVO data) {
		
		String query ="INSERT INTO TB_CLOTHS VALUES(?, ?, ?, ?, ?, ?, SYSDATE)";
				
		try {
			PreparedStatement pstat = db.getPstat(query);
			pstat.setString(1, data.getBrandCode());
			pstat.setString(2, data.getProductCode());
			pstat.setString(3, data.getProductName());
			pstat.setInt(4, data.getPrice());
			pstat.setInt(5, data.getCounts());
			pstat.setString(6, Character.toString(data.getDelYn()));
			
			int result = db.sendInsertQuery();
			
			if(result ==1)
				return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}


	public boolean modify(clothsVO data) {
		//데이터 수정
		String query = ""
				+ "UPDATE TB_CLOTHS"
				+ "   SET PRODUCT_CODE = ?"
				+ "     , PRODUCT_NAME = ?"
				+ "     , PRICE = ?"
				+ "     , COUNTS = ?"
				+ "     , DEL_YN = ?"
				+ " WHERE BRAND_CODE = ?";
		try {
			PreparedStatement pstat = db.getPstat(query);
			pstat.setString(1, data.getProductCode());
			pstat.setString(2, data.getProductName());
			pstat.setInt(3, data.getPrice());
			pstat.setInt(4, data.getCounts());
			pstat.setString(5, Character.toString(data.getDelYn()));
			pstat.setString(6, data.getBrandCode());
			
			int rs = db.sendUpdateQuery();
			
			if (rs ==1) {
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	public boolean remove(clothsVO data) {
		// 데이터 삭제(탈퇴)
		String query = "DELETE FROM TB_SYSTEM WHERE ADMIN_NAME_ID = ?";
		try {
			PreparedStatement pstat = db.getPstat(query);
			pstat.setString(1, data.getAdminid());
		
			int rs = db.sendDeletetQuery();
			
			if (rs ==1) {
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	public boolean removeCode(clothsVO data) {
		// 데이터 삭제(탈퇴)
		String query = "DELETE FROM TB_CLOTHS WHERE PRODUCT_CODE = ?";
		try {
			PreparedStatement pstat = db.getPstat(query);
			pstat.setString(1, data.getProductCode());
		
			int rs = db.sendDeletetQuery();
			
			if (rs ==1) {
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	public clothsVO get(String adminid) {
		//데이터 조회
		String query ="SELECT * FROM TB_SYSTEM WHERE ADMIN_NAME_ID = ?";
		
	try {
		PreparedStatement pstat = db.getPstat(query);
		pstat.setString(1, adminid);
		
		ResultSet rs = db.sendSelectQuery();
		
		if (rs.next()) {
			clothsVO data = new clothsVO();
			data.setAdminid(rs.getString("ADMIN_NAME_ID"));
			data.setPassword(rs.getString("PASSWORD"));
			return data;
		}
	} catch (Exception e) {
		e.printStackTrace();
	}
	return null;
}		
	public clothsVO gett(String adminid) {
		//데이터 조회
		String query ="SELECT * FROM TB_CLOTHS WHERE BRAND_CODE = ?";
		
	try {
		PreparedStatement pstat = db.getPstat(query);
		pstat.setString(1, adminid);
		
		ResultSet rs = db.sendSelectQuery();
		
		if (rs.next()) {
			clothsVO data = new clothsVO();
			data.setBrandCode(rs.getString("BRAND_CODE"));
			data.setProductCode(rs.getString("PRODUCT_CODE"));
			data.setProductName(rs.getString("PRODUCT_NAME"));
			data.setPrice(rs.getString("PRICE"));
			data.setCounts(rs.getString("COUNTS"));
			data.setDelYn(rs.getString("DEL_YN").charAt(0));
			data.setRegistDt(rs.getDate("REGIST_DT"));
			return data;
		}
	} catch (Exception e) {
		e.printStackTrace();
	}
	return null;
}		
	public clothsVO pget(String pCode) {
		//데이터 조회
		String query ="SELECT * FROM TB_CLOTHS WHERE PRODUCT_CODE = ?";
		
	try {
		PreparedStatement pstat = db.getPstat(query);
		pstat.setString(1, pCode);
		
		ResultSet rs = db.sendSelectQuery();
		
		if (rs.next()) {
			clothsVO data = new clothsVO();
			data.setBrandCode(rs.getString("BRAND_CODE"));
			data.setProductCode(rs.getString("PRODUCT_CODE"));
			data.setProductName(rs.getString("PRODUCT_NAME"));
			data.setPrice(rs.getString("PRICE"));
			data.setCounts(rs.getString("COUNTS"));
			data.setDelYn(rs.getString("DEL_YN").charAt(0));
			data.setRegistDt(rs.getDate("REGIST_DT"));
			return data;
		}
	} catch (Exception e) {
		e.printStackTrace();
	}
	return null;
}		
	}
	

