package com.bjornspetprojects.todoapp.repositories;

import com.bjornspetprojects.todoapp.model.Todo;
import org.springframework.data.jpa.repository.JpaRepository;

public abstract class TodoRepository implements JpaRepository<Todo,Long> {
}
