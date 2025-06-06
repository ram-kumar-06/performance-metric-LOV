package com.performance.kpis.listofvalues.controller;

import com.performance.kpis.listofvalues.model.CPDLevel;
import com.performance.kpis.listofvalues.service.CPDLevelService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cpd-levels")
public class CPDLevelController {

    private final CPDLevelService service;

    // Constructor-based dependency injection
    public CPDLevelController(CPDLevelService service) {
        this.service = service;
    }

    // GET /api/cpd-levels
    @GetMapping
    public ResponseEntity<List<CPDLevel>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }

    // GET /api/cpd-levels/{id}
    @GetMapping("/{id}")
    public ResponseEntity<CPDLevel> get(@PathVariable Integer id) {
        return ResponseEntity.ok(service.getById(id));
    }

    // POST /api/cpd-levels
    @PostMapping
    public ResponseEntity<CPDLevel> create(@RequestBody CPDLevel obj) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.create(obj));
    }

    // PUT /api/cpd-levels/{id}
    @PutMapping("/{id}")
    public ResponseEntity<CPDLevel> update(@PathVariable Integer id, @RequestBody CPDLevel obj) {
        return ResponseEntity.ok(service.update(id, obj));
    }

    // DELETE /api/cpd-levels/{id}
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
