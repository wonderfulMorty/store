package service;

import java.sql.SQLException;
import java.util.List;

import dao.wareworkerDao;
import entity.wareworker;

public class wareworkerService {
private wareworkerDao ww=new wareworkerDao();
	
	public List<wareworker> queryAll() throws SQLException{
		return ww.queryAll();
		
		
	}
}
