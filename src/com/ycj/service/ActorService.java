package com.ycj.service;

import java.util.List;

import com.ycj.entity.Actorinfo;



public interface ActorService {
	public List<Actorinfo> selectActor(String actorname);
}
