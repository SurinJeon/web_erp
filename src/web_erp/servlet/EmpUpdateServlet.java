package web_erp.servlet;

import java.io.IOException;

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

@WebServlet("/EmpUpdateServlet")
public class EmpUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private EmpService service;
	private TitleService tService;
	private DeptService dService;
       
    public EmpUpdateServlet() {
    	service = new EmpService();
    	tService = new TitleService();
    	dService = new DeptService();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset = utf-8");
		
		int no = Integer.parseInt(request.getParameter("eNo").trim());
		String name = (String)request.getParameter("eName").trim();
		String titleName = (String)request.getParameter("title").trim();
		String managerName = (String)request.getParameter("manager").trim();
		int salary = Integer.parseInt(request.getParameter("salary"));
		String deptName = (String)request.getParameter("dept").trim();
		
		Title title = tService.showTitleByName(new Title(titleName));
		Employee manager = service.showEmpByName(new Employee(managerName));
		Department dept = dService.showDeptByName(new Department(deptName));
		
		Employee emp = new Employee(no, name, title, manager, salary, dept);
		
		
		service.modifyEmps(emp);
		request.getRequestDispatcher("EmpIndexServlet").include(request, response);		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
