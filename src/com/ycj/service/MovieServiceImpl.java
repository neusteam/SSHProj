package com.ycj.service;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ycj.dao.MovieinfoDAO;
import com.ycj.entity.Movieinfo;

@Transactional
@Service("movieService")
public class MovieServiceImpl implements MovieService {
	@Autowired
	private MovieinfoDAO movieinfoDAO;
public List<Movieinfo> findAll(int count){
	return this.movieinfoDAO.findAll(count);
}
public List<Movieinfo> selectMovie(String moviename){
	
	/*String str=null;
	try {
		 str=new String( moviename.getBytes( "utf8" ), "GBK" );
	} catch (UnsupportedEncodingException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}*/
	return this.movieinfoDAO.findByMoviename(moviename);
}
public List<Movieinfo> findByKey(String key){
	return this.movieinfoDAO.findByKey(key);
}
}
