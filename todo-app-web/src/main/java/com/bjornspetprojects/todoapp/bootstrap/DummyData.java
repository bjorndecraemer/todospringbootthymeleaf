package com.bjornspetprojects.todoapp.bootstrap;

import com.bjornspetprojects.todoapp.model.Todo;
import com.bjornspetprojects.todoapp.services.TodoService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class DummyData implements CommandLineRunner {

    private final TodoService todoService;

    public DummyData(TodoService todoService) {
        this.todoService = todoService;
    }

    @Override
    public void run(String... args) {
        todoService.save(
                Todo.builder()
                        .title("Walk Chihiro")
                        .description("I need to walk Chihiro more!")
                        .createdOn(LocalDateTime.now())
                        .done(false)
                        .build());
        todoService.save(
                Todo.builder()
                        .title("Go shopping in Mall")
                        .description("I need to go to the Shopping Mall, my cupboards are empty!")
                        .createdOn(LocalDateTime.now())
                        .done(false)
                        .build());
        todoService.save(
                Todo.builder()
                        .title("Clean Room")
                        .description("My room is a mess")
                        .createdOn(LocalDateTime.of(2018,12,25,10,30))
                        .done(true)
                        .finishedDate((LocalDateTime.of(2019,1,4,11,24)))
                        .build());
        todoService.save(
                Todo.builder()
                        .title("Clean Room Again")
                        .description("My room is a mess again")
                        .createdOn(LocalDateTime.of(2018,12,25,10,30))
                        .done(false)
                        .build());
        todoService.save(
                Todo.builder()
                        .title("Walk Chihiro once more")
                        .description("I need to walk Chihiro even more!")
                        .createdOn(LocalDateTime.now())
                        .done(false)
                        .build());
        todoService.save(
                Todo.builder()
                        .title("Clean Room Again")
                        .description("My room is a mess again")
                        .createdOn(LocalDateTime.of(2018,12,25,10,30))
                        .done(false)
                        .build());
        todoService.save(
                Todo.builder()
                        .title("Walk Chihiro once more")
                        .description("I need to walk Chihiro even more!")
                        .createdOn(LocalDateTime.now())
                        .done(false)
                        .build());
        todoService.save(
                Todo.builder()
                        .title("Clean Room Again")
                        .description("My room is a mess again")
                        .createdOn(LocalDateTime.of(2018,12,25,10,30))
                        .done(false)
                        .build());
        todoService.save(
                Todo.builder()
                        .title("Walk Chihiro once more")
                        .description("I need to walk Chihiro even more!")
                        .createdOn(LocalDateTime.now())
                        .done(false)
                        .build());
    }
}
