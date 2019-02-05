package com.springboot.scoreservice.app.models.service;

import java.util.Date;
import java.util.List;

import com.springboot.scoreservice.app.models.entity.Score;



public interface IScoreService {

	public List<Score> findAll();
	public void save(Score cliente);
	public Score findOne(Long id);
	public void delete(Long id);
	public Score findScoreByOrder(int id);
	public List<Score> findByUser(int id, Date start, Date end);
	public List<Score> findByStore(int id, Date start, Date end);
	
}
