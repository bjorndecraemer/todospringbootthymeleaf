package com.bjornspetprojects.todoapp.services.jpa;

import com.bjornspetprojects.todoapp.model.Todo;
import com.bjornspetprojects.todoapp.repositories.TodoRepository;
import com.bjornspetprojects.todoapp.services.TodoService;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class TodoServiceJpaImpl implements TodoService {

    private final TodoRepository todoRepository;

    public TodoServiceJpaImpl(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }



    @Override
    public List<Todo> findAllLikeTitle(String part) {

        return findAll()
                .stream()
                .filter( todo -> todo.getTitle().matches(".*"+part+".*"))
                .collect(Collectors.toList());
    }

    @Override
    public Todo findById(Long id) {
        return todoRepository.findById(id).orElse(null);
    }

    @Override
    public Set<Todo> findAll() {
        Set<Todo> results = new HashSet<>();
        todoRepository.findAll().forEach(results::add);
        return results;
    }

    @Override
    public Todo save(Todo todo) {
        return todoRepository.save(todo);
    }

    @Override
    public void delete(Todo todo) {
        todoRepository.delete(todo);
    }

    @Override
    public void deleteById(Long id) {
        todoRepository.deleteById(id);
    }
}
