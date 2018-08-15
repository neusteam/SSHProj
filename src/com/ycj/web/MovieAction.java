package com.ycj.web;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.fastjson.JSONObject;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.ycj.entity.Movieinfo;
import com.ycj.service.MovieService;
import com.ycj.util.JsonDecoding;


public class MovieAction extends ActionSupport{
	@Autowired
	private MovieService movieService;
	private Movieinfo movieInfo;
	private String result;
	private String keyWord;
	
	public String getKeyWord() {
		return keyWord;
	}
	public void setKeyWord(String keyWord) {
		this.keyWord = keyWord;
	}
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
 public String selectMovie() throws IOException{
	 HttpServletRequest request=ServletActionContext.getRequest();
	 request.setCharacterEncoding("UTF-8");
	 //System.out.println(this.movieInfo.getMoviename());
	  String mn=movieInfo.getMoviename();
	  List <Movieinfo> list =this.movieService.selectMovie(mn);
	  System.out.println(list.toString());
	  ServletActionContext.getRequest().setAttribute("moviename",list.get(0).getMoviename());
	  ServletActionContext.getRequest().setAttribute("director",list.get(0).getDirector());
	  ServletActionContext.getRequest().setAttribute("type",list.get(0).getType());
	  ServletActionContext.getRequest().setAttribute("country",list.get(0).getCountry());
	  ServletActionContext.getRequest().setAttribute("language",list.get(0).getLanguage());
	  ServletActionContext.getRequest().setAttribute("date",list.get(0).getDate());
	  ServletActionContext.getRequest().setAttribute("score",list.get(0).getAverage());
	  ServletActionContext.getRequest().setAttribute("picture",list.get(0).getPicture());
	  ServletActionContext.getRequest().setAttribute("describe",list.get(0).getMoviedescribe());
	  String []a=list.get(0).getActor().split("/");
	  ServletActionContext.getRequest().setAttribute("ac",a);
	  String []d=list.get(0).getDirector().split("/");
	  ServletActionContext.getRequest().setAttribute("dc",d);
	  return SUCCESS;
	 
  }
 
 public String findByKey() throws IOException{
	 HttpServletRequest request=ServletActionContext.getRequest();
	 request.setCharacterEncoding("UTF-8");
	 List<Movieinfo> list =this.movieService.findByKey(this.keyWord);
	 if(list.size()!=0){
		 ServletActionContext.getRequest().setAttribute("list",list);
		 return SUCCESS;
	 }
	 else{
		 return "fail";
	 }
 }
}
