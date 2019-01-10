package com.bjornspetprojects.todoapp.controllers;

import com.bjornspetprojects.todoapp.services.TodoService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("todos")
@Controller
public class TodoController {

    private final TodoService todoService;

    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    @GetMapping
    public String getAllTodos(Model model){
        model.addAttribute("todos",todoService.findAll());
        return "todolist";
    }

}
