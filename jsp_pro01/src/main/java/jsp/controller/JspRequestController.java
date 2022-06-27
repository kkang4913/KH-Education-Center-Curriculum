package jsp.controller;

import java.io.IOException;
import java.util.Iterator;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.jasper.runtime.ProtectedFunctionMapper;

@WebServlet("/jsp/request")
public class JspRequestController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String view ="/WEB-INF/jsp/jsp/request.jsp";
		request.setCharacterEncoding("UTF-8");
		
		System.out.println("param_name : " + request.getParameter("param_name"));
		if(request.getParameterValues("param_chk") != null){
			String[] sArr = request.getParameterValues("param_chk");
			System.out.println("param_chk : ");
			for(String s : sArr){
				System.out.println(s + " ");
			}
			System.out.println();
	}
		Iterator<String> iter = request.getParameterNames().asIterator();
		System.out.println("parameter names : ");
		while(iter.hasNext()){
			System.out.print(iter.next() + " ");
		}
		System.out.println();
		
		request.getRequestDispatcher(view).forward(request, response);
	}
	// 클라이언트 --> 서버 --> WAS --> 서블릿(요청 GET, POST 구분 doGet,doPost) --> JSP --> 실행결과 --> 클라이언트
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String view ="/WEB-INF/jsp/jsp/request.jsp";
		request.setCharacterEncoding("UTF-8");
		request.getRequestDispatcher(view).forward(request, response);
	}
}
