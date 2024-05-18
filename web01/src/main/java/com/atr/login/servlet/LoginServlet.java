package com.atr.login.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import com.atr.login.beans.User;
import com.atr.login.dao.UserDao;
import com.atr.login.dao.UserDaoImpl;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
/**
 * @author ryx
 */

//Servlet是sun公司制定的标准，Tomcat(web应用服务器、Servlet容器)实现了这些标准
//常用方法：doGet:处理客户端的get方式请求
 //         doPost：处理post方式请求
//service:根据具体的请求去调用对应的doGet或doPost方法

public class LoginServlet extends HttpServlet{

@Override
protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	doPost(req, resp);
}@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 登录功能的实现
	System.out.println("登录请求过来啦~~~");
//	tomcat会把客户端所有的请求数据封装到request对象里面
	
	req.setCharacterEncoding("utf-8");// 保证请求没有乱码
	
//	获取用户输入的用户名和密码，进行登陆业务的处理
	String username=req.getParameter("username");
	String password=req.getParameter("password");
	System.out.println(username+","+password);
	
	
	//验证
	resp.setContentType("text/html;charset=utf-8");
	PrintWriter out=resp.getWriter();
	
	//获取Dao对象
	UserDao userdao=new UserDaoImpl();
	User user=(User) userdao.getUserByUsernameAndPassword(username, password);
	
	if(user==null) {
		
		resp.sendRedirect("login.html");
		
	}
	else {
		//登陆成功
		out.println("<h1><font color='green'> Login Success  登陆成功！</font></h1>");
	}
	
	}
}
