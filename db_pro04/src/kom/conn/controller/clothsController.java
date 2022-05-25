package kom.conn.controller;


import com.join.vo.JoinVo;

import kom.conn.VO.clothsVO;
import kom.conn.dao.clothsDAO;

public class clothsController {
	
	private clothsDAO dao = new clothsDAO();
	private clothsVO vo = new clothsVO();
	
	public boolean  join(clothsVO data) {
		// 회원 가입 진행 전 아이디 중복을 확인 
		// 중복이 아닐시 아이디 확인 
		clothsVO account = dao.get(data.getAdminid());
		if (account == null) {
			boolean result = dao.adminAdd(data);
			if (result) {
				return true;
			}
		}
	return false;
	}
	
	
	public boolean update (clothsVO data) {
		return dao.modify(data);
	}
	
	
	public boolean remove(clothsVO data, String adminid, String pw) {
		if (data.getAdminid().equals(adminid)) {
			if (data.getPassword().equals(pw)) {
				return dao.remove(data);
			}else {
				return false;
		}
	}
		return false;
	}
	public boolean remove(clothsVO data, String pCode) {
		if (data.getProductCode().equals(pCode)) {
				return dao.removeCode(data);
			}else {
				return false;
		}
	}

	public clothsVO login(String adminid, String pw) {
		clothsVO account = dao.get(adminid);
		
		if (account != null) {
			if (account.getPassword().equals(pw)) {
				return account;
			}
		}
		return null;
	}
	
	
	
}
