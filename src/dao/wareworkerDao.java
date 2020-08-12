package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dbuils.DButils;
import entity.ware;
import entity.wareworker;

public class wareworkerDao {
	
	private DButils store=new DButils();
	public List<wareworker> queryAll() throws SQLException {
		
		String sql="select worker.workerid,worker.workername,worker.workertel,ware.wareid,ware.warename,ware.waredd from ware ,worker where worker.wareid=ware.wareid";
		ResultSet rs=store.executePsQuery(sql, null);
		List<wareworker> list=new ArrayList<wareworker>();
		ware ware=null;
		wareworker worker=null;
		while(rs.next()) {
			ware=new ware();
			ware.setWareid(rs.getString("wareid"));
			ware.setWarename(rs.getString("warename"));
			ware.setWaredd(rs.getString("waredd"));
			worker=new wareworker();
			worker.setWorkerid(rs.getString("workerid"));
			worker.setWorkername(rs.getString("workername"));
			worker.setWorkertel(rs.getString("workertel"));
			worker.setWare(ware);
			list.add(worker);
			
		}
		return list;
		
		
	}
}
