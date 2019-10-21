package com.example.todoList.Service;

import com.example.todoList.dao.TodoListRepository;
import com.example.todoList.domain.Status;
import com.example.todoList.domain.TodoList;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TodoListServiceTest{

    @Autowired
    private TodoListRepository todoListRepository;

    @Autowired
    private TodoListService todoListService;

    @Autowired
    private ObjectMapper objectMapper;

    private  TodoListRepository mockTodoListRepository;

    @Before
    public void setUp() throws Exception {
        mockTodoListRepository = mock(TodoListRepository.class);
        todoListService.todoListRepository = mockTodoListRepository;
    }

    @Test
    public void should_return_all_when_get() {

        TodoList list1 = new TodoList("first");
        ArrayList<TodoList> todoLists = new ArrayList<>();
        todoLists.add(list1);

        when(mockTodoListRepository.findAll()).thenReturn(todoLists);

        List<TodoList> list = todoListService.getAll();

        assertEquals("first", list.get(0).getDescription());
    }

    @Test
    public void should_return_one_by_Id(){

        TodoList listOne = new TodoList(1,"first", Status.pending);
        when(mockTodoListRepository.findById(listOne.getId())).thenReturn(Optional.of(listOne));

        Optional<TodoList> list = todoListService.getById(listOne.getId());

        assertEquals("first", list.get().getDescription());
    }
}
