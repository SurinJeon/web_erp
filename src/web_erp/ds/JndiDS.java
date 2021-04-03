package web_erp.ds;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class JndiDS {
	private static DataSource ds;
	
	private JndiDS() {
		
	} // 외부에서 이거 다시 생성하지 않도록 private 설정함
	// 쓸거면 getConnection() 가져와라
	
	static {
		try {
			InitialContext ic = new InitialContext();
			ds = (DataSource)ic.lookup("java:comp/env/jdbc/dbstudy"); // 생성자 전에도 ds 끌어올 수 있는 이유는 ds를 static으로 했기 때문
			System.out.println("ds > " + ds);
		} catch (NamingException e) {
			e.printStackTrace();
		}
		
	} // static block >> 객체가 생성되고, 생성자가 호출되기 전에 먼저 작업됨.
	
	public static Connection getConnection() {
		try {
			return ds.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
}
