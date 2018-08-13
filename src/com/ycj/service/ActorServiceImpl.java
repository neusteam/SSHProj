package com.ycj.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ycj.dao.ActorinfoDAO;
import com.ycj.entity.Actorinfo;

@Transactional
@Service("actorService")
public class ActorServiceImpl implements ActorService {
    @Autowired
	private ActorinfoDAO actorinfoDAO;
    public List<Actorinfo> selectActor(String actorname){
    	return this.actorinfoDAO.findByActorname(actorname);
    }
}
