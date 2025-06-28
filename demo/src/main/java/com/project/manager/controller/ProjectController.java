package com.project.manager.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.manager.entity.Project;
import com.project.manager.service.ProjectService;

@RestController
@RequestMapping("/project")
public class ProjectController {

	@Autowired
	private ProjectService projectService;
	
	@PostMapping("/create")
	public ResponseEntity<Project> create(@RequestBody Project project){
		return new ResponseEntity<>(projectService.create(project),HttpStatus.CREATED);
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<Project> update(@RequestBody Project userDto, @PathVariable int id){
		Project updatedProject=this.projectService.update(userDto, id);
		return new ResponseEntity<>(updatedProject,HttpStatus.OK);
	}
	
	@GetMapping("/getProject/{id}")
	public ResponseEntity<Project> getProject(@PathVariable int id){
		Project project=this.projectService.getById(id);
		return new ResponseEntity<>(project,HttpStatus.OK);
	}
	
	@GetMapping("getAllProject")
	public ResponseEntity<List<Project>> getAllProjects(){
		return new ResponseEntity<>(this.projectService.getAllProjects(),HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> delete(@RequestBody Project project, @PathVariable int id) {
		this.projectService.delete(id);
		return new ResponseEntity<>(Map.of("message","User Deleted Successfully"),HttpStatus.OK);
	}

}
