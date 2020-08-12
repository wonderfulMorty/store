package service;

import java.sql.SQLException;

import java.util.List;

import dao.menberDao;
import entity.menber;
import entity.ware;

public class menberService {

	private menberDao menberDao = new menberDao();
	private menber menber=new menber();

	public List<menber> queryAll() throws SQLException {
		return menberDao.queryAll();
	}

	public int addmenber(menber menber) throws SQLException {
		// 1.非空判断
		if (menber.getMid() == null || "".equals(menber.getMid())) {
			throw new RuntimeException("会员号不能为空");
		}
		if (menber.getMname() == null || "".equals(menber.getMname())) {
			throw new RuntimeException("会员姓名不能为空");
		}
		if (menber.getMtel() == null || "".equals(menber.getMtel())) {
			throw new RuntimeException("电话不能为空");
		}
		if (menber.getMcount() == null || "".equals(menber.getMcount())) {
			throw new RuntimeException("折扣率不能为空");
		}

		// 2.添加
		int no = menberDao.addmenber(menber);
		return no;
	}

	public List<menber> queryId(String mid) throws SQLException {
		return menberDao.querymid(mid);
	}

	public int update(String mid, String mname, String msex, String mtel, String mcount) throws SQLException {
		int no = menberDao.update(mid, mname, msex, mtel, mcount);
		return no;

	}

	public void delBymid(String mid) throws SQLException {
		menberDao.delBymid(mid);

	}
}
