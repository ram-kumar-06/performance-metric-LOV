package com.performance.kpis.listofvalues.service;

import com.performance.kpis.listofvalues.globalException.ResourceNotFoundException;
import com.performance.kpis.listofvalues.model.CPDStage;
import com.performance.kpis.listofvalues.repository.CPDStageRepository;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;

@Service
public class CPDStageService {

    private final CPDStageRepository repository;

    // Constructor-based injection
    public CPDStageService(CPDStageRepository repository) {
        this.repository = repository;
    }

    // Get all CPD stages
    public List<CPDStage> getAll() {
        return repository.findAll();
    }

    // Get CPD stage by ID
    public CPDStage getById(Integer id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("CPD Stage not found with ID: " + id));
    }

    // Create new CPD stage
    public CPDStage create(CPDStage obj) {
        obj.setVersion(1);
        return repository.save(obj);
    }

    // Update CPD stage
    public CPDStage update(Integer id, CPDStage updated) {
        CPDStage existing = getById(id);
        existing.setStoredValue(updated.getStoredValue());
        existing.setDisplayValue(updated.getDisplayValue());
        existing.setModifiedAt(new Timestamp(System.currentTimeMillis()));
        existing.setModifiedBy(updated.getModifiedBy());
        existing.setVersion(existing.getVersion() + 1);
        return repository.save(existing);
    }

    // Delete CPD stage
    public void delete(Integer id) {
        if (!repository.existsById(id)) {
            throw new ResourceNotFoundException("Cannot delete. CPD Stage not found with ID: " + id);
        }
        repository.deleteById(id);
    }
}
