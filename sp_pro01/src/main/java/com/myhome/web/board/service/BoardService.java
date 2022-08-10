package com.myhome.web.board.service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.myhome.web.board.model.BoardDAO;
import com.myhome.web.board.model.BoardDTO;

@Service
public class BoardService {
	
	@Autowired
	private BoardDAO dao;
	
	public List<BoardDTO> getAll() {
		List<BoardDTO> datas = dao.selectAll();
		return datas;
	}
	
	/*
	public int add(BoardDTO data) {
		BoardDAO dao = new BoardDAO();
		
		int seq = dao.getNextSeq();
		data.setId(seq);
		
		boolean result = dao.insertData(data);
		
		if(result) {
			dao.commit();
			dao.close();
			return data.getId();
		}
		
		dao.rollback();
		dao.close();
		return -1;
	}

	public BoardDTO getData(int id) {
		BoardDAO dao = new BoardDAO();
		
		BoardDTO data = dao.selectData(id);
		dao.close();
		
		return data;
	}

	public void incViewCnt(HttpSession session, BoardDTO data) {
		BoardDAO dao = new BoardDAO();
		
		BoardStaticsDTO staticsData = new BoardStaticsDTO();
		staticsData.setbId(data.getId());
		staticsData.setEmpId(((EmpsDTO)session.getAttribute("loginData")).getEmpId());
		
		staticsData = dao.selectStatics(staticsData);
		
		boolean result = false;
		if(staticsData == null) {
			result = dao.updateViewCnt(data);
			
			staticsData = new BoardStaticsDTO();
			staticsData.setbId(data.getId());
			staticsData.setEmpId(((EmpsDTO)session.getAttribute("loginData")).getEmpId());
			dao.insertStatics(staticsData);
		} else {
			long timeDiff = new Date().getTime() - staticsData.getLatestViewDate().getTime();
			if(timeDiff / (1000 * 60 * 60 * 24) >= 7) {
				result = dao.updateViewCnt(data);
				dao.updateStatics(staticsData);
			}
		}
		
		if(result) {
			data.setViewCnt(data.getViewCnt() + 1);
			dao.commit();
			dao.close();
		}
		dao.rollback();
		dao.close();
	}
	
	public void incLike(HttpSession session, BoardDTO data) {
		EmpsDTO empData = (EmpsDTO)session.getAttribute("loginData");
		BoardDAO dao = new BoardDAO();
		
		BoardStaticsDTO staticsData = new BoardStaticsDTO();
		staticsData.setbId(data.getId());
		staticsData.setEmpId(empData.getEmpId());
		
		staticsData = dao.selectStatics(staticsData);
		
		// 이전에 추천을 했는지 안 했는지 확인
		if(staticsData.isLiked()) {
			// 이전에 추천을 한 기록이 있으면 -> 추천 취소로 전환
			staticsData.setLiked(false);
			data.setLike(data.getLike() - 1);
		} else {
			// 이전에 추천을 한 기록이 없으면 -> 추천으로 전환
			staticsData.setLiked(true);
			data.setLike(data.getLike() + 1);
		}
		
		dao.updateStaticsLike(staticsData);
		boolean result = dao.updateLike(data);
		
		if(result) {
			dao.commit();
		} else {
			dao.rollback();
		}
		dao.close();
	}
	


	public boolean remove(BoardDTO data) {
		BoardDAO dao = new BoardDAO();
		
		BoardStaticsDTO staticsData = new BoardStaticsDTO();
		staticsData.setbId(data.getId());
		
		dao.deleteStaticsData(staticsData);
		boolean result = dao.deleteData(data);
		
		if(result) {
			dao.commit();
		} else {
			dao.rollback();
		}
		dao.close();
		return result;
	}

	public boolean modify(BoardDTO data) {
		BoardDAO dao = new BoardDAO();
		
		boolean result =  dao.updateData(data);

		if(result) {
			dao.commit();
		}else {
			dao.rollback();
		}
			dao.close();
			return result;
	}
*/
}
