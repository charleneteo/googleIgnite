package com.example.demo.projects;


public class ProjectNotFoundException extends RuntimeException {
    public ProjectNotFoundException(){
        super();
    }
    public ProjectNotFoundException(String projectId){
        super(projectId+ " is not found");
    }
}
