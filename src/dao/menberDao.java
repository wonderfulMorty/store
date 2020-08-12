package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dbuils.DButils;
import entity.menber;
import entity.ware;

public class menberDao {
	private  DButils store=new DButils();

	/**
	 * 查询库存所有信息
	 * @return
	 * @throws SQLException
	 */
	public List<menber> queryAll() throws SQLException{
		String sql="select * from menber";
		ResultSet rs=store.executePsQuery(sql,null);
		menber menber=null;
        List<menber> list=new ArrayList<menber>();
        while(rs.next()) {
        	menber=new menber();
        	menber.setMid(rs.getString("mid"));
        	menber.setMname(rs.getString("mname"));
        	menber.setMsex(rs.getString("msex"));
        	menber.setMtel(rs.getString("mtel"));
        	menber.setMcount(rs.getString("mcount"));
        	list.add(menber);
        }
		return list;
	}
	
	public int addmenber(menber menber) throws SQLException  {
	    int no=0;
		String sql="insert into menber(mid,mname,msex,mtel,mcount)values(?,?,?,?,?)";
	    no= store.executePsUpdate(sql, menber.getMid(),menber.getMname(),menber.getMsex(),menber.getMtel(),menber.getMcount());
	    return no;
	}
	
	
	public List<menber> querymid(String mid) throws SQLException {
		String sql="select * from menber where mid=?";
		ResultSet rs=store.executePsQuery(sql,mid);
		menber menber=null;
        List<menber> list=new ArrayList<menber>();
        while(rs.next()) {
        	menber=new menber();
        	menber.setMid(rs.getString("mid"));
        	menber.setMname(rs.getString("mname"));
        	menber.setMsex(rs.getString("msex"));
        	menber.setMtel(rs.getString("mtel"));
        	menber.setMcount(rs.getString("mcount"));
        	list.add(menber);
        }
        if(menber==null) {
        	throw new RuntimeException("系统中没有该会员信息");
        }
        else{
        	return list;
        }
		
	}
	
	public int update(String mid,String mname,String msex,String mtel,String mcount) throws SQLException {
		String sql=" update menber set mname=?,msex=?,mtel=?,mcount=?  where mid=? ";
		int no=store.executePsUpdate(sql, mname,msex,mtel,mcount,mid);
		return no;
	}
	
	
	public  void delBymid(String mid) throws SQLException {
	    String sql="delete  from menber where mid=?";
	    int no=store.executePsUpdate(sql, mid);
    }
}
