package com.example.app;

import com.example.model.Task;
import com.example.model.TaskPriority;
import com.example.model.TaskStatus;
import com.example.model.TaskType;
import com.example.service.TaskService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import java.time.LocalDate;

@SpringBootApplication
public class Main {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(Main.class, args);

        // Testando a funcionalidade de criação de tarefa
        TaskService taskService = context.getBean(TaskService.class);
        Task task = new Task();
        task.setDescription("Tarefa de teste");
        task.setType(TaskType.DATE);
        task.setPriority(TaskPriority.HIGH);
        task.setStatus(TaskStatus.PENDING);
        task.setDueDate(LocalDate.now().plusDays(7)); // Data prevista de conclusão
        taskService.createTask(task);
    }
}