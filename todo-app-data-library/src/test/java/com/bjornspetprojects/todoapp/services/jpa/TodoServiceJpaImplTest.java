package com.bjornspetprojects.todoapp.services.jpa;

import com.bjornspetprojects.todoapp.model.Todo;
import com.bjornspetprojects.todoapp.repositories.TodoRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class TodoServiceJpaImplTest {

    @Mock
    TodoRepository todoRepository;
    @InjectMocks
    TodoServiceJpaImpl todoService;

    private List<Todo> defaultReturnList;
    private final Long SHOPPING_ID_1 = 1L;
    private Todo SHOPPING_TODO;
    private final Long WALK_ID_2 = 2L;
    private Todo WALK_TODO;
    private String LIKE_TITLE_WALK = "hihi";
    private String LIKE_TITLE_2_RESULTS = "al";
    private String LIKE_TITLE_NO_RESULTS = "xyz";

    @BeforeEach
    void setUp(){
        SHOPPING_TODO = Todo.builder().id(SHOPPING_ID_1).title("Go shopping in Mall").createdOn(LocalDateTime.now()).done(false).build();
        WALK_TODO = Todo.builder().id(WALK_ID_2).title("Walk Chihiro").createdOn(LocalDateTime.now()).done(false).build();
        defaultReturnList = new ArrayList<>();
        defaultReturnList.add(SHOPPING_TODO);
        defaultReturnList.add(WALK_TODO);
    }

    @Test
    void findAll() {
        when(todoRepository.findAll()).thenReturn(defaultReturnList);
        List<Todo> allFound = todoService.findAll();
        assertNotNull(allFound);
        assertEquals(2,allFound.size());
    }

    @Test
    void findById_Existing() {
        when(todoRepository.findById(anyLong())).thenReturn(Optional.of(WALK_TODO));
        Todo foundTodo = todoService.findById(WALK_ID_2);
        assertNotNull(foundTodo);
        assertEquals(WALK_ID_2, foundTodo.getId());
        assertEquals(WALK_TODO.getTitle(),foundTodo.getTitle());
    }

    @Test
    void findById_Not_Existing() {
        when(todoRepository.findById(anyLong())).thenReturn(Optional.empty());
        Todo foundTodo = todoService.findById(WALK_ID_2);
        assertNull(foundTodo);
    }

    @Test
    void save() {
       Todo toSaveTodo = Todo.builder().id(WALK_ID_2).build();
       when(todoRepository.save(any())).thenReturn(WALK_TODO);
       Todo savedTodo = todoService.save(toSaveTodo);
       assertNotNull(savedTodo);
    }

    @Test
    void delete() {
        todoService.delete(WALK_TODO);
        verify(todoRepository,times(1)).delete(any());
    }

    @Test
    void deleteById() {
        todoService.deleteById(WALK_ID_2);
        verify(todoRepository,times(1)).deleteById(anyLong());
    }

    @Test
    void findAllLikeTitle_1_Result() {
        when(todoRepository.findAll()).thenReturn(defaultReturnList);
        List<Todo> results = todoService.findAllLikeTitle(LIKE_TITLE_WALK);
        assertNotNull(results);
        assertEquals(1,results.size());
        assertEquals(WALK_ID_2,results.get(0).getId());
    }
    @Test
    void findAllLikeTitle_2_Results() {
        when(todoRepository.findAll()).thenReturn(defaultReturnList);
        List<Todo> results = todoService.findAllLikeTitle(LIKE_TITLE_2_RESULTS);
        assertNotNull(results);
        assertEquals(2,results.size());
    }
    @Test
    void findAllLikeTitle_No_Results() {
        when(todoRepository.findAll()).thenReturn(defaultReturnList);
        List<Todo> results = todoService.findAllLikeTitle(LIKE_TITLE_NO_RESULTS);
        assertNotNull(results);
        assertEquals(0,results.size());
    }
}