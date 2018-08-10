package com.ycj.web;

import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
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
		List<Users> list=this.userService.findUser(this.user.getUsername());
		if(list.size()!=0){
			return "fail";
		}
		else{
			user.setStatus(1);
			this.userService.addUser(this.user);
			ActionContext.getContext().put("msg", "注册成功！");
			return SUCCESS;
		}
	}
  public String userLogin(){
	  System.out.println("GG");
	System.out.println(this.user);
	 List<Users> list=this.userService.findUser(this.user.getUsername());
	 
	  System.out.println("信息："+list.toString());
	  if (list.size()>0){
		  if(list.get(0).getPassword().equals(user.getPassword())&&1==list.get(0).getStatus()){
			  HttpServletResponse response=ServletActionContext.getResponse();
			  HttpSession session= ServletActionContext.getRequest().getSession();
		  	session.setAttribute("user",user.getUsername());
		  	Cookie cookie=new Cookie("username",user.getUsername());
			cookie.setMaxAge(3000);
        	cookie.setPath("/");
        	response.addCookie(cookie);
			  return SUCCESS;
		  }	  else{
			  return "fail";
		  }
	  }
	  else{
		  return "fail";
	  }

  }
  public String adminLogin(){
	  List<Users> list=this.userService.findUser(this.user.getUsername());
		 
	  System.out.println("信息："+list.toString());
	  if (list.size()>0){
		  if(list.get(0).getPassword().equals(user.getPassword())&&2==list.get(0).getStatus()){
			  
			  HttpSession session= ServletActionContext.getRequest().getSession();
		  	session.setAttribute("user",user.getUsername());
			
			  return SUCCESS;
		  }	  else{
			  return "fail";
		  }
	  }
	  else{
		  return "fail";
	  }
  }
  public String findAllUser(){
	  List<Users> list=this.userService.findAll();
	  System.out.println("信息："+list.toString());
	  return SUCCESS;
  }
}
