package service;

import java.util.List;

import java.sql.SQLException;

import dao.staffDao;
import entity.menber;
import entity.staff;
import entity.ware;
public class staffService {
	private static staffDao peopleDao=new staffDao();
	private static staff people=new staff();
	/**
	 * 查询整表
	 * @return
	 * @throws SQLException
	 */
	public List<staff> queryAll() throws SQLException{
		return peopleDao.queryAll();
	}
	
	public static int addpeople(staff people) throws SQLException {
		//1.非空判断
		if(people.getId()==null||"".equals(people.getId())) {
			throw new RuntimeException( "员工号不能为空");
		}
		if(people.getPass()==null||"".equals(people.getPass())) {
			throw new RuntimeException( "密码不能为空");
		}
		if(people.getRealname()==null||"".equals(people.getRealname())) {
			throw new RuntimeException( "姓名不能为空");
		}
		if(people.getIncome()==null||"".equals(people.getIncome())) {
			throw new RuntimeException( "提成比例不能为空");
		}
		
		//2.添加
		int no=peopleDao.addpeople(people);
		return no;
	}
	public List<staff> queryId(String id) throws SQLException {
		return peopleDao.queryid(id);
	}

	public int update(String id, String pass, String realname, String iden, String income) throws SQLException {
		int no = peopleDao.update(id,pass,realname,iden,income);
		return no;

	}

	public void delByid(String id) throws SQLException {
		peopleDao.delByid(id);

	}
}
