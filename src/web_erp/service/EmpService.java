package web_erp.service;

import java.sql.Connection;
import java.util.List;

import web_erp.dao.impl.EmployeeDaoImpl;
import web_erp.ds.JndiDS;
import web_erp.dto.Employee;

public class EmpService {
	private Connection conn = JndiDS.getConnection();
	private EmployeeDaoImpl dao = EmployeeDaoImpl.getInstance();

	public EmpService() {
		dao.setCon(conn);
	}

	public List<Employee> showEmps() {
		return dao.selectEmployeeByAll();
	}

	public Employee showEmpByNo(Employee emp) {
		return dao.selectEmployeeByNo(emp);
	}

	public void addEmps(Employee emp) {
		dao.insertEmployee(emp);
	}

	public void deleteEmps(Employee emp) {
		dao.deleteEmployee(emp);
	}

	public void modifyEmps(Employee emp) {
		dao.updateEmployee(emp);
	}

	public Employee showEmpByName(Employee emp) {
		return dao.selectEmployeeByName(emp);
	}
}
