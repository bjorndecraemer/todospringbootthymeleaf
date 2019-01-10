package com.bjornspetprojects.todoapp.repositories;

import com.bjornspetprojects.todoapp.model.Todo;
import org.springframework.data.repository.CrudRepository;

public interface TodoRepository extends CrudRepository<Todo,Long> {
}
