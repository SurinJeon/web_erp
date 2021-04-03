package web_erp.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import web_erp.dto.Title;
import web_erp.service.TitleService;

@WebServlet("/TitleDeleteServlet")
public class TitleDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private TitleService service;
	
    public TitleDeleteServlet() {
    	service = new TitleService();
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset = utf-8");
		
		int no = Integer.parseInt(request.getParameter("tNo"));
		service.deleteTitles(new Title(no));
		
		response.sendRedirect("TitleListServlet");
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
