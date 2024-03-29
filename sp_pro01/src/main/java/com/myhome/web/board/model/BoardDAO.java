package com.myhome.web.board.model;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class BoardDAO {
	
	private static final Logger logger = LoggerFactory.getLogger(BoardDAO.class);
	
	@Autowired
	private SqlSession session;
	
	private String mapper = "boardMapper.%s";
	
	public List<BoardDTO> selectAll() {
		logger.info("selectAll()");
		String mapperId = String.format(mapper, "selectAll");
		List<BoardDTO> res = session.selectList(mapperId);
		return res;
	}
	
	public BoardDTO selectData(int id) {
		logger.info("selectData(id={})", id);
		String mapperId = String.format(mapper, "selectData");
		BoardDTO res = session.selectOne(mapperId, id);
		return res;
	}
	public List<BoardDTO> selectData(String search) {
		logger.info("selectData(search={})", search);
		String mapperId = String.format(mapper, "searchData");
		List<BoardDTO> res = session.selectList(mapperId, search);
		return res;
	}
	
	public int getNextSeq() {
		logger.info("getNextSeq()");
		String mapperId = String.format(mapper, "getNextSeq");
		int seq = session.selectOne(mapperId);
		return seq;
	}
	
	public boolean insertData(BoardDTO data) {
		logger.info("insertData(data={})", data);
		String mapperId = String.format(mapper, "insertData");
		int res = session.insert(mapperId, data);
		return res == 1 ? true : false;
	}
	
	public boolean updateData(BoardDTO data) {
		logger.info("updateData(data={})", data);
		String mapperId = String.format(mapper, "updateData");
		int res = session.update(mapperId, data);
		return res == 1 ? true : false;
	}
	
	public boolean deleteStaticsData(BoardStaticsDTO data) {
		logger.info("deleteStaticsData(data={})", data);
		String mapperId = String.format(mapper, "deleteStaticsData");
		int res = session.delete(mapperId, data);
		return res >= 0 ? true : false;
	}
	
	public boolean deleteData(BoardDTO data) {
		logger.info("deleteData(data={})", data);
		String mapperId = String.format(mapper, "deleteData");
		int res = session.delete(mapperId, data);
		return res == 1 ? true : false;
	}
	
	public boolean updateViewCnt(BoardDTO data) {
		logger.info("updateViewCnt(data={})", data);
		String mapperId = String.format(mapper, "updateViewCnt");
		int res = session.update(mapperId, data);
		return res == 1 ? true : false;
	}
	
	public BoardStaticsDTO selectStatics(BoardStaticsDTO data) {
		logger.info("selectStatics(data={})", data);
		String mapperId = String.format(mapper, "selectStatics");
		BoardStaticsDTO res = session.selectOne(mapperId, data);
		return res;
	}
	
	public boolean insertStatics(BoardStaticsDTO data) {
		logger.info("insertStatics(data={})", data);
		String mapperId = String.format(mapper, "insertStatics");
		int res = session.insert(mapperId, data);
		return res == 1 ? true : false;
	}
	
	public boolean updateStatics(BoardStaticsDTO data) {
		logger.info("updateStatics(data={})", data);
		String mapperId = String.format(mapper, "updateStatics");
		int res = session.update(mapperId, data);
		return res == 1 ? true : false;
	}

	public boolean updateLike(BoardDTO data) {
		logger.info("updateLike(data={})", data);
		String mapperId = String.format(mapper, "updateLike");
		int res = session.update(mapperId, data);
		return res == 1 ? true : false;
	}
	
	public boolean updateStaticsLike(BoardStaticsDTO data) {
		logger.info("updateStaticsLike(data={})", data);
		String mapperId = String.format(mapper, "updateStaticsLike");
		int res = session.update(mapperId, data);
		return res == 1 ? true : false;
	}
}
