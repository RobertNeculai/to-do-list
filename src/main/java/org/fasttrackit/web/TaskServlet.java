package org.fasttrackit.web;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.fasttrackit.config.ObjectMapperConfiguration;
import org.fasttrackit.service.TaskService;
import org.fasttrackit.transfer.CreateTaskRequest;
import org.fasttrackit.transfer.UpdateTaskRequest;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/tasks")
public class TaskServlet extends HttpServlet {
    private TaskService taskService=new TaskService();
    //EndPoint
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        CreateTaskRequest request= ObjectMapperConfiguration.objectMapper.readValue(req.getReader(),CreateTaskRequest.class);

        try {
            taskService.createTask(request);
        } catch (SQLException | ClassNotFoundException e) {
            resp.sendError(500,"Internal server error: "+e.getMessage());
        }
    }
    // Endpoint Delete
    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id=req.getParameter("id");
        try {
            taskService.deleteTask(Long.parseLong(id));
        } catch (SQLException | ClassNotFoundException e) {
            resp.sendError(500,"Internal server error: "+e.getMessage());
        }
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        UpdateTaskRequest request= ObjectMapperConfiguration.objectMapper.readValue(req.getReader(),UpdateTaskRequest.class);
        try {
            taskService.UpdateTask(Long.parseLong(id),request);
        } catch (SQLException | ClassNotFoundException e) {
            resp.sendError(500, "Internal server error: " + e.getMessage());
        }
    }
//Endpoint Update
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //List<Task> task= taskService.getTasks();
        // String response=ObjectMapperConfiguration.ObjectMapper.writeValueAsString(task);
        // response.getWriter().print(response);
        try {
            ObjectMapperConfiguration.objectMapper.writeValue(resp.getWriter(),taskService.getTasks());
        } catch (SQLException | ClassNotFoundException e) {
            resp.sendError(500, "Internal server error: " + e.getMessage());
        }
    }
}
