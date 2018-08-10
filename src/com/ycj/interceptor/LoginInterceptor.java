package com.ycj.interceptor;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public class LoginInterceptor extends AbstractInterceptor {
	@Override
	public String intercept(ActionInvocation invocation) throws Exception{
	    HttpSession session=ServletActionContext.getRequest().getSession();
        Object user=session.getAttribute("user");
        System.out.println(user);
        if(user==null||user.equals("")){
        	return "fail";
        }
        else{
        return invocation.invoke();	
        }
	}

}
