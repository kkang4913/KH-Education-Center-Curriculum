package emp.service;

import java.util.ArrayList;
import java.util.List;

import dept.model.DeptDAO;
import emp.model.EmpDAO;
import emp.model.EmpDTO;

public class EmpService {
	

	public List<EmpDTO> getAll() {
		EmpDAO dao = new EmpDAO();
		List<EmpDTO> datas = dao.searchAll();
		dao.close();
		
		return datas;
	}

	public List<EmpDTO> getPage(int pageNumber, int count) {
		int start = (pageNumber -1) *count +1;
		int end = start +count -1;
		
		EmpDAO dao = new EmpDAO();
		List<EmpDTO> datas = dao.selectPage(start,end);
		dao.close();
		return datas;
	}
	
	public List<Integer> getPageNumberList(){
		EmpDAO dao = new EmpDAO();
		int rowCount = dao.rowCount();
		dao.close();
		// 여기에 페이지 번호를 가지는 리스트를 만든다.
		List<Integer> pageList = new ArrayList<Integer>();
		int pageNum  = (rowCount -1) /10;
		for(int n =0; n<=pageNum; n++) {
			pageList.add(n + 1);
		}
		return pageList;
		
	}
	public List<Integer> getPageNumberList(int count){
		EmpDAO dao = new EmpDAO();
		int rowCount = dao.rowCount();
		dao.close();
		// 여기에 페이지 번호를 가지는 리스트를 만든다.
		List<Integer> pageList = new ArrayList<Integer>();
		int pageNum  = (rowCount -1) /count;
		for(int n =0; n<=pageNum; n++) {
			pageList.add(n + 1);
		}
		return pageList;
		
	}
	
}
