package locs.service;

import java.util.ArrayList;
import java.util.List;

import locs.model.LocsDAO;
import locs.model.LocsDTO;

public class LocsService {
	
	private LocsDAO dao;

	public LocsService() {
		dao= new LocsDAO();
	}
	
	public List<LocsDTO> getAll() {
		List<LocsDTO> datas = dao.searchAll();
		return datas;
	}
	
	public LocsDTO getLocsId(String id) {
		boolean isNumber = id.matches("\\d+");
		if (isNumber) {
			int deptId = Integer.parseInt(id);
			return _getLocsId(deptId);
		}
		return null;
	}
	
	public LocsDTO getLocs(int id) {
		return _getLocsId(id);
	}
	
	private LocsDTO _getLocsId(int id) {
		LocsDTO data =dao.searchLocsId(id);
		return data;
	} //내부 전용 함수를 만들어 사용 가능

	public List<Integer> getPageNumberList(int count) {
		LocsDAO dao = new LocsDAO();
		int rowCount = dao.rowCount();
		dao.close();
		
		List<Integer> pageList = new ArrayList<Integer>();
		int pageNum = (rowCount - 1) / count;
		for(int n = 0; n <= pageNum; n++) {
			pageList.add(n + 1);
		}
		return pageList;
	}

	public List<LocsDTO> getPage(int pageNumber, int count) {
		int start = (pageNumber - 1) * count + 1;
		int end = start + count - 1;
		
		LocsDAO dao = new LocsDAO();
		List<LocsDTO> datas = dao.selectPage(start, end);
		dao.close();
		
		return datas;
	}
}
	
