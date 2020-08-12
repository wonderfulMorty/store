package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dbuils.DButils;
import entity.saleware;
import entity.saleware1;

public class saleware1Dao {
	private static DButils store=new DButils();

	/**
	 * 查询销售所有信息
	 * @return
	 * @throws SQLException
	 */
	public static List<saleware1> queryAll() throws SQLException{
		String sql="select * from income";
		ResultSet rs=store.executePsQuery(sql,null);
		saleware1 saleware=null;
        List<saleware1> list=new ArrayList<saleware1>();
        while(rs.next()) {
        	saleware=new saleware1();
        	saleware.setWareid(rs.getString("wareid"));
        	saleware.setWarename(rs.getString("warename"));
        	saleware.setSize(rs.getString("size"));
        	saleware.setColor(rs.getString("color"));
        	saleware.setWarenum(rs.getString("warenum"));
        	saleware.setRealprize(rs.getString("realprize"));
        	saleware.setSumprize(rs.getString("sumprize"));
        	saleware.setSaletime(rs.getString("saletime"));
        	saleware.setSname(rs.getString("sname"));
        	list.add(saleware);
        }
		return list;
	}
	
	public static int addsaleware1(saleware1 saleware1) throws SQLException  {
	    int no=0;
		String sql="insert into income(wareid,warename,size,color,warenum,realprize,sumprize,saletime,sname)values(?,?,?,?,?,?,?,?,?)";
	    no= store.executePsUpdate(sql,saleware1.getWareid(),saleware1.getWarename(), saleware1.getSize(),saleware1.getColor(),saleware1.getWarenum(),saleware1.getRealprize(),saleware1.getSumprize(),saleware1.getSaletime(),saleware1.getSname());
	    return no;
	}
}
