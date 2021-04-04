package web_erp.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import web_erp.dto.Department;
import web_erp.dto.Employee;
import web_erp.dto.Title;
import web_erp.service.DeptService;
import web_erp.service.EmpService;
import web_erp.service.TitleService;

@WebServlet("/EmpGetServlet")
public class EmpGetServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private EmpService empService;
	private TitleService titleService;
	private DeptService deptService;
	
    public EmpGetServlet() {
    	empService = new EmpService();
    	titleService = new TitleService();
    	deptService = new DeptService();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("utf-8");
		
		int no = Integer.parseInt(request.getParameter("eNo").trim());
		Employee emp = empService.showEmpByNo(new Employee(no));
		
		List<Title> tList = titleService.showTitles();
		List<Department> dList = deptService.showDepts();
		
		request.setAttribute("emp", emp);
		request.setAttribute("tList", tList);
		request.setAttribute("dList", dList);
		
		RequestDispatcher dispather = request.getRequestDispatcher("index.jsp");
		dispather.include(request, response);
		RequestDispatcher dispather2 = request.getRequestDispatcher("EmpListServlet");
		dispather2.include(request, response);
		request.getRequestDispatcher("empInfo.jsp").include(request, response);
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
