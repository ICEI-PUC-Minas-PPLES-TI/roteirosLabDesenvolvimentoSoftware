package com.example.service;

import com.example.model.Task;
import com.example.model.TaskStatus;
import com.example.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {

    @Autowired
    private TaskRepository taskRepository;

    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    public Task getTaskById(Long id) {
        return taskRepository.findById(id).orElse(null);
    }

    public Task createTask(Task task) {
        return taskRepository.save(task);
    }

    public Task updateTask(Long id, Task task) {
        task.setId(id);
        return taskRepository.save(task);
    }

    public void deleteTask(Long id) {
        taskRepository.deleteById(id);
    }

    public Task updateIsCompletedStatus(Long id) {
        Task task = taskRepository.findById(id).orElse(null);
        if (task != null) {
            // Atualiza o status da tarefa para concluído
            task.setStatus(TaskStatus.COMPLETED);
            return taskRepository.save(task);
        }
        return null;
    }
}