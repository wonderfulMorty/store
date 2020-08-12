package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dbuils.DButils;
import entity.staff;
import entity.system;
import entity.systemname;

public class systemDao {
	private DButils store=new DButils();
//	ware ware=new ware();
	 
	
	/**
	 * 查询库存所有信息
	 * @return
	 * @throws SQLException
	 */
	public List<system> queryAll() throws SQLException{
		String sql="select * from count";
		ResultSet rs=store.executePsQuery(sql,null);
		system s=null;
        List<system> list=new ArrayList<system>();
        while(rs.next()) {
        	s=new system();
        	s.setMin(rs.getString("min"));
        	s.setMax(rs.getString("max"));
        	s.setCount(rs.getString("count"));
        	list.add(s);
        }
		return list;
	}
	
	
	public int update(String name,String sid) throws SQLException {
		String sql="update setting set sname=? where sid=?";
		int no=store.executePsUpdate(sql,name,sid);
		return no;
	}
	
	public String selectTitle() throws SQLException {
		String title=null;
		String sql="select sname from setting where sid='1'";
		ResultSet rs=store.executePsQuery(sql,null);
		while(rs.next()) {
			title=rs.getString("sname");
		}
		return title;
	}
}
