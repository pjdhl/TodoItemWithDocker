package com.example.todoList.Controller;


import com.example.todoList.Service.TodoListService;
import com.example.todoList.domain.Status;
import com.example.todoList.domain.TodoList;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class TodoControllerTest{

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private TodoController todoController;

    @Autowired
    private ObjectMapper objectMapper;

    private  TodoListService mockTodoListService;
    @Before
    public void setUp() throws Exception {
        mockTodoListService = mock(TodoListService.class);
        todoController.todoListService = mockTodoListService;
    }

    @Test
    public void should_return_all_list() throws Exception {

        TodoList list = new TodoList("todo", Status.pending);
        ArrayList<TodoList> todoLists = new ArrayList<>();
        todoLists.add(list);

        when(mockTodoListService.getAll()).thenReturn(todoLists);

        mockMvc.perform(get("/api/list"))
                .andExpect(status().isOk());
    }

    @Test
    public void should_add_list_successful() throws Exception {
        TodoList list = new TodoList("first", Status.pending);
        when(mockTodoListService.create(list.getDescription())).thenReturn(true);

        mockMvc.perform(post("/api/list")
                .param("description", list.getDescription()))
                .andExpect(status().isOk());
    }

//    @Test
//    public void should_patch_successful() throws Exception {
//        TodoList list = new TodoList(1,"second", Status.pending);
//
//        String value = objectMapper.writeValueAsString(list);
//        when(mockTodoListService.update(list)).thenReturn(true);
//        mockMvc.perform(patch("/api/one")
//               .content(value))
//                .andExpect(status().isOk());
//    }

    @Test
    public void should_delete_success() throws Exception {

        TodoList list = new TodoList(1,"second", Status.pending);

        when(mockTodoListService.deleteList(list.getId())).thenReturn(true);

        String s = objectMapper.writeValueAsString(list);
        mockMvc.perform(delete("/api/one")
                .param("id", list.getId().toString()))
                .andExpect(status().isOk());
    }


}
