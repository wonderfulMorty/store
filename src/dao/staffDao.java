package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dbuils.DButils;
import entity.menber;
import entity.staff;
import entity.ware;

public class staffDao {

	private DButils store=new DButils();
//	ware ware=new ware();
	/**
	 * 查询库存所有信息
	 * @return
	 * @throws SQLException
	 */
	public List<staff> queryAll() throws SQLException{
		String sql="select * from staff";
		ResultSet rs=store.executePsQuery(sql,null);
		staff staff=null;
        List<staff> list=new ArrayList<staff>();
        while(rs.next()) {
        	staff=new staff();
        	staff.setId(rs.getString("id"));
        	staff.setPass(rs.getString("pass"));
        	staff.setRealname(rs.getString("realname"));
        	staff.setIden(rs.getString("iden"));
        	staff.setIncome(rs.getString("income"));
        	list.add(staff);
        }
		return list;
	}
	
	public int addpeople(staff people) throws SQLException  {
	    int no=0;
		String sql="insert into staff(id,pass,realname,iden,income)values(?,?,?,?,?)";
	    no= store.executePsUpdate(sql, people.getId(),people.getPass(),people.getRealname(),people.getIden(),people.getIncome());
	    return no;
	}
	
	public List<staff> queryid(String id) throws SQLException {
		String sql="select * from staff where id=?";
		ResultSet rs=store.executePsQuery(sql,id);
		staff staff=null;
        List<staff> list1=new ArrayList<staff>();
        while(rs.next()) {
        	staff=new staff();
        	staff.setId(rs.getString("id"));
        	staff.setPass(rs.getString("pass"));
        	staff.setRealname(rs.getString("realname"));
        	staff.setIden(rs.getString("iden"));
        	staff.setIncome(rs.getString("income"));
        	list1.add(staff);
        }
        if(staff==null) {
        	throw new RuntimeException("公司没有该员工");
        }
        else{
        	return list1;
        }
		
	}
	
	public int update(String id,String pass,String realname,String iden,String income) throws SQLException {
		String sql=" update staff set pass=?,realname=?,iden=?,income=?  where id=? ";
		int no=store.executePsUpdate(sql, pass,realname,iden,income,id);
		return no;
	}
	
	
	public  void delByid(String id) throws SQLException {
	    String sql="delete  from staff where id=?";
	    int no=store.executePsUpdate(sql, id);
    }
}
