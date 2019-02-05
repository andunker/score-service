package com.springboot.scoreservice.app.models.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.springboot.scoreservice.app.models.dao.IScoreDao;
import com.springboot.scoreservice.app.models.entity.Score;


@Service
public class ScoreServiceImpl implements IScoreService {

	
	@Autowired 
	private IScoreDao ScoreDao;
	
	@Override
	@Transactional(readOnly=true)
	public List<Score> findAll() {
		return (List<Score>) ScoreDao.findAll();
	}

	@Override
	@Transactional
	public void save(Score Score) {
		ScoreDao.save(Score);
		
	}

	@Override
	@Transactional(readOnly=true)
	public Score findOne(Long id) {
		return ScoreDao.findById(id).orElse(null); 
	}

	@Override
	@Transactional
	public void delete(Long id) {
		ScoreDao.deleteById(id);
		
	}

	@Override
	public Score findScoreByOrder(int id) {
		return 	ScoreDao.findScoreByOrder(id);
	}

	@Override
	public List<Score> findByUser(int id, Date start, Date end) {
		return ScoreDao.findByUser(id, start, end);
	}

	@Override
	public List<Score> findByStore(int id, Date start, Date end) {
		return ScoreDao.findByStore(id, start, end);
	}
	
}
