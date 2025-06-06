package com.performance.kpis.listofvalues.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.performance.kpis.listofvalues.model.Score;

public interface ScoreRepository  extends JpaRepository<Score, Integer> {
	
	
}