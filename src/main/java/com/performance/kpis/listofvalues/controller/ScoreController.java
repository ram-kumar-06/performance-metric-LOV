package com.performance.kpis.listofvalues.controller;

import com.performance.kpis.listofvalues.model.Score;
import com.performance.kpis.listofvalues.service.ScoreService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/scores")
public class ScoreController {

    private final ScoreService service;

    // Constructor-based dependency injection (manually written)
    public ScoreController(ScoreService service) {
        this.service = service;
    }

    // GET /api/scores
    @GetMapping
    public ResponseEntity<List<Score>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }

    // GET /api/scores/{id}
    @GetMapping("/{id}")
    public ResponseEntity<Score> get(@PathVariable Integer id) {
        return ResponseEntity.ok(service.getById(id));
    }

    // POST /api/scores
    @PostMapping
    public ResponseEntity<Score> create(@RequestBody Score obj) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.create(obj));
    }

    // PUT /api/scores/{id}
    @PutMapping("/{id}")
    public ResponseEntity<Score> update(@PathVariable Integer id, @RequestBody Score obj) {
        return ResponseEntity.ok(service.update(id, obj));
    }

    // DELETE /api/scores/{id}
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
