package main.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dept.model.DeptDTO;
import dept.service.DeptService;

@WebServlet("")  //애너테이션 : url 주소가 사용됨 //web.xml 방법도 있다. 한가지 방법만 써야한다.
public class MainController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private DeptService deptService = new DeptService();
	private	String view = "/WEB-INF/jsp/index.jsp"; // jsp 파일의 경로가 들어간다.
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		
		
		RequestDispatcher rd = null;
		if(session.getAttribute("loginData") == null) {
			List<DeptDTO> deptDatas =deptService.getAll();
			request.setAttribute("deptDatas",deptDatas);
			rd = request.getRequestDispatcher(view);
		}else {
			rd = request.getRequestDispatcher("/WEB-INF/jsp/index2.jsp");
		}
		rd.forward(request, response);
		//jsp 파일을 제공하는 것이 아니라 jsp를 실행해서 얻어진 결과(html)를 제공
	
	}

}
