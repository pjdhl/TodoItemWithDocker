package com.example.todoList.Controller;

import com.example.todoList.dao.TodoListRepository;
import org.mockito.Mockito;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class TodoListControllerTestConfiguration {
    @Bean
    @Primary
    public TodoListRepository getTestRepository(){
        return Mockito.mock(TodoListRepository.class);
    }
}
