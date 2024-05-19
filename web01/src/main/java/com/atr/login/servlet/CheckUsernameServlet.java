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
import com.mysql.cj.callback.UsernameCallback;

/**
 * Servlet implementation class CheckUsernameServlet
 */
public class CheckUsernameServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CheckUsernameServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
//		获取到用户名
		String username=request.getParameter("username");
		
		UserDao userDao=new UserDaoImpl();
		
		User user=userDao.getUserByUsername(username);
		String msg="";
		if(user == null) {
			//可用
			msg="0";
		}else {
			// 不可用
			msg="1";
		}
		
		response.setContentType("text/html;charset=utf-8");
		
		response.getWriter().println(msg);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
