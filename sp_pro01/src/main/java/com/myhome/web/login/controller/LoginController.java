package com.myhome.web.login.controller;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.myhome.web.HomeController;
import com.myhome.web.login.service.LoginService;
import com.myhome.web.login.vo.LoginVO;

@Controller
public class LoginController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@Autowired
	private LoginService service;
	
	@RequestMapping(value = "/login", method =RequestMethod.POST)
	//jsp 파일의 name 이 매치가 되어야한다.
	//name 매치가 불가능할시에는 @RequestParam("empName")String name
	public String login(LoginVO loginVo, HttpSession session) { 
		//public String login(HttpServletRequest request) //두가지 방법이 있다.
		//String empId = request.getParameter("empId");
		//String deptId = request.getParameter("deptId");
		//String empName = request.getParameter("empName");
		logger.info("login({}, {}, {})", loginVo.getEmpId(),loginVo.getDeptId(),loginVo.getEmpName());
		
		boolean result = service.getLogin(session,loginVo);
		
		if (result) {
			//로그인 성공 -> response.redirect
			return "redirect:/";
		}else {
			//로그인 실패
			return "";
		}
	}
}
