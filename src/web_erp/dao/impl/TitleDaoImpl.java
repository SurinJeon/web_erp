package web_erp.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import web_erp.dao.TitleDao;
import web_erp.dto.Title;

public class TitleDaoImpl implements TitleDao{

	private static final TitleDaoImpl instance = new TitleDaoImpl();
	private Connection con;
	
	public static TitleDaoImpl getInstance() {
		return instance;
	}

	private TitleDaoImpl() {}
	// singleton pattern
	

	public void setCon(Connection con) {
		this.con = con;
	}

	@Override
	public List<Title> selectTitleByAll() {
		String sql = "select tno, tname from title";
		try(PreparedStatement pstmt = con.prepareStatement(sql);
				ResultSet rs = pstmt.executeQuery();
				){
			if (rs.next()) {
				List<Title> list = new ArrayList<Title>();
				do {
					list.add(getTitle(rs));
				} while(rs.next()); // rs 다음 항목 있을때까지만 getTitle을 list에 추가하는 것
//				System.out.println(list.size());
				return list;
			}
		
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	} // end of selectTitleByAll()

	private Title getTitle(ResultSet rs) throws SQLException {
		int tNo = rs.getInt("tno");
		String tName = rs.getString("tname");
		
		return new Title(tNo, tName);
	}

	@Override
	public Title selectTitleByName(Title title) {
		String sql = "select tno, tname from title where tname = ?";
		try(PreparedStatement pstmt = con.prepareStatement(sql);
				){
			pstmt.setString(1, title.getName()); 
			try (ResultSet rs = pstmt.executeQuery()){
				if(rs.next()) {
					return getTitle(rs); 
				}
			}
			System.out.println(pstmt);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public Title selectTitleByNo(Title title) {
		String sql = "select tno, tname from title where tno = ?";
		try(PreparedStatement pstmt = con.prepareStatement(sql);
				// 여기에서 resultset 할 수가 없음.. 물음표가 있기 때문 그건 아래에서 완성할 것
				){
			pstmt.setInt(1, title.getNo()); // 저 물음표가 하나기 때문에 1이 오고, 그 자리에 gettNo를 넣는 것
			try (ResultSet rs = pstmt.executeQuery()){
				if(rs.next()) {
					return getTitle(rs); // 어차피 검색된건 하나기때문에 하나만 return함 
				}
			}
			System.out.println(pstmt);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	@Override
	public int insertTitle(Title title) {

		String sql = "insert into title values (?, ?)"; // 할때마다 매번 바뀌어야하는 것들은 물음표로 처리해야함
		try(PreparedStatement pstmt = con.prepareStatement(sql);
				){
			pstmt.setInt(1, title.getNo());
			pstmt.setString(2, title.getName());
			return pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return 0;
	}

	@Override
	public int updateTitle(Title title) {
		String sql = "update title set tname = ? where tno = ?"; 
		try(PreparedStatement pstmt = con.prepareStatement(sql);
				){
			pstmt.setString(1, title.getName());
			pstmt.setInt(2, title.getNo());
			return pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return 0;
	}

	@Override
	public int deleteTitle(int titleNo) {
		String sql = "delete from title where tno = ?"; 
		try(PreparedStatement pstmt = con.prepareStatement(sql);
				){
			pstmt.setInt(1, titleNo);
			return pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return 0;
	}

	

}
