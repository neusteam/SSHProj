package com.ycj.service;

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
}
