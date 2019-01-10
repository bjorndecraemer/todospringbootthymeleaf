package com.bjornspetprojects.todoapp.services;

import com.bjornspetprojects.todoapp.model.Todo;

import java.util.List;

public interface TodoService extends CrudService<Todo,Long>{
    public List<Todo> findAllLikeTitle();
}
