package dao;

import java.sql.ResultSet;



import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import dbuils.DButils;
import entity.saleware;
import entity.saleware1;
import entity.staff;

public class salewareDao {

	private static DButils store=new DButils();

//	/**
//	 * 查询销售所有信息
//	 * @return
//	 * @throws SQLException
//	 */
//	public static List<saleware> queryAll() throws SQLException{
//		String sql="select * from income";
//		ResultSet rs=store.executePsQuery(sql,null);
//		saleware saleware=null;
//        List<saleware> list=new ArrayList<saleware>();
//        while(rs.next()) {
//        	saleware=new saleware();
//        	saleware.setWareid(rs.getString("wareid"));
//        	saleware.setWarename(rs.getString("warename"));
//        	saleware.setSize(rs.getString("size"));
//        	saleware.setColor(rs.getString("color"));
//        	saleware.setWarenum(rs.getString("warenum"));
//        	saleware.setRealprize(rs.getString("realprize"));
//        	saleware.setSumprize(rs.getString("sumprize"));
//        	saleware.setSaletime(rs.getString("saletime"));
//        	saleware.setSname(rs.getString("sname"));
//        	list.add(saleware);
//        }
//		return list;
//	}
//	
//	public static int addsaleware(saleware saleware) throws SQLException  {
//	    int no=0;
//		String sql="insert into income(wareid,warename,size,color,warenum,realprize,sumprize,saletime,sname)values(?,?,?,?,?,?,?,?)";
//	    no= store.executePsUpdate(sql,saleware.getWareid(),saleware.getWarename(), saleware.getSize(),saleware.getColor(),saleware.getWarenum(),saleware.getRealprize(),saleware.getSumprize(),saleware.getSaletime(),saleware.getSname());
//	    return no;
//	}
	
	/**
	 * 按时间查询销售信息
	 * 
	 * @param startTime
	 * @param endTime
	 * @param sname
	 * @return
	 * @throws SQLException
	 */
	public List<saleware> queryAll(String startTime, String endTime, String sname) throws SQLException {

		String sql = "SELECT wareid,warename,size,color,warenum,realprize,sumprize,saletime,sname " + "FROM user,income "
				+ " WHERE user.id=income.sname and saletime between ? and ADDDATE(?,1)";
		saleware sell = null;
		List<saleware> listSell = new ArrayList<saleware>();
		if (sname != null) {
			sql += " and sname=?";
			ResultSet rs = store.executePsQuery(sql, startTime, endTime, sname);

			while (rs.next()) {

				sell = new saleware();
				sell.setWareid(rs.getString("wareid"));
				sell.setWarename(rs.getString("warename"));
				sell.setSize(rs.getString("size"));
				sell.setColor(rs.getString("color"));
				sell.setWarenum(rs.getString("warenum"));
				sell.setRealprize(rs.getString("realprize"));
				sell.setSumprize(rs.getString("sumprize"));
				sell.setSaletime(rs.getString("saletime"));
				sell.setSname(rs.getString("sname"));
				listSell.add(sell);
			}
		} else {
			ResultSet rs1 = store.executePsQuery(sql, startTime, endTime);
			while (rs1.next()) {
				sell = new saleware();
				sell.setWareid(rs1.getString("wareid"));
				sell.setWarename(rs1.getString("warename"));
				sell.setSize(rs1.getString("size"));
				sell.setColor(rs1.getString("color"));
				sell.setWarenum(rs1.getString("warenum"));
				sell.setRealprize(rs1.getString("realprize"));
				sell.setSumprize(rs1.getString("sumprize"));
				sell.setSaletime(rs1.getString("saletime"));
				sell.setSname(rs1.getString("sname"));
				listSell.add(sell);
			}
		}
		return listSell;
	}
	
//计算员工工资
		public List<saleware> queryAll(String startTime, String endTime) throws SQLException {
			
			String sql = "SELECT MAX(staff.id) as sid,MAX(staff.realname) as sname,MAX(staff.income) as spercent,SUM(income.sumprize) as sellsum " + 
					"FROM income,staff " + 
					"WHERE income.sname=staff.id and saletime between ? and ADDDATE(?,1)" + 
					"GROUP BY income.sname  ";
			
			ResultSet rs = store.executePsQuery(sql, startTime, endTime);
			saleware sell = null;
			staff sta = null;
			List<saleware> list = new ArrayList<saleware>();

			while (rs.next()) {
				sta = new staff();
				sta.setId(rs.getString("sid"));
				sta.setRealname(rs.getString("sname"));
				sta.setIncome(rs.getString("spercent"));
				
				sell = new saleware();
	            sell.setSumprize(rs.getString("sellsum"));
	            
	            sell.setStaff(sta);
	            list.add(sell);
			}
			return list;

			
		}
}
