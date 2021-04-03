package web_erp.service;

import java.sql.Connection;
import java.util.List;

import web_erp.dao.impl.DepartmentDaoImpl;
import web_erp.ds.JndiDS;
import web_erp.dto.Department;

public class DeptService {
	private Connection conn = JndiDS.getConnection();
	private DepartmentDaoImpl dao = DepartmentDaoImpl.getInstance();

	public DeptService() {
		dao.setCon(conn);
	}

	public List<Department> showDepts() {
		return dao.selectDepartmentByAll();
	}

	public Department showDeptByNo(Department dept) {
		return dao.selectDepartmentByNo(dept);
	}

	public void addDepts(Department dept) {
		dao.insertDepartment(dept);
	}

	public void deleteDepts(Department dept) {
		dao.deleteDepartment(dept);
	}

	public void modifyDepts(Department dept) {
		dao.updateDepartment(dept);
	}
	
	public Department showDeptByName(Department dept) {
		return dao.selectDepartmentByName(dept);
	}

}
