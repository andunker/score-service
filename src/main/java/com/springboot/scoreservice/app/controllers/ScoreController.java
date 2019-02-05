package com.springboot.scoreservice.app.controllers;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.scoreservice.app.models.entity.Score;
import com.springboot.scoreservice.app.models.service.IScoreService;


@RestController
public class ScoreController {

	@Autowired
	private IScoreService scoreService;
	
	@RequestMapping(value="/score",  method=RequestMethod.GET, produces = "application/json")
	public List<Score> findAllScores() { 
		return	scoreService.findAll();
	}
	
	
	@RequestMapping(value="/score",  method=RequestMethod.POST, produces = "application/json")
	public String save(@Valid Score score) { 
		
		scoreService.save(score);
		return "Saved";
	}
	
	@RequestMapping(value="/score/{id}",  method=RequestMethod.POST, produces = "application/json")
	public String edit(@PathVariable(value="id") Long id, String opinion, int stars) { 
		Score score = new Score();
		score = findScore(id);
		score.setOpinion(opinion);
		score.setStars(stars);
		score.setCreateAt(Calendar.getInstance().getTime());
		scoreService.save(score);
		return "Edited";
	}
	
	@RequestMapping(value="/score/{id}",  method=RequestMethod.DELETE, produces = "application/json")
	public String delete(@PathVariable(value="id") Long id) { 
		scoreService.delete(id);
		return "Deleted";
	}
	
	@RequestMapping(value="/score/{id}", method=RequestMethod.GET, produces = "application/json")
	public Score findScore(@PathVariable(value="id") Long id) {
		return   scoreService.findOne(id);
		
	}
	
	@RequestMapping(value="/score/order/{id}", method=RequestMethod.GET, produces = "application/json")
	public Score findScoreByPurchase(@PathVariable(value="id") int id) {
		return   scoreService.findScoreByOrder(id);
		
	}
	
	@RequestMapping(value="/score/user/{id}", method=RequestMethod.GET, produces = "application/json")
	public List<Score> findByUser(@PathVariable(value="id") int id, @RequestParam("start") @DateTimeFormat(pattern="yyyy-MM-dd") Date start, @RequestParam("end") @DateTimeFormat(pattern="yyyy-MM-dd") Date  end ) {
		return  scoreService.findByUser(id, start, end);	
	}
	
	@RequestMapping(value="/score/store/{id}", method=RequestMethod.GET, produces = "application/json")
	public List<Score> findByStore(@PathVariable(value="id") int id, @RequestParam("start") @DateTimeFormat(pattern="yyyy-MM-dd") Date start, @RequestParam("end") @DateTimeFormat(pattern="yyyy-MM-dd") Date  end ) {
		return  scoreService.findByStore(id, start, end);	
	}
	
	
}
