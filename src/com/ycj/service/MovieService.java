package com.ycj.service;

import java.util.List;

import com.ycj.entity.Movieinfo;

public interface MovieService {
public List<Movieinfo> findAll(int count);
public List<Movieinfo> selectMovie(String moviename);
public List<Movieinfo> findByKey(String key);
public List<Movieinfo> findAverage(int count);
public List<Movieinfo> findDate(int count);
}
