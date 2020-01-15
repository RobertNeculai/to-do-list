package org.fasttrackit;

import org.fasttrackit.persistance.TaskRepository;
import org.fasttrackit.transfer.CreateTaskRequest;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws IOException, SQLException {
        CreateTaskRequest request=new CreateTaskRequest();
        request.setDescription("learn JDBC");
        request.setDeadline(LocalDate.now().plusWeeks(1));
        TaskRepository taskRepository=new TaskRepository();
        taskRepository.createTask(request);
    }
}