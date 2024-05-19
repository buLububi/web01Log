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
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
/**
 * Servlet implementation class RegistServlet
 */
public class RegistServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
   
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 设置响应内容类型为 JSON
        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");

        // 获取用户提交的注册信息
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        // 判断用户名是否可用
        UserDao userDao = new UserDaoImpl();
        User user = userDao.getUserByUsername(username);
        JSONObject jsonResponse = new JSONObject();

        if (user != null) {
            // 用户名已存在
            jsonResponse.put("status", "error");
            jsonResponse.put("message", "用户名已经存在!");

            resp.getWriter().print(jsonResponse.toString());
        } else {
            // 用户名可用，进行注册
            userDao.insertUser(username, password);

            // 注册成功
            jsonResponse.put("status", "success");
            jsonResponse.put("message", "注册成功，请登录.");

            resp.getWriter().print(jsonResponse.toString());
        }
    }

	}


