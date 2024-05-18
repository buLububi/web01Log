package com.atr.login.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import org.apache.catalina.Server;

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
		/*
		 * JSP:Java Server Pages,运行在Java服务器（如Tomcat)的页面,本质上是一个Servlet
		 * 它的构成有HTML,Java代码,JSP标签
		 * jsp页面执行原理：
		 * java片段照搬到控制台
		 * html、css、js、表达式  通过输出流out.writer()往界面上写，因此jsp更适用于页面显示
		 * 
		 * 重定向：浏览器第一次请求给到服务器端，比如登录，浏览器发现登陆失败，就会返回一个302状态码和url地址，
		 *         浏览器根据返回来的url地址，进行第二次对服务器新的访问，在这个过程中，浏览器发送了两次请求，
		 *         每一次请求都会有自己对应的请求对象与响应对象（可以重定向到服务器外部）
		 *  转发：浏览器发来一次请求，进入login servlet处理，login servlet只会判断登陆成功还是失败，不擅长把结果反馈出来，
		 *  		他就转发给jsp界面，jsp就把这个错误信息显示出来，整个过程只发生了一次请求，在服务器内部进行了一次转发，只用到一个请求对象和一个响应对象
		 */
		resp.sendRedirect("login.jsp");
		
	}
	else {
		//登陆成功
		out.println("<h1><font color='green'> Login Success  登陆成功！</font></h1>");
	}
	
	}
}
