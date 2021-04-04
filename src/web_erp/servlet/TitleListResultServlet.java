package web_erp.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import web_erp.dto.Title;
import web_erp.service.TitleService;

@WebServlet("/TitleListResultServlet")
public class TitleListResultServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private TitleService service;
       
    public TitleListResultServlet() {
    	service = new TitleService();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset = utf-8");
		List<Title> list = service.showTitles();
		
		request.setAttribute("list", list);
		
		RequestDispatcher dispather1 = request.getRequestDispatcher("index.jsp");
		dispather1.include(request, response);
		request.getRequestDispatcher("TitleListServlet").include(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
