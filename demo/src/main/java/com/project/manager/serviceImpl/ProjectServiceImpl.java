package com.project.manager.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.manager.entity.Project;
import com.project.manager.exception.ResourceNotFoundException;
import com.project.manager.repository.ProjectRepository;
import com.project.manager.service.ProjectService;

@Service
public class ProjectServiceImpl implements ProjectService{

	@Autowired
	private ProjectRepository projectRepo;
	
	@Override
	public Project create(Project project) {
		return projectRepo.save(project);
	}

	@Override
	public Project update(Project project, int id) {
		Project upProject=this.projectRepo.findById(id).orElseThrow(()->new ResourceNotFoundException("Project not found with id: " + id));
		upProject.setProjectName(project.getProjectName());
		upProject.setProjectContext(project.getProjectContext());
		upProject.setProjectType(project.getProjectType());
		upProject.setProjectLead(project.getProjectLead());
		upProject.setTeam(project.getTeam());
		Project updatedProject=this.projectRepo.save(upProject);
		return updatedProject;
	}

	@Override
	public Project getById(int id) {
		Project project=this.projectRepo.findById(id).orElseThrow(()-> new ResourceNotFoundException("Project not found with id: "+id));
		return project;
	}

	@Override
	public List<Project> getAllProjects() {
		List<Project> projects=this.projectRepo.findAll();
		return projects;
	}

	@Override
	public void delete(int id) {
		Project project=this.projectRepo.findById(id).orElseThrow(()-> new ResourceNotFoundException("Project not found with id: "+id));
		this.projectRepo.delete(project);
	}

}
