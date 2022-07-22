package job.model;

import java.util.List;

import common.model.AbstractDAO;
import job.model.JobDTO;

public class JobDAO extends AbstractDAO<List<JobDTO>, JobDTO> {
	
	String mapper = "jobMapper.%s";
	
	
	@Override
	public List<JobDTO> selectAll() {
		String mapId = String.format(mapper, "selectAll");
		List<JobDTO> data = session.selectList(mapId);
		return data;
	}

	@Override
	public JobDTO selectId(JobDTO e) {
		String mapId = String.format(mapper, "selectId");
		JobDTO data = session.selectOne(mapId,e.getjobId());
		return data;
	}

	@Override
	public JobDTO selectId(int id) {
		return selectId(String.valueOf(id));
	}
	
	public JobDTO selectId(String id) {
		String mapId = String.format(mapper, "selectId");
		JobDTO data = session.selectOne(mapId,id);
		return data;
	}

	@Override
	public int rowCount() {
		String mapId = String.format(mapper, "rowCount");
		int count = session.selectOne(mapId);
		return count;
	}

	@Override
	public boolean insertDate(JobDTO e) {
		String mapId = String.format(mapper, "insertDate",e);
		int result = session.insert(mapId,e);
		return result ==1 ? true : false;
	}

	@Override
	public boolean updateDate(JobDTO e) {
		String mapId = String.format(mapper, "updateDate",e);
		int result = session.insert(mapId,e);
		return result ==1 ? true : false;
	}

	@Override
	public boolean deleteDate(int id) {
		return deleteDate(String.valueOf(id));
	}
	
	public boolean deleteDate(String id) {
		String mapId = String.format(mapper, "deleteDate",id);
		int result = session.insert(mapId,id);
		return result ==1 ? true : false;
	}

	@Override
	public boolean deleteDate(JobDTO e) {
		String mapId = String.format(mapper, "deleteDate",e);
		int result = session.insert(mapId,e);
		return result ==1 ? true : false;
	}




}
