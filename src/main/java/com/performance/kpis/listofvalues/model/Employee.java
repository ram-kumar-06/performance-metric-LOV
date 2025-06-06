package com.performance.kpis.listofvalues.model;

import jakarta.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "employees")
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "employee_id")
	private Integer employeeId;

	@Column(name = "first_name")
	private String firstName;

	@Column(name = "last_name")
	private String lastName;

	private String email;

	@Column(name = "employee_no")
	private String employeeNo;

	private String practice;

	private String portfolio;

	@ManyToOne
	@JoinColumn(name = "cpd_level_id", referencedColumnName = "cpd_level_id")
	private CPDLevel cpdLevel;

	@Column(name = "is_admin")
	private Boolean isAdmin;

	@ManyToOne
	@JoinColumn(name = "cpd_stage_id", referencedColumnName = "cpd_stage_id")
	private CPDStage cpdStage;

	@ManyToOne
	@JoinColumn(name = "score_id", referencedColumnName = "score_id")
	private Score score;

	@Column(name = "created_at")
	private Timestamp createdAt;

	@Column(name = "created_by")
	private String createdBy;

	@Column(name = "modified_at")
	private Timestamp modifiedAt;

	@Column(name = "modified_by")
	private String modifiedBy;

	private Integer version;

	// === Getters and Setters ===
	public Integer getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(Integer employeeId) {
		this.employeeId = employeeId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getEmployeeNo() {
		return employeeNo;
	}

	public void setEmployeeNo(String employeeNo) {
		this.employeeNo = employeeNo;
	}

	public String getPractice() {
		return practice;
	}

	public void setPractice(String practice) {
		this.practice = practice;
	}

	public String getPortfolio() {
		return portfolio;
	}

	public void setPortfolio(String portfolio) {
		this.portfolio = portfolio;
	}

	public Boolean getIsAdmin() {
		return isAdmin;
	}

	public void setIsAdmin(Boolean isAdmin) {
		this.isAdmin = isAdmin;
	}

	public CPDLevel getCpdLevel() {
		return cpdLevel;
	}

	public void setCpdLevel(CPDLevel cpdLevel) {
		this.cpdLevel = cpdLevel;
	}

	public CPDStage getCpdStage() {
		return cpdStage;
	}

	public void setCpdStage(CPDStage cpdStage) {
		this.cpdStage = cpdStage;
	}

	public Score getScore() {
		return score;
	}

	public void setScore(Score score) {
		this.score = score;
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
