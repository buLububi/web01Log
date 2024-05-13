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
//	@Override
//		protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//			// TODO Auto-generated method stub
//			super.service(req,resp);
//		}

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
		//登陆失败
//		out.println("<h1><font color='red'>Login fail  登陆失败！</font></h1>");
		String str="<!DOCTYPE html>"+
		"<html lang='en'>"+
		"<head>"+
		    "<meta charset='UTF-8'>"+
		    "<meta name='viewport' content='width=device-width, initial-scale=1.0'>"+
		    "<title>用户登录</title>"+
		"</head>"+
		"<style>"+
		   " * {"+
		       " padding: 0;"+
		        "margin: 0;"+
		   " }"+

		   " div {"+
		      "  width: 480px;"+
		      "  height: 677px;"+

		      "  background-color: #08adff;"+

		   " }"+

		  "  h3 {"+
		       " font-weight: 400;"+
		       " font-family: 'Times New Roman', Times, serif;"+
		       " height: 150px;"+

		       " padding: 100px 100px 100px 100px;"+
		       " font-size: 40px;"+
		      "  text-align: center;"+
		       " line-height: 200px;"+
		  "  }"+

		  "  body {"+
		       " width: 1200px;"+
		       " height: 697px;"+
		       " background-image: skyblue;"+
		       " background-repeat: no-repeat;"+
		       " background-position: center;"+
		       " background-size: cover;"+

		    "}"+

		    "font {"+
		       " display: inline-block;"+
		       " font-family: 'Times New Roman', Times, serif;"+
		       " font-size: 20px;"+
		        "text-align: center;"+
		       " width: 150px;"+
		       " height: 40px;"+
		       " line-height: 40px;"+

		   " }"+

		   " input {"+
		       " display: inline-block;"+
		       " width: 238px;"+
		       " height: 33px;"+
		       " padding: 0;"+
		      "  border: 0;"+
		       " border-left: 0;"+
		      "  padding: 0 9px;"+
		     "   border-radius: 8px;"+
		  "  }"+

		    "div .cl2 {"+
		       " height: 245px;"+
		      "  text-align: center;"+

		   " }"+

		   " .submit {"+
		     "   display: block;"+
		     "   border: 0;"+
		     "   width: 200px;"+
		      "  height: 40px;"+
		     "   border-radius: 0;"+
		     "   margin: 10px 50px 20px 50px;"+
		     "   position: absolute;"+
		     "   left: 71px;"+
		     "   top: 569px;"+
		    "}"+

		   " .submit:hover,"+
		   " .reset:hover {"+
		   "     background-color: #9cd3ef;"+
		 "   }"+

		 "   .submit:active,"+
		  "  reset:active {"+
		   "     color: red;"+

		  "  }"+

		    ".reset {"+
		    "    display: block;"+
		    "    border: 0;"+
		    "    width: 200px;"+
		    "    height: 40px;"+
		     "   border-radius: 0;"+
		     "   margin: 10px 50px 20px 50px;"+
		      "  position: absolute;"+
		     "   left: 71px;"+
		    "    top: 620px;"+
		   " }"+
		"</style>"+

		"<body>"+
		
		"    <div>"+

		  "      <form action='login' name='log' method='post' target='_blank'>"+
		           " <h3>用户登录</h3>"+
		          "  <font>用户名：</font>"+
		          "  <input type='text' name='username' id='username' placeholder='请输入用户名' value="+username+"><span><font color='red'>用户名或密码输入错误</font></span><br />"+
		           " <font>密码：</font>"+
		          "  <input type='password' name='password' id='password' placeholder='请输入密码'><br />"+
		         "   <div class='cl2'>"+
		            "    <input type='submit' value='登录' class='submit'>"+
		            "    <input type='reset' value='重置' class='reset'>"+
		         "   </div>"+

		       " </form>"+
		  " </div>"+
		"</body>"+

	"	</html>";
		out.println(str);
	}
	else {
		//登陆成功
		out.println("<h1><font color='green'> Login Success  登陆成功！</font></h1>");
	}
	
//	if("ryx".equalsIgnoreCase(username)&&"123456".equalsIgnoreCase(password)) {
////		登陆成功
////		通过响应对象，给客户端响应数据
//		out.println("<h1><font color='green'> Login Success  登陆成功！</font></h1>");
//		out.println("<p>您的用户名是: " + username + "</p>");
//	    out.println("<p>您的密码是: " + password + "</p>");
//	}
//	else {
////		登陆失败
//		out.println("<h1><font color='red'>Login fail  登陆失败！</font></h1>");
//		out.println("<p>您的用户名是: " + username + "</p>");
//	    out.println("<p>您的密码是: " + password + "</p>");
//	}
	}
}
