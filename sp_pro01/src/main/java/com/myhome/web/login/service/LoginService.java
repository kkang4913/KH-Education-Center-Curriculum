package com.myhome.web.login.service;


import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myhome.web.HomeController;
import com.myhome.web.emp.model.EmpDTO;
import com.myhome.web.login.model.LoginDAO;
import com.myhome.web.login.vo.LoginVO;

@Service
public class LoginService {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@Autowired
	private LoginDAO dao;
	
	public boolean getLogin(HttpSession session, LoginVO loginVo) {
		logger.info("getLogin({},{})", session, loginVo);
		
		EmpDTO data = new EmpDTO();
		data.setEmpId(loginVo.getEmpId());
		data.setDeptId(loginVo.getDeptId());
		data.setEmpName(loginVo.getEmpName());
		
		data = dao.selectLogin(data);
		
		if(data == null) {
			return false;
			//조회 결과 없음
		}else {
			//List<PermDTO> perm = dao.selectPerm(data.getEmpId());
			  session.setAttribute("loginData", data);
			//session.setAttribute("permData", perm);
			return true;
		}
		
	}


}
