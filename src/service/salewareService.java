package service;

import java.sql.SQLException;


import java.util.List;

import dao.salewareDao;
import entity.saleware;
import entity.saleware1;

public class salewareService {
	private salewareDao salewareDao=new salewareDao();
	private saleware saleware=new saleware();
//	/**
//	 * 查询整表
//	 * @return
//	 * @throws SQLException
//	 */
//	public List<saleware> queryAll() throws SQLException{
//		return salewareDao.queryAll();
//	}
//	
//	
//	/**
//	 * 添加商品
//	 * @param ware
//	 * @return
//	 * @throws SQLException
//	 */
//	public int addsaleware(saleware saleware) throws SQLException {
//		//1.非空判断
//		if(saleware.getWareid()==null||"".equals(saleware.getWareid())) {
//			throw new RuntimeException( "商品条码不能为空");
//		}
//		if(saleware.getWarename()==null||"".equals(saleware.getWarename())) {
//			throw new RuntimeException( "商品名称不能为空");
//		}
//		if(saleware.getRealprize()==null||"".equals(saleware.getRealprize())) {
//			throw new RuntimeException( "原价不能为空");
//		}
//		if(saleware.getSumprize()==null||"".equals(saleware.getSumprize())) {
//			throw new RuntimeException( "售价不能为空");
//		}
//		if(saleware.getWarenum()==null||"".equals(saleware.getWarenum())) {
//			throw new RuntimeException( "数量不能为空");
//		}
//		
//		//2.添加
//		int no=salewareDao.addsaleware(saleware);
//		return no;
//	}
	

	/**
	 * 按时间查询销售数据
	 * @param startTime
	 * @param endTime
	 * @param sname
	 * @return
	 * @throws SQLException 
	 */
	public List<saleware> queryAll(String startTime,String endTime,String sname) throws SQLException{
		return salewareDao.queryAll(startTime,endTime,sname);
	}

	public List<saleware> queryAll(String startTime, String endTime) throws SQLException {
	
		return salewareDao.queryAll(startTime, endTime);
	}

  
}
