package dept.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dept.model.DeptDTO;
import dept.service.DeptService;

@WebServlet("/depts")
public class DeptController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private DeptService service = new DeptService();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String search = request.getParameter("search"); //리퀘스트는 전부 문자열
		//System.out.println(search);
		
		//input 값에 숫자 범위가 아닐시 
		
		
		List<DeptDTO> datas =null;
		
		if(search == null) {
			int page = Integer.parseInt(request.getParameter("page"));
			datas = service.getPage(page);
			request.setAttribute("pageList", service.getPageNumberList());
		}else {								//matches: 정규표현식 사용하는 방법
			//boolean isNumber = search.matches("\\d+"); //정규표현식 사용
			//if(isNumber) {
			DeptDTO data = service.getDeptId(search);
			////문자열을 인트형으로 변환 Integer.parseInt
			if(data != null) {
				datas = new ArrayList<DeptDTO>();
				datas.add(data);
			}
		} 
	//}
		
		request.setAttribute("datas", datas);
		// datas 서블릿을 jsp에 전달하기 위해 사용하는 방법
		
		String view ="/WEB-INF/jsp/dept/index.jsp";
		request.getRequestDispatcher(view).forward(request, response);
	}

}
