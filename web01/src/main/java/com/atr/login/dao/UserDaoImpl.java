package com.atr.login.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


import com.atr.login.beans.User;
import com.atr.login.utils.ConnectionUtils;

public class UserDaoImpl implements UserDao{

	@Override
	public User getUserByUsernameAndPassword(String username, String password) {
		User u=null;
		try {
			//JDBC  获取连接   编写SQL 预编译SQL 设置参数 执行SQL 封装结果  关闭连接
			/*
			 * Class.forName("com.mysql.jdbc.Driver"); String url =
			 * "jdbc:mysql://localhost:3306/db_01"; String user = "root"; String pwd =
			 * "723208"; Connection conn = DriverManager.getConnection(url, user, pwd);
			 */
			Connection conn = ConnectionUtils.getConn();
			
			String sql="select id,username,password from tb1_user where username =? and password=?";
			
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1,username);
			ps.setString(2, password);
			ResultSet rs=ps.executeQuery();
			if(rs.next()) {
				u=new User();
				u.setId(rs.getInt("id"));
				u.setUsername(rs.getString("username"));
				u.setPassword(rs.getString("password"));
			}
			return  u;
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				ConnectionUtils.closeConn();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return null;
	}

}
