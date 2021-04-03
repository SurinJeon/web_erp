package web_erp.service;

import java.sql.Connection;
import java.util.List;

import web_erp.dao.impl.TitleDaoImpl;
import web_erp.ds.JndiDS;
import web_erp.dto.Title;

public class TitleService {
	private Connection conn = JndiDS.getConnection();
	private TitleDaoImpl dao= TitleDaoImpl.getInstance();
	
	public TitleService() {
		dao.setCon(conn);
	} // dao에 setCon을 여기의 conn으로 하는 것
	
	public List<Title> showTitles(){
		return dao.selectTitleByAll();
	}
	
	public Title showTitleByNo(Title title) {
		return dao.selectTitleByNo(title);
	}
	
	public Title showTitleByName(Title title) {
		return dao.selectTitleByName(title);
	}
	
	public void addTitles(Title title) {
		dao.insertTitle(title);
	}
	
	public void deleteTitles(Title title) {
		dao.deleteTitle(title.getNo());
	}
	
	public void modifyTitles(Title title) {
		dao.updateTitle(title);
	}
	
	
}
