package com.atr.login.dao;
import com.atr.login.beans.User;

public interface UserDao {

	public User getUserByUsernameAndPassword(String username,String password);
}
