package dbuils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DButils {
	private static final String URL="jdbc:mysql://localhost:3306/store";
	private static final String USER="root";
	private static final String PSW="ln579683";
	private Connection conn=null;
	private PreparedStatement ps=null;
	private ResultSet rs;
	
	static {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public int executePsUpdate(String sql,Object...arr) throws SQLException {
		int no=0;
		try {
			conn=DriverManager.getConnection(URL,USER,PSW);
			ps=conn.prepareStatement(sql);//预锟斤拷锟斤拷sql指锟斤拷
			if(arr !=null) {//锟斤拷锟斤拷锟斤拷锟斤拷取锟斤拷锟斤拷
				//2.锟斤拷锟斤拷
				for(int i=1;i<=arr.length;i++) {
					ps.setObject(i, arr[i-1]);
				}
			}
			no=ps.executeUpdate();
		}finally {
			close();
		}
		 return no;
	}	
	
	/*
	 * 锟斤拷锟杰ｏ拷锟斤拷询
	 */
	public ResultSet  executePsQuery(String sql,Object...arr) throws SQLException {

			conn=DriverManager.getConnection(URL,USER,PSW);
			ps=conn.prepareStatement(sql);//1.预锟斤拷锟斤拷sql指锟斤拷
			if(arr !=null) {//锟斤拷锟斤拷锟斤拷锟斤拷取锟斤拷锟斤拷
				//2.锟斤拷锟斤拷
				for(int i=1;i<=arr.length;i++) {
					ps.setObject(i, arr[i-1]);
				}
			}
			rs=ps.executeQuery();
			return rs;
	}	
	
	public void close() throws SQLException {
	
			if(rs!=null) {
				rs.close();
			}
			if(ps!=null) {
				ps.close();
			}
			if(conn!=null) {
				conn.close();
			}
			
     }
		

}
