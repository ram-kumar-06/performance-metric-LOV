package com.performance.kpis.listofvalues.model;

import jakarta.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "score")
public class Score {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "score_id")
	private Integer scoreId;

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

	public Score() {
	}

	public Score(Integer scoreId, String storedValue, String displayValue, Timestamp createdAt, String createdBy,
			Timestamp modifiedAt, String modifiedBy, Integer version) {
		this.scoreId = scoreId;
		this.storedValue = storedValue;
		this.displayValue = displayValue;
		this.createdAt = createdAt;
		this.createdBy = createdBy;
		this.modifiedAt = modifiedAt;
		this.modifiedBy = modifiedBy;
		this.version = version;
	}

	public Integer getScoreId() {
		return scoreId;
	}

	public void setScoreId(Integer scoreId) {
		this.scoreId = scoreId;
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
