package job.service;

import java.util.List;

import common.service.AbstractService;
import job.model.JobDAO;
import job.model.JobDTO;

public class JobService extends AbstractService {
	
	@Override
	public List<JobDTO> getAll() {
		JobDAO dao = new JobDAO();
		List<JobDTO> datas = dao.selectAll();
		dao.close();
		return datas;
	}

	@Override
	public JobDTO getId(Object o) {
		JobDTO dto = (JobDTO)o;
		JobDAO dao = new JobDAO();
		JobDTO data = dao.selectId(dto.getjobId());
		dao.close();
		return data;
	}

	@Override
	public JobDTO getId(int i) {
		JobDAO dao = new JobDAO();
		JobDTO data = dao.selectId(i);
		dao.close();
		return data;
	}

	@Override
	public boolean add(Object o) {
		JobDTO dto = (JobDTO)o;
		JobDAO dao = new JobDAO();
		boolean result = dao.insertDate(dto);
		if(result) {
		dao.commit();
		dao.close();
		return true;
		
		}else {
			dao.rollback();
			dao.close();
			return false;
		}
	}

	@Override
	public boolean modify(Object o) {
		JobDTO dto = (JobDTO)o;
		JobDAO dao = new JobDAO();
		boolean result = dao.updateDate(dto);
		if(result) {
		dao.commit();
		dao.close();
		return true;
		
		}else {
			dao.rollback();
			dao.close();
			return false;
		}
	}

	@Override
	public boolean remove(Object o) {
		JobDTO dto = (JobDTO)o;
		JobDAO dao = new JobDAO();
		boolean result = dao.deleteDate(dto);
		if(result) {
		dao.commit();
		dao.close();
		return true;
		
		}else {
			dao.rollback();
			dao.close();
			return false;
		}
	}
	public boolean remove(int i) {
		JobDAO dao = new JobDAO();
		boolean result = dao.deleteDate(i);
		if(result) {
		dao.commit();
		dao.close();
		return true;
		
		}else {
			dao.rollback();
			dao.close();
			return false;
		}
	
	}

}
