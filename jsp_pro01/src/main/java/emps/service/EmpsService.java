package emps.service;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import dept.model.DeptDAO;
import dept.service.DEPT_SERVICE_STATUS;
import emps.model.EmpsDAO;
import emps.model.EmpsDTO;
import emps.model.EmpsDetailDTO;

public class EmpsService {
	
	
	public List<EmpsDTO> getAll() {
		EmpsDAO dao = new EmpsDAO();
		List<EmpsDTO> datas = dao.selectAll();
		dao.close();
		
		return datas;
	}

	public List<EmpsDTO> getPage(int pageNumber, int count) {
		int start = (pageNumber - 1) * count + 1;
		int end = start + count - 1;
		
		EmpsDAO dao = new EmpsDAO();
		List<EmpsDTO> datas = dao.selectPage(start, end);
		dao.close();
		
		return datas;
	}
	
	public List<Integer> getPageNumberList(int count) {
		EmpsDAO dao = new EmpsDAO();
		int rowCount = dao.rowCount();
		dao.close();
		
		List<Integer> pageList = new ArrayList<Integer>();
		int pageNum = (rowCount - 1) / count;
		for(int n = 0; n <= pageNum; n++) {
			pageList.add(n + 1);
		}
		return pageList;
	}
	
	public List<Integer> getPageNumberList() {
		return getPageNumberList(10);
	}

	public EmpsDetailDTO getEmpDetail(int empId) {
		EmpsDAO dao = new EmpsDAO();
		EmpsDetailDTO data = dao.selectEmpDetail(empId);
		dao.close();
		return data;
	}
	
	
	
	
	public boolean setEmp(EmpsDTO empsData, EmpsDetailDTO empsDetailData) {
		EmpsDAO dao = new EmpsDAO();
		
		boolean res1 = dao.updateEmp(empsData);
		
		
		int salary = _checkSalaryRange(dao, empsData, empsDetailData.getSalary());
		empsDetailData.setSalary(salary);
//		Map<String, Integer> salaryRange = dao.checkSalaryRange(empsData.getJobId());
//		
//		
//		if(salaryRange.get("minSalary") > empsDetailData.getSalary()) {
//			empsDetailData.setSalary(salaryRange.get("minSalary"));
//		}else if(salaryRange.get("maxSalary") < empsDetailData.getSalary()) {
//			empsDetailData.setSalary(salaryRange.get("maxSalary"));
//		}
		boolean res2 = dao.updateEmpDetail(empsDetailData);
		
		if(res1 && res2) {
			dao.commit();
			dao.close();
			return true;
		} else {
			dao.rollback();
			dao.close();
			return false;
		}
		
	}
	public boolean add(EmpsDTO empsData, EmpsDetailDTO empsDetailData) {
		EmpsDAO dao = new EmpsDAO();
		
		boolean res1 = dao.insertEmp(empsData);
		
		int salary = _checkSalaryRange(dao, empsData, empsDetailData.getSalary());
		empsDetailData.setSalary(salary);
		
		boolean res2 = dao.updateEmpDetail(empsDetailData);
		
		if(res1 && res2) {
			dao.commit();
			dao.close();
			return true;
		} else {
			dao.rollback();
			dao.close();
			return false;
		}
		
	}
	public EmpsDTO getId(String id) {
		EmpsDAO dao = new EmpsDAO();
		EmpsDTO data =  dao.selectId(Integer.parseInt(id));
		dao.close();
		return data;
	}
	
	public String getProfleImagePath(HttpServletRequest request, String imagePath, EmpsDTO empsData) {
		String realPath = request.getServletContext().getRealPath(imagePath) + empsData.getEmpId() + ".png";
		
		File file = new File(realPath);
		if(file.exists()) {
			return imagePath + empsData.getEmpId() + ".png";
		}else {
			return imagePath + "profile.png";
		}
	}
	
	public Map<String, Integer> getSalaryRange(String jobId){
		EmpsDAO dao = new EmpsDAO();
		return dao.checkSalaryRange(jobId);
	}
	
	
	private int _checkSalaryRange(EmpsDAO dao, EmpsDTO dto, int salary){
		Map<String, Integer> salaryRange = dao.checkSalaryRange(dto.getJobId());
		
		if(salaryRange.get("minSalary") > salary) {
			return salaryRange.get("minSalary"); 
		}else if(salaryRange.get("maxSalary") < salary) {
			return salaryRange.get("maxSalary"); 
		}
		return salary;
		
	}

	public boolean removeId(int id) {
		EmpsDAO dao = new EmpsDAO();
		boolean result =dao.deleteId(id);
		if (result) {
			dao.commit();
		}else {
			dao.rollback();
		}
		dao.close();
		return result;
		
	}
	
	
}

