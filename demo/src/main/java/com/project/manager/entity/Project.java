package com.project.manager.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Setter
@Getter
@NoArgsConstructor
@Table(name="Project_Info")
public class Project {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int projectId;
	
	@Column(name="name")
	private String projectName;
	
	@Column(name="context")
	private String projectContext;
	
	@Column(name="type")
	private String projectType;
	
	@Column(name="lead")
	private String projectLead;
	
	private List<String> team=new ArrayList<>();
}
