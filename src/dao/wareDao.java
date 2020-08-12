package dao;

import java.sql.ResultSet;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dbuils.DButils;
import entity.ware;

public class wareDao {
	private DButils store=new DButils();
//	ware ware=new ware();
	/**
	 * 查询库存所有信息
	 * @return
	 * @throws SQLException
	 */
	public List<ware> queryAll() throws SQLException{
		String sql="select * from ware";
		ResultSet rs=store.executePsQuery(sql,null);
		ware ware=null;
        List<ware> list=new ArrayList<ware>();
        while(rs.next()) {
        	ware=new ware();
        	ware.setWareid(rs.getString("wareid"));
        	ware.setWarename(rs.getString("warename"));
        	ware.setWaredd(rs.getString("waredd"));
        	ware.setColor(rs.getString("color"));
        	ware.setSize(rs.getString("size"));
        	ware.setInprize(rs.getString("inprize"));
        	ware.setOutprize(rs.getString("outprize"));
        	ware.setNum(rs.getString("num"));
        	list.add(ware);
        }
		return list;
	}
	
	/**
	 * 添加商品信息
	 * @param stu
	 * @return
	 * @throws SQLException
	 */
	public int addware(ware ware) throws SQLException  {
	    int no=0;
		String sql="insert into ware(wareid,warename,waredd,color,size,inprize,outprize,num)values(?,?,?,?,?,?,?,?)";
	    no= store.executePsUpdate(sql, ware.getWareid(),ware.getWarename(),ware.getWaredd(),ware.getColor(),ware.getSize(),ware.getInprize(),ware.getOutprize(),ware.getNum());
	    return no;
	}

	/**
	 * 根据学号查询信息
	 * @param id
	 * @return
	 * @throws SQLException
	 */
	public List<ware> querywareid(String wareid) throws SQLException {
		String sql="select * from ware where wareid=?";
		ResultSet rs=store.executePsQuery(sql,wareid);
		ware ware=null;
        List<ware> list1=new ArrayList<ware>();
        while(rs.next()) {
        	ware=new ware();
        	ware.setWareid(rs.getString("wareid"));
        	ware.setWarename(rs.getString("warename"));
        	ware.setWaredd(rs.getString("waredd"));
        	ware.setColor(rs.getString("color"));
        	ware.setSize(rs.getString("size"));
        	ware.setInprize(rs.getString("inprize"));
        	ware.setOutprize(rs.getString("outprize"));
        	ware.setNum(rs.getString("num"));
        	list1.add(ware);
        }
        if(ware==null) {
        	throw new RuntimeException("库存中没有该商品的信息");
        }
        else{
        	return list1;
        }
		
	}
	
   /**
 * 根据商品条码修改库存信息
 * @param id
 * @param name
 * @param age
 * @param sex
 * @return
 * @throws SQLException
 */
	public int update(String wareid, String warename, String waredd,String color,String size,String inprize,String outprize,String num) throws SQLException {
		String sql="update ware set warename=?,waredd=?,color=?,size=?,inprize=?,outprize=?,num=?  where wareid=?";
		int no=store.executePsUpdate(sql,warename,waredd,color,size,inprize,outprize,num,wareid);
		return no;
	}
	
	
/**
 * 根据商品条码删除库存信息
 * @param delId
 * @throws SQLException
 */
    public void delBywareid(String wareid) throws SQLException {
	    String sql="delete  from ware where wareid=?";
	    int no=store.executePsUpdate(sql, wareid);
    }
}
