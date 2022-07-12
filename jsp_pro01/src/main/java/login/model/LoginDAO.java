package login.model;

import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.conn.db.DBConn;

import emp.model.EmpDTO;

public class LoginDAO {

	private SqlSession session = DBConn.getSqlSession();
	
	public EmpDTO selectLogin(Map<String,Object> mapData) {
		EmpDTO data = session.selectOne("loginMapper.selectLogin",mapData);
		return data;
		//map 컬렉션을 활용하면 여러 데이터를 전달 가능하다.
	}

	public void commit() {
		session.commit();
	}
	public void rollback() {
		session.rollback();
	}
	public void close() {
		session.close();
	}

}
