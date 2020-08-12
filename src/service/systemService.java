package service;

import java.sql.SQLException;
import java.util.List;
import dao.systemDao;
import entity.system;
import entity.systemname;

public class systemService {
	private static systemDao systemDao=new systemDao();
	private system system=new system();
	/**
	 * 查询整表
	 * @return
	 * @throws SQLException
	 */
	public List<system> queryAll() throws SQLException{
		return systemDao.queryAll();
	}
	
	public int update(String name,String sid) throws SQLException {
		int no=systemDao.update(name,sid);
		return no;
		
	}

	public String getTitle() throws SQLException {
		return systemDao.selectTitle();
	}
}
