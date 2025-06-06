package com.performance.kpis.listofvalues.controller;

import com.performance.kpis.listofvalues.model.CPDStage;
import com.performance.kpis.listofvalues.service.CPDStageService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cpd-stages")
public class CPDStageController {

    private final CPDStageService service;

    // Constructor-based dependency injection
    public CPDStageController(CPDStageService service) {
        this.service = service;
    }

    // GET /api/cpd-stages
    @GetMapping
    public ResponseEntity<List<CPDStage>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }

    // GET /api/cpd-stages/{id}
    @GetMapping("/{id}")
    public ResponseEntity<CPDStage> get(@PathVariable Integer id) {
        return ResponseEntity.ok(service.getById(id));
    }

    // POST /api/cpd-stages
    @PostMapping
    public ResponseEntity<CPDStage> create(@RequestBody CPDStage obj) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.create(obj));
    }

    // PUT /api/cpd-stages/{id}
    @PutMapping("/{id}")
    public ResponseEntity<CPDStage> update(@PathVariable Integer id, @RequestBody CPDStage obj) {
        return ResponseEntity.ok(service.update(id, obj));
    }

    // DELETE /api/cpd-stages/{id}
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
