package com.project.manager.service;

import java.util.List;

import com.project.manager.entity.Project;

public interface ProjectService {

	Project create(Project project);
	Project update(Project project, int id);
	Project getById(int id);
	List<Project> getAllProjects();
	void delete(int id);
}
