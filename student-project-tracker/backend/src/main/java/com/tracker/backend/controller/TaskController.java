package com.tracker.backend.controller;

import com.tracker.backend.model.Project;
import com.tracker.backend.model.Task;
import com.tracker.backend.repository.ProjectRepository;
import com.tracker.backend.repository.TaskRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tasks")
@CrossOrigin(origins = "*")
public class TaskController {

    private final TaskRepository taskRepository;
    private final ProjectRepository projectRepository;

    public TaskController(TaskRepository taskRepository, ProjectRepository projectRepository) {
        this.taskRepository = taskRepository;
        this.projectRepository = projectRepository;
    }

    
    @GetMapping
    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    
    @PostMapping
    public Task createTask(@RequestBody Task task, @RequestParam Long projectId) {
        Project project = projectRepository.findById(projectId).orElse(null);
        if (project != null) {
            task.setProject(project);
            return taskRepository.save(task);
        }
        return null;
    }

    
    @GetMapping("/{id}")
    public Task getTaskById(@PathVariable Long id) {
        return taskRepository.findById(id).orElse(null);
    }

    
    @PutMapping("/{id}")
    public Task updateTask(@PathVariable Long id, @RequestBody Task updatedTask) {
        return taskRepository.findById(id).map(task -> {
            task.setTitle(updatedTask.getTitle());
            task.setStatus(updatedTask.getStatus());
            task.setDueDate(updatedTask.getDueDate());
            return taskRepository.save(task);
        }).orElse(null);
    }

    
    @DeleteMapping("/{id}")
    public void deleteTask(@PathVariable Long id) {
        taskRepository.deleteById(id);
    }
}
