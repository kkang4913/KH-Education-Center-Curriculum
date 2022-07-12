package emp.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.conn.db.DBConn;

import dept.model.DeptDTO;

public class EmpDAO {
	
private SqlSession session = DBConn.getSqlSession();
private String mapper = "empsMapper.%s";	
	
public List<EmpDTO> searchAll() {
		String mapId = String.format(mapper, "selectAll");
		List<EmpDTO> datas =session.selectList(mapId);
		return datas;
	}
public List<EmpDTO> selectPage(int start, int end) {
	Map<String, Integer> page = new HashMap<String, Integer>();
	page.put("start", start);
	page.put("end", end);
	List<EmpDTO> datas = session.selectList("empsMapper.selectPage", page);
	return datas;
	
}
public int rowCount() {
	int count = session.selectOne("empsMapper.rowConut");
	return  count;
}

	public void close() {
		session.close();
	}

	public void commit() {
		session.commit();
	}
	public void rollback() {
		session.rollback();
	}

}
