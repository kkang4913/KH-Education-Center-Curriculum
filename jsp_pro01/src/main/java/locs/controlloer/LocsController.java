package locs.controlloer;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import locs.model.LocsDTO;
import locs.service.LocsService;

@WebServlet("/locs")
public class LocsController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private LocsService service = new LocsService();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//System.out.println("Controller 동작 확인");
		String search = request.getParameter("search");
		
		request.setAttribute("menuLocation", "locs");
		List<LocsDTO> datas =null;
		
		if(search == null) {
			datas = service.getAll();
		}else {								//matches: 정규표현식 사용하는 방법
			//boolean isNumber = search.matches("\\d+"); //정규표현식 사용
			//if(isNumber) {
			LocsDTO data = service.getLocsId(search);
			////문자열을 인트형으로 변환 Integer.parseInt
			if(data != null) {
				datas = new ArrayList<LocsDTO>();
				datas.add(data);
			}
		} 
		

		request.setAttribute("datas", datas);
		
		String view ="/WEB-INF/jsp/locs/index.jsp";
		request.getRequestDispatcher(view).forward(request, response);
	}

}
