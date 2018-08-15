package com.ycj.web;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ActionSupport;
import com.ycj.entity.Actorinfo;
import com.ycj.service.ActorService;

public class ActorAction extends ActionSupport {
 @Autowired
 private ActorService actorService;
 private Actorinfo actorInfo;
public Actorinfo getActorInfo() {
	return actorInfo;
}
public void setActorInfo(Actorinfo actorInfo) {
	this.actorInfo = actorInfo;
}
public String selectActor() throws IOException{
	HttpServletRequest request=ServletActionContext.getRequest();
	 request.setCharacterEncoding("UTF-8");
	List <Actorinfo> list=this.actorService.selectActor(this.actorInfo.getActorname());
	System.out.println(list.toString());
	 ServletActionContext.getRequest().setAttribute("actorname",list.get(0).getActorname());
	 ServletActionContext.getRequest().setAttribute("sex",list.get(0).getSex());
	 ServletActionContext.getRequest().setAttribute("birth",list.get(0).getBirth());
	 ServletActionContext.getRequest().setAttribute("hometown",list.get(0).getHometown());
	 ServletActionContext.getRequest().setAttribute("occupation",list.get(0).getOccupation());
	 ServletActionContext.getRequest().setAttribute("describe",list.get(0).getActordescribe());
	 ServletActionContext.getRequest().setAttribute("picture",list.get(0).getUrl());
	return SUCCESS;
}
}
