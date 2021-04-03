package web_erp.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import web_erp.dto.Employee;
import web_erp.service.EmpService;

@WebServlet("/EmpdeleteServlet")
public class EmpdeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private EmpService service;
	
    public EmpdeleteServlet() {
    	service = new EmpService();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("text/html; charset = utf-8");
		
		int no = Integer.parseInt(request.getParameter("eNo"));
		service.deleteEmps(new Employee(no));
		
		response.sendRedirect("EmpListServlet");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
