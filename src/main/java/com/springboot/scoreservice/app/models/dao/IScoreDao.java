package com.springboot.scoreservice.app.models.dao;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.springboot.scoreservice.app.models.entity.Score;

public interface IScoreDao extends CrudRepository<Score, Long> {

	@Query("from Score where id_order=:id_order")
	Score findScoreByOrder(@Param("id_order") int id_order);

	@Query("from Score where id_user=:id_user and create_at  between :start and :end ")
	List<Score> findByUser(@Param("id_user") int id, @Param("start") Date start, @Param("end") Date end);

	@Query("from Score where id_store=:id_store and create_at  between :start and :end ")
	List<Score> findByStore(@Param("id_store") int id, @Param("start") Date start, @Param("end") Date end);


}
