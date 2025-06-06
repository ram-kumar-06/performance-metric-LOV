package com.performance.kpis.listofvalues.service;

import com.performance.kpis.listofvalues.globalException.ResourceNotFoundException;
import com.performance.kpis.listofvalues.model.CPDLevel;
import com.performance.kpis.listofvalues.repository.CPDLevelRepository;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;

@Service
public class CPDLevelService {

    private final CPDLevelRepository repository;

    // Constructor-based dependency injection
    public CPDLevelService(CPDLevelRepository repository) {
        this.repository = repository;
    }

    // Get all CPD levels
    public List<CPDLevel> getAll() {
        return repository.findAll();
    }

    // Get CPD level by ID
    public CPDLevel getById(Integer id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("CPD Level not found with ID: " + id));
    }

    // Create a new CPD level
    public CPDLevel create(CPDLevel obj) {
        obj.setVersion(1);
        return repository.save(obj);
    }

    // Update existing CPD level
    public CPDLevel update(Integer id, CPDLevel updated) {
        CPDLevel existing = getById(id);
        existing.setStoredValue(updated.getStoredValue());
        existing.setDisplayValue(updated.getDisplayValue());
        existing.setModifiedAt(new Timestamp(System.currentTimeMillis()));
        existing.setModifiedBy(updated.getModifiedBy());
        existing.setVersion(existing.getVersion() + 1);
        return repository.save(existing);
    }

    // Delete CPD level by ID
    public void delete(Integer id) {
        if (!repository.existsById(id)) {
            throw new ResourceNotFoundException("CPD Level not found with ID: " + id);
        }
        repository.deleteById(id);
    }
}
