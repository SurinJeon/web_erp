package web_erp.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import web_erp.dto.Department;
import web_erp.dto.Title;
import web_erp.service.DeptService;

@WebServlet("/DeptdeleteServlet")
public class DeptdeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private DeptService service;

	public DeptdeleteServlet() {
		service = new DeptService();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset = utf-8");

		int no = Integer.parseInt(request.getParameter("dNo"));
		service.deleteDepts(new Department(no));
		
		request.getRequestDispatcher("DeptIndexServlet").include(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
