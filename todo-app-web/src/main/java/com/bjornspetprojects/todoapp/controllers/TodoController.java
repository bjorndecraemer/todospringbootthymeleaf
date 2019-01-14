package com.bjornspetprojects.todoapp.controllers;

import com.bjornspetprojects.todoapp.model.Todo;
import com.bjornspetprojects.todoapp.services.TodoService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDateTime;

@RequestMapping("todos")
@Controller
public class TodoController {

    private static final String VIEWS_TODO_CREATE_OR_UPDATE_FORM = "createOrUpdateOwnerForm";

    private final TodoService todoService;

    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    @GetMapping
    public String getAllTodos(Model model){
        model.addAttribute("todos",todoService.findAll());
        return "todolist";
    }

    @PutMapping("/toggle/{todoId}")
    public String updateTodo(@PathVariable Long todoId, Model model){
        Todo todo = todoService.findById(todoId);
        if(todo.getDone()){
            todo.setFinishedDate(null);
        }
        else{
            todo.setFinishedDate(LocalDateTime.now());
        }
        todo.setDone(!todo.getDone());
        todoService.save(todo);
        model.addAttribute("todos",todoService.findAll());
        return "redirect:/todos";
    }

    @PostMapping("/delete/{todoId}")
    public String deleteTodo(@PathVariable Long todoId, Model model){
        todoService.deleteById(todoId);
        return "redirect:/todos";
    }

    @GetMapping("/new")
    public String initCreateForm(Model model){
        model.addAttribute("todo", Todo.builder().build());
        return VIEWS_TODO_CREATE_OR_UPDATE_FORM;
    }

    @PostMapping("/new")
    public String processCreationForm(@Valid Todo todo, BindingResult result){
        if(result.hasErrors()){
            return VIEWS_TODO_CREATE_OR_UPDATE_FORM;
        }
        else{
            todo.setCreatedOn(LocalDateTime.now());
            todoService.save(todo);
            return "redirect:/todos";
        }
    }

    @GetMapping("{todoId}/edit")
    public String initUpdateForm(@PathVariable Long todoId, Model model){
        model.addAttribute("todo", todoService.findById(todoId));
        return VIEWS_TODO_CREATE_OR_UPDATE_FORM;
    }

    @PostMapping("{todoId}/edit")
    public String processUpdateOwnerForm(@Valid Todo todo, BindingResult result, @PathVariable Long todoId){
        if(result.hasErrors()){
            return VIEWS_TODO_CREATE_OR_UPDATE_FORM;
        }
        else{
            Todo existingTodo = todoService.findById(todoId);
            existingTodo.setTitle(todo.getTitle());
            existingTodo.setDescription(todo.getDescription());
            todoService.save(existingTodo);
            return "redirect:/todos";
        }
    }
}
