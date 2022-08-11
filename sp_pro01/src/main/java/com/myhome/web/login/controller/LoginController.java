package com.myhome.web.login.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.myhome.web.HomeController;
import com.myhome.web.dept.model.DeptDTO;
import com.myhome.web.dept.service.DeptService;
import com.myhome.web.login.service.LoginService;
import com.myhome.web.login.vo.LoginVO;

@Controller
public class LoginController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@Autowired
	private LoginService service;
	
	@Autowired //알아서 객체 생성 , 알아서 주입, 제어 역할
	private DeptService deptService;
	
	@GetMapping(value = "/login")
	public String login(Model model) {
		List<DeptDTO> deptDatas = deptService.getAll();
		model.addAttribute("deptDatas",deptDatas);
		return "login/login";
	}
	
	@RequestMapping(value = "/login", method =RequestMethod.POST)
	//jsp 파일의 name 이 매치가 되어야한다.
	//name 매치가 불가능할시에는 @RequestParam("empName")String name
	public String login(LoginVO loginVo, HttpSession session, Model model) { 
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
			return login(model);
		}
	}
	
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String Logout(HttpSession session) {
		//session.invalidate();
		session.removeAttribute("loginData");
		return "redirect:/";
	}
}
