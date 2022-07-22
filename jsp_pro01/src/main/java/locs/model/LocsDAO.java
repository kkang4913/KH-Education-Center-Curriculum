package locs.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.conn.db.DBConn;



public class LocsDAO {
	
	private SqlSession  session;
	private String mapper = "locsMapper.%s";
	
	
	public LocsDAO() {
		session = DBConn.getSqlSession();
	}
	
	
	
	public List<LocsDTO> searchAll(){
		List<LocsDTO> datas = session.selectList("locsMapper.locsSelectAll");
		return datas;
	}
	public LocsDTO searchLocsId(int id) {
		LocsDTO data = session.selectOne("locsMapper.locsSelectId",id);
		return data;
	}

	public int rowCount() {
		String mapId = String.format(mapper, "locsRowCount");
		int count = session.selectOne(mapId);
		return count;
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

	public List<LocsDTO> selectPage(int start, int end) {
		String mapId = String.format(mapper, "selectPage");
		Map<String, Integer> page = new HashMap<String, Integer>();
		page.put("start", start);
		page.put("end", end);
		List<LocsDTO> datas = session.selectList(mapId, page);
		return datas;
	}


	
}
