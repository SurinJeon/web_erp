package web_erp.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import web_erp.dto.Title;
import web_erp.service.TitleService;

@WebServlet("/TitleInsertServlet")
public class TitleInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private TitleService service;
	
    public TitleInsertServlet() {
    	service = new TitleService();
        
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset = utf-8");
		
		// tno=9&tname="인턴"
		int no = Integer.parseInt(request.getParameter("tNo").trim());
		String name = request.getParameter("tName").trim();
		
		Title title = new Title(no, name);
		
		service.addTitles(title);
		response.sendRedirect("TitleListServlet");
//		request.getRequestDispatcher("TitleListServlet").forward(request, response); << list를 보여주는데 url은 insert가 떠서 그냥 redirect하는게 깔끔
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
