package com.example.todoList.Service;

import com.example.todoList.dao.TodoListRepository;
import org.mockito.Mockito;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class TodoListServiceTestConfiguration {
    @Bean
    @Primary
    public TodoListRepository getTestRepository(){
        return Mockito.mock(TodoListRepository.class);
    }
}
