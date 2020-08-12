package service;

import java.sql.SQLException;




import java.util.List;
import entity.ware;
import dao.wareDao;
public class wareService {
	private wareDao wareDao=new wareDao();
	private ware ware=new ware();
	/**
	 * 查询整表
	 * @return
	 * @throws SQLException
	 */
	public List<ware> queryAll() throws SQLException{
		return wareDao.queryAll();
	}
	
	
	/**
	 * 添加商品
	 * @param ware
	 * @return
	 * @throws SQLException
	 */
	public int addware(ware ware) throws SQLException {
		//1.非空判断
		if(ware.getWareid()==null||"".equals(ware.getWareid())) {
			throw new RuntimeException( "商品条码不能为空");
		}
		if(ware.getWarename()==null||"".equals(ware.getWarename())) {
			throw new RuntimeException( "商品名称不能为空");
		}
		if(ware.getWaredd()==null||"".equals(ware.getWaredd())) {
			throw new RuntimeException( "货号不能为空");
		}
		if(ware.getColor()==null||"".equals(ware.getColor())) {
			throw new RuntimeException( "商品颜色不能为空");
		}
		if(ware.getSize()==null||"".equals(ware.getSize())) {
			throw new RuntimeException( "商品尺码不能为空");
		}
		
		//2.添加
		int no=wareDao.addware(ware);
		return no;
	}
	
	
    /**
     * 按商品条码查询
     * @param id
     * @return
     * @throws SQLException
     */
	public List<ware> queryId(String wareid) throws SQLException {
			return wareDao.querywareid(wareid);
	}
	
	
    /**
     * 修改商品信息
     * @param id
     * @param name
     * @param age
     * @param sex
     * @return
     * @throws SQLException
     */
	public int update(String wareid, String warename, String waredd, String color,String size,String inprize,String outprize,String num) throws SQLException {
		int no=wareDao.update(wareid,warename,waredd,color,size,inprize,outprize,num);
		return no;
		
	}

	/**
	 *根据商品条码删除商品信息
	 * @param delId
	 * @throws SQLException
	 */
	public void delBywareid(String wareid) throws SQLException {
		wareDao.delBywareid(wareid);
		
	}
}
