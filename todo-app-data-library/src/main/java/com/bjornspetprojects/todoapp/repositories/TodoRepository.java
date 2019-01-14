package com.bjornspetprojects.todoapp.repositories;

import com.bjornspetprojects.todoapp.model.Todo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TodoRepository extends JpaRepository<Todo,Long> {
}
