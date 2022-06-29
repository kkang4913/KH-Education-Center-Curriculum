package dept.model;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.conn.db.DBConn;

public class DeptDAO {
	
	
	private SqlSession session;
	
	public DeptDAO() {
		session = DBConn.getSqlSession();
	}
	public List<DeptDTO> searchAll() {
		List<DeptDTO> datas = session.selectList("deptMapper.deptSelectAll");
		//System.out.println(datas); //조회 확인
		return datas;
	}
	
	public DeptDTO searchDeptId(int id) {
		DeptDTO data = session.selectOne("deptMapper.deptSelectId",id);
		return data;
	}
}
