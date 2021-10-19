package com.example.demo.projects;

import com.example.demo.users.User;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;


@Service
public class ProjectService {
    @Autowired
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
