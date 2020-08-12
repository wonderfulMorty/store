package service;

import java.sql.SQLException;
import java.util.List;

import dao.saleware1Dao;
import dao.salewareDao;
import entity.saleware;
import entity.saleware1;

public class saleware1Service {
	private saleware1Dao salewareDao=new saleware1Dao();
	private saleware1 saleware=new saleware1();
	/**
	 * 查询整表
	 * @return
	 * @throws SQLException
	 */
	public List<saleware1> queryAll() throws SQLException{
		return salewareDao.queryAll();
	}
	
	
	/**
	 * 添加商品
	 * @param ware
	 * @return
	 * @throws SQLException
	 */
	public int addsaleware1(saleware1 saleware) throws SQLException {
		//1.非空判断
		if(saleware.getWareid()==null||"".equals(saleware.getWareid())) {
			throw new RuntimeException( "商品条码不能为空");
		}
		if(saleware.getWarename()==null||"".equals(saleware.getWarename())) {
			throw new RuntimeException( "商品名称不能为空");
		}
		if(saleware.getRealprize()==null||"".equals(saleware.getRealprize())) {
			throw new RuntimeException( "原价不能为空");
		}
		if(saleware.getSumprize()==null||"".equals(saleware.getSumprize())) {
			throw new RuntimeException( "售价不能为空");
		}
		if(saleware.getWarenum()==null||"".equals(saleware.getWarenum())) {
			throw new RuntimeException( "数量不能为空");
		}
		
		//2.添加
		int no=salewareDao.addsaleware1(saleware);
		return no;
	}
	
}
