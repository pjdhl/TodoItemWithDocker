package com.example.todoList.dao;

import com.example.todoList.domain.TodoList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface TodoListRepository extends JpaRepository<TodoList, Integer> {

    @Override
    List<TodoList> findAllById(Iterable<Integer> integers);
}
