package com.bjornspetprojects.todoapp.controllers;

import com.bjornspetprojects.todoapp.model.Todo;
import com.bjornspetprojects.todoapp.services.TodoService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.HashSet;
import java.util.Set;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(MockitoExtension.class)
class TodoControllerTest {

    @Mock
    TodoService todoService;

    @InjectMocks
    TodoController controller;

    private Set<Todo> todoSet;

    private MockMvc mockMvc;

    @BeforeEach
    void setUp() {
        todoSet = new HashSet<>();
        todoSet.add(Todo.builder().id(1L).build());
        todoSet.add(Todo.builder().id(2L).build());

        mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
    }

    @Test
    void getAllTodos() throws Exception{
        mockMvc.perform(get("/todos"))
                .andExpect(status().isOk())
                .andExpect(view().name("todolist"))
                .andExpect(model().attributeExists("todos"));
    }
}