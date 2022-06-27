package main.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/main")  //애너테이션 : url 주소가 사용됨 //web.xml 방법도 있다. 한가지 방법만 써야한다.
public class MainController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 비지니스 로직을 구현할 시에 서블릿 사용.
		// 화면 구현은 jsp를 사용
		String view = "/WEB-INF/jsp/index.jsp"; // jsp 파일의 경로가 들어간다.
		request.getRequestDispatcher(view).forward(request, response);
		//jsp 파일을 제공하는 것이 아니라 jsp를 실행해서 얻어진 결과(html)를 제공
	
	}

}
