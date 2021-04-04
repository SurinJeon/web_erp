package web_erp.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import web_erp.dto.Department;
import web_erp.service.DeptService;

@WebServlet("/DeptGetServlet")
public class DeptGetServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private DeptService service;   
	
    public DeptGetServlet() {
    	service = new DeptService();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset = utf-8");
		
		int no = Integer.parseInt(request.getParameter("deptNo").trim());
		Department dept = service.showDeptByNo(new Department(no));
		
		request.setAttribute("dept", dept);
		
		RequestDispatcher dispather1 = request.getRequestDispatcher("index.jsp");
		dispather1.include(request, response);
		RequestDispatcher dispather2 = request.getRequestDispatcher("DeptListServlet");
		dispather2.include(request, response);
		request.getRequestDispatcher("deptInfo.jsp").include(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
