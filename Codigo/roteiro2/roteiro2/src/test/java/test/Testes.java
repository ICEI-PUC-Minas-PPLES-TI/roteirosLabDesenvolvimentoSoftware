package test;

import com.example.model.Task;
import com.example.model.TaskPriority;
import com.example.model.TaskStatus;
import com.example.model.TaskType;
import com.example.repository.TaskRepository;
import com.example.service.TaskService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

class TaskServiceTest {

    @Mock
    private TaskRepository taskRepository;

    @InjectMocks
    private TaskService taskService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testGetAllTasks() {
        // Mocking tasks
        List<Task> mockTasks = new ArrayList<>();
        mockTasks.add(new Task(1L, "Task Data Alta", TaskType.DATE, TaskPriority.HIGH, TaskStatus.PENDING, LocalDate.now().plusDays(1), null));
        mockTasks.add(new Task(2L, "Task Prazo Média", TaskType.DEADLINE, TaskPriority.MEDIUM, TaskStatus.COMPLETED, LocalDate.now(), 3));
        mockTasks.add(new Task(3L, "Task Livre Baixa", TaskType.FREE, TaskPriority.LOW, TaskStatus.OVERDUE, null, null));

        Mockito.when(taskRepository.findAll()).thenReturn(mockTasks);

        // Calling the service method
        List<Task> fetchedTasks = taskService.getAllTasks();

        // Assertions
        Assertions.assertEquals(3, fetchedTasks.size());
        Assertions.assertEquals("Task Data Alta", fetchedTasks.get(0).getDescription());
        Assertions.assertEquals(TaskType.DEADLINE, fetchedTasks.get(1).getType());
        Assertions.assertEquals(TaskStatus.OVERDUE, fetchedTasks.get(2).getStatus());
    }
}