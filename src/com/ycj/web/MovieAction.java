package com.ycj.web;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.fastjson.JSONObject;
import com.opensymphony.xwork2.ActionSupport;
import com.ycj.entity.Movieinfo;
import com.ycj.service.MovieService;
import com.ycj.util.JsonDecoding;


public class MovieAction extends ActionSupport{
	@Autowired
	private MovieService movieService;
	private Movieinfo movieInfo;
	
	private String result;
	
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	public Movieinfo getMovieInfo() {
		return movieInfo;
	}
	public void setMovieInfo(Movieinfo movieInfo) {
		this.movieInfo = movieInfo;
	}
	public String findAllMovie() throws IOException{
		HttpServletRequest request=ServletActionContext.getRequest();
		HttpServletResponse response=ServletActionContext.getResponse();
		response.setContentType("application/json;charset=utf-8");
		request.setCharacterEncoding("UTF-8");
		String json = JsonDecoding.readJSONString(request);
		JSONObject jo = JSONObject.parseObject(json);
		int count = Integer.parseInt(jo.getString("count"));
		List <Movieinfo> list=this.movieService.findAll(count);
//		System.out.println("电影信息"+list.toString());
		result = list.toString();
		return SUCCESS;
	}

}
