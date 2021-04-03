package web_erp.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import web_erp.dao.DepartmentDao;
import web_erp.dto.Department;

public class DepartmentDaoImpl implements DepartmentDao {
	
	private static final DepartmentDaoImpl instance = new DepartmentDaoImpl();
	private Connection con;
	public static DepartmentDaoImpl getInstance() {
		return instance;
	}
	// singleton

	public void setCon(Connection con) {
		this.con = con;
	}
	
	@Override
	public List<Department> selectDepartmentByAll() {
		String sql = "select deptNo, deptName, floor from department";
		try(PreparedStatement pstmt= con.prepareStatement(sql);
				ResultSet rs = pstmt.executeQuery();
				){
			if(rs.next()) {
				List<Department> list = new ArrayList<Department>();
				do {
					list.add(getDepartment(rs));
				} while(rs.next());
				return list;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	} // end of selectDepartmentByAll()




	private Department getDepartment(ResultSet rs) throws SQLException {
		int deptNo = rs.getInt("deptno");
		String deptName = rs.getString("deptname");
		int floor = rs.getInt("floor");
		return new Department(deptNo, deptName, floor);
	}
	@Override
	public Department selectDepartmentByNo(Department department) {
		String sql = "select deptNo, deptName, floor from department where deptNo = ?";
		try(PreparedStatement pstmt= con.prepareStatement(sql);
				){
			pstmt.setInt(1, department.getNo());
			try (ResultSet rs = pstmt.executeQuery();){
				if(rs.next()) {
					return getDepartment(rs);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	} // end of selectDepartmentByNo()

	@Override
	public Department selectDepartmentByName(Department department) {
		String sql = "select deptNo, deptName, floor from department where deptName = ?";
		try(PreparedStatement pstmt= con.prepareStatement(sql);
				){
			pstmt.setString(1, department.getName());
			try (ResultSet rs = pstmt.executeQuery();){
				if(rs.next()) {
					return getDepartment(rs);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@Override
	public int insertDepartment(Department department) {
		String sql = "insert into department values (?, ?, ?)";
		try(PreparedStatement pstmt= con.prepareStatement(sql);
				){
			pstmt.setInt(1, department.getNo());
			pstmt.setString(2, department.getName());
			pstmt.setInt(3, department.getFloor());
			return pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

		
	@Override
	public int updateDepartment(Department department) {
		String sql = "update department set deptname = ?, floor = ? where deptno = ?";
		try(PreparedStatement pstmt= con.prepareStatement(sql);
				){
			pstmt.setString(1, department.getName());
			pstmt.setInt(2, department.getFloor());
			pstmt.setInt(3, department.getNo());
			return pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int deleteDepartment(Department department) {
		String sql = "delete from department where deptno = ?";
		try(PreparedStatement pstmt= con.prepareStatement(sql);
				){
			pstmt.setInt(1, department.getNo());
			return pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

}
