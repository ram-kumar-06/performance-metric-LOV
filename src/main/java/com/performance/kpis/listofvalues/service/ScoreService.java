package com.performance.kpis.listofvalues.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.performance.kpis.listofvalues.model.Score;
import com.performance.kpis.listofvalues.repository.ScoreRepository;
import java.sql.Timestamp;

@Service
public class ScoreService {

    private final ScoreRepository repository;

    // Constructor-based dependency injection
    public ScoreService(ScoreRepository repository) {
        this.repository = repository;
    }

    // Get all scores
    public List<Score> getAll() {
        return repository.findAll();
    }

    // Get a score by ID, throw exception if not found
    public Score getById(Integer id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Score not found with ID: " + id));
    }

    // Create a new score
    public Score create(Score score) {
        score.setVersion(1);
        return repository.save(score);
    }

    // Update an existing score
    public Score update(Integer id, Score updated) {
        Score existing = getById(id);
        existing.setStoredValue(updated.getStoredValue());
        existing.setDisplayValue(updated.getDisplayValue());
        existing.setModifiedAt(new Timestamp(System.currentTimeMillis()));
        existing.setModifiedBy(updated.getModifiedBy());
        existing.setVersion(existing.getVersion() + 1);
        return repository.save(existing);
    }

    // Delete a score by ID
    public void delete(Integer id) {
        if (!repository.existsById(id)) {
            throw new RuntimeException("Cannot delete. Score not found with ID: " + id);
        }
        repository.deleteById(id);
    }
}