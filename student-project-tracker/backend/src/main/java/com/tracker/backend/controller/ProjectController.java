package com.tracker.backend.controller;

import com.tracker.backend.model.Project;
import com.tracker.backend.model.User;
import com.tracker.backend.repository.ProjectRepository;
import com.tracker.backend.repository.UserRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/projects")
@CrossOrigin(origins = "*")
public class ProjectController {

    private final ProjectRepository projectRepository;
    private final UserRepository userRepository;

    public ProjectController(ProjectRepository projectRepository, UserRepository userRepository) {
        this.projectRepository = projectRepository;
        this.userRepository = userRepository;
    }

    
    @GetMapping
    public List<Project> getAllProjects() {
        return projectRepository.findAll();
    }

    
    @PostMapping
    public Project createProject(@RequestBody Project project, @RequestParam Long userId) {
        User user = userRepository.findById(userId).orElse(null);
        if (user != null) {
            project.setUser(user);
            return projectRepository.save(project);
        }
        return null;
    }

    
    @GetMapping("/{id}")
    public Project getProjectById(@PathVariable Long id) {
        return projectRepository.findById(id).orElse(null);
    }

    
    @DeleteMapping("/{id}")
    public void deleteProject(@PathVariable Long id) {
        projectRepository.deleteById(id);
    }
}
