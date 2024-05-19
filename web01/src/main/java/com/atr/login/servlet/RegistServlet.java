package com.atr.login.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.atr.login.beans.User;
import com.atr.login.dao.UserDao;
import com.atr.login.dao.UserDaoImpl;

/**
 * Servlet implementation class RegistServlet
 */
public class RegistServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegistServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
//          Ajax:Asychornous Javascript And XML的简称。直译为异步的JS和XML
//    		     意义：你发送你的请求，我照样去操作我的页面
//    	异步请求对象：
//    	XMLHttpRequest对象是AJAX 里非常重要的对象，所有AJAX 操作都是基于该对象的
//    	XMLHttpRequest对象用来封装报文，我们向服务器发送的请求信息都需要全部封装到该对象中
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 注册的业务处理
//		1.获取用户提交的注册信息
		String username=req.getParameter("username");
		String password=req.getParameter("password");
//		2.判断用户名是否可用
		UserDao userDao=new UserDaoImpl();
		
		User user=userDao.getUserByUsername(username);
		if(user!=null) {
			//注册失败，回到注册界面并进行提示
			//转发
			req.setAttribute("regist_meg", "用户名已经存在!");
			req.getRequestDispatcher("regist.jsp").forward(req, resp);
		}
		else {
			//可以注册
//		3.将用户注册的信息插入到数据库
		userDao.insertUser(username, password);	
		//注册成功去往登录页面
		resp.sendRedirect("login.jsp");
		
		}
	}

}
