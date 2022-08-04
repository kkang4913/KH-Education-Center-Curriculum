package login.model;


import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.conn.db.DBConn;

import emps.model.EmpsDTO;

public class LoginDAO {

	private SqlSession session = DBConn.getSqlSession();
	
	public EmpsDTO selectLogin(Map<String,Object> mapData) {
		EmpsDTO data = session.selectOne("loginMapper.selectLogin",mapData);
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

	public List<PermDTO> selectPerm(int id) {
		List<PermDTO> data = session.selectList("loginMapper.selectPerm",id);
		return data;
	}

}
