package com.project.manager.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.project.manager.entity.Project;

@EnableJpaRepositories
public interface ProjectRepository extends JpaRepository<Project, Integer>{

}
