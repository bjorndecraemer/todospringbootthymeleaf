package com.bjornspetprojects.todoapp.services.jpa;

import com.bjornspetprojects.todoapp.model.Todo;
import com.bjornspetprojects.todoapp.repositories.TodoRepository;
import com.bjornspetprojects.todoapp.services.TodoService;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
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
    public List<Todo> findAll() {
        return todoRepository.findAll(sortByCreatedOnDesc());
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

    @Override
    public Sort sortByCreatedOnDesc() {
        return new Sort(Sort.Direction.DESC, "createdOn")
                .and(new Sort(Sort.Direction.ASC, "title")
                .and(new Sort(Sort.Direction.DESC, "id"))
                );
    }
}
