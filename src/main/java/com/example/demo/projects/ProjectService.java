package com.example.demo.projects;

import com.example.demo.users.User;

import java.util.List;

public class ProjectService {

    private ProjectRepository projectRepository;
    public List<Project> getAllProjects() {
        return projectRepository.findAll();
    }

    public void addNewProject(Project project) {
        projectRepository.save(project);
    }

    public Project getProjectById(String projectId) {
       return projectRepository.getById(projectId);
    }

    public void delete(Project project) {
        projectRepository.delete(project);
    }
}
