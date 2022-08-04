package board.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import board.model.EmpBoardDTO;
import board.service.EmpBoardService;
import emps.model.EmpsDTO;

@WebServlet("/board/modify")
public class EmpBoardModifyController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private EmpBoardService service = new EmpBoardService();
	String view = "/WEB-INF/jsp/board/modify.jsp";
		
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String id = request.getParameter("id");
		
		EmpBoardDTO data =  service.getData(Integer.parseInt(id));
		EmpsDTO empsData = (EmpsDTO)session.getAttribute("loginData");
		
		if(data.getEmpId() == empsData.getEmpId()) {
			request.setAttribute("data", data);
			
			RequestDispatcher rd = request.getRequestDispatcher(view);
			rd.forward(request, response);
		}else {
			
		}
			
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();

		
		String id = request.getParameter("id");
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		
		EmpBoardDTO data = service.getData(Integer.parseInt(id));
		EmpsDTO empsData = (EmpsDTO)session.getAttribute("loginData");

		if(data.getEmpId() == empsData.getEmpId()) {
			
			data.setTitle(title);
			data.setContent(content);
			
			boolean result = service.modify(data);
			if(result) {
				response.sendRedirect(request.getContextPath() + "/board/detail?id=" + data.getId());
			}else {
				doGet(request,response);
			}
		}else {
			
		}
		
		
	
	}

}
