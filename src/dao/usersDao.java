package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import dbuils.DButils;
import entity.Users;

public class usersDao {
	
	private static DButils store=new DButils();
	public static Users queryByName(String id)throws SQLException, InstantiationException, IllegalAccessException, ClassNotFoundException {
		String sql="SELECT * FROM user WHERE id=?";
		ResultSet rs=store.executePsQuery(sql,id);
		Users user=null;
		while(rs.next()) {
			user=new Users();
			user.setid(rs.getString("id"));
			user.setPassword(rs.getString("password"));
			user.setLable(rs.getString("lable"));
		}
		store.close();
		return user;//
	}
	
	public int save(String id,String pass,String lable) throws SQLException{
		String sql="insert into user(id,password,lable)values(?,?,?)";
		int no=store.executePsUpdate(sql,id,pass,lable);
		return no;
	}
}
