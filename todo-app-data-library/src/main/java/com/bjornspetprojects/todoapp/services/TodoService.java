package com.bjornspetprojects.todoapp.services;

import com.bjornspetprojects.todoapp.model.Todo;
import org.springframework.data.domain.Sort;

import java.util.List;

public interface TodoService extends CrudService<Todo,Long>{
    List<Todo> findAllLikeTitle(String part);

    public Sort sortByCreatedOnDesc();
}
