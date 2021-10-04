package com.example.demo.projects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/projects")
public class ProjectController {

    @Autowired
    private ProjectService projectService;

    //HR METHODS
    //To view all employees records
    @GetMapping("/getAll")
    public List<Project> getAllProjects(){
        List<Project> toReturn=projectService.getAllProjects();
        if(toReturn.size()==0){
            throw new ProjectNotFoundException();
//            System.out.println("HERE");
        }
        return toReturn;
    }

    //To add new user
    @PostMapping("/hr/create/{newUser}")
    public void createProject(@RequestBody Project project){
        projectService.addNewProject(project);
    }

    //EMPLOYEE METHODS
    @GetMapping("/get/{Id}")
    public Project getProjectById(@PathVariable String projectId){
        Project project=projectService.getProjectById(projectId);

        if(project==null){
            // throw an exception
            throw new ProjectNotFoundException(projectId);
        }
        return project;
    }


    @DeleteMapping("/del/{email}")
    void deleteUser(@PathVariable String projectId ){
        Project project= projectService.getProjectById(projectId);
        if(project==null){
            // throw an exception
            throw new ProjectNotFoundException();
        }
        projectService.delete(project);
    }



}
