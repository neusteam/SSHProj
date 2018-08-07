package com.ycj.web;

import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.ycj.dao.Users;
import com.ycj.service.UserService;

public class UserAction extends ActionSupport{
	@Autowired
	private UserService  userService;
	private Users user;
	public Users getUser() {
		return user;
	}
	public void setUser(Users user) {
		this.user = user;
	}
	public String register(){
		System.out.println(user.getUsername());
		System.out.println(user.getPassword());
		this.userService.addUser(this.user);
		ActionContext.getContext().put("msg", "×¢²á³É¹¦£¡");
		return SUCCESS;
	}

}
