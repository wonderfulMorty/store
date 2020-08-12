package service;

import java.sql.SQLException;

import dao.usersDao;
import entity.Users;

public class UsersService {
	usersDao dao=new usersDao();
	Users user=new Users();
	public void register(String id,String pass,String lable) throws SQLException, InstantiationException, IllegalAccessException, ClassNotFoundException{
//		System.out.println("id="+id);
//		System.out.println("password="+pass);
		if(id==null||"".equals(id)){
			throw new RuntimeException("用户名不能为空");
		}
		if(pass==null||"".equals(pass)) {
			throw new RuntimeException("密码不能为空");
		}
		//3 唯一性判断
		//连接数据库 对象 5步骤Users
		user=dao.queryByName(id);
//		System.out.println("id="+user.getid()+"password="+user.getPassword());
		if(user!=null) {
			throw new RuntimeException("该用户已被注册");
		}
		//4 添加
		int no=dao.save(id,pass,lable);
	}
	//登录操作
	public Users login(String id,String pass) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
		//1 空值判断
		if(id==null||"".equals(id)) {
			throw new RuntimeException("用户名不能为空");
		}
		if(pass==null||"".equals(pass)) {
			throw new RuntimeException("密码不能为空");
		}
		//2 数据有效性判断
		//2.1 如果该用户已经注册了，那么我们就可以查到这个人，比较密码
		user=dao.queryByName(id);
		if(user==null) {
			throw new RuntimeException("该用户未注册");
		}
		if(!pass.equals(user.getPassword())) {	
			throw new RuntimeException("用户名或密码错误");
		}
		return user;
	}
	
//	public Users login1(String id,String pass) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
//		//1 空值判断
//		if(id==null||"".equals(id)) {
//			throw new RuntimeException("用户名不能为空");
//		}
//		if(pass==null||"".equals(pass)) {
//			throw new RuntimeException("密码不能为空");
//		}
//		//2 数据有效性判断
//		//2.1 如果该用户已经注册了，那么我们就可以查到这个人，比较密码
//		user=dao.queryByName(id);
//		if(user==null) {
//			throw new RuntimeException("该用户未注册");
//		}
//		if(!pass.equals(user.getPassword())) {	
//			throw new RuntimeException("用户名或密码错误");
//		}
//		return user;
//	}
}
