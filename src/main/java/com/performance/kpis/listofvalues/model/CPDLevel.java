package com.performance.kpis.listofvalues.model;

import jakarta.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "cpd_level")
public class CPDLevel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cpd_level_id")
    private Integer cpdLevelId;

    @Column(name = "stored_value")
    private String storedValue;

    @Column(name = "display_value")
    private String displayValue;

    @Column(name = "created_at")
    private Timestamp createdAt;

    @Column(name = "created_by")
    private String createdBy;

    @Column(name = "modified_at")
    private Timestamp modifiedAt;

    @Column(name = "modified_by")
    private String modifiedBy;

    @Column(name = "version")
    private Integer version;

    // No-arg constructor
    public CPDLevel() {
    }

    // All-args constructor
    public CPDLevel(Integer cpdLevelId, String storedValue, String displayValue,
                    Timestamp createdAt, String createdBy,
                    Timestamp modifiedAt, String modifiedBy, Integer version) {
        this.cpdLevelId = cpdLevelId;
        this.storedValue = storedValue;
        this.displayValue = displayValue;
        this.createdAt = createdAt;
        this.createdBy = createdBy;
        this.modifiedAt = modifiedAt;
        this.modifiedBy = modifiedBy;
        this.version = version;
    }

    // Getters and Setters
    public Integer getCpdLevelId() {
        return cpdLevelId;
    }

    public void setCpdLevelId(Integer cpdLevelId) {
        this.cpdLevelId = cpdLevelId;
    }

    public String getStoredValue() {
        return storedValue;
    }

    public void setStoredValue(String storedValue) {
        this.storedValue = storedValue;
    }

    public String getDisplayValue() {
        return displayValue;
    }

    public void setDisplayValue(String displayValue) {
        this.displayValue = displayValue;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public Timestamp getModifiedAt() {
        return modifiedAt;
    }

    public void setModifiedAt(Timestamp modifiedAt) {
        this.modifiedAt = modifiedAt;
    }

    public String getModifiedBy() {
        return modifiedBy;
    }

    public void setModifiedBy(String modifiedBy) {
        this.modifiedBy = modifiedBy;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }
}
