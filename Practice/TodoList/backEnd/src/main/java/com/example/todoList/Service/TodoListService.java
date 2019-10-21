package com.example.todoList.Service;

import com.example.todoList.dao.TodoListRepository;
import com.example.todoList.domain.Status;
import com.example.todoList.domain.TodoList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class TodoListService {

    @Autowired
    TodoListRepository todoListRepository;

    public List<TodoList>  getAll() {
        return todoListRepository.findAll();
    }

    public boolean create(String description) {
        TodoList list = new TodoList(description, Status.pending);
        todoListRepository.save(list);
        return true;
    }

    public Optional<TodoList> getById(Integer id) {
        return todoListRepository.findById(id);
    }

    public boolean update(TodoList todoList) {
        if(todoList.getStatus() != Status.finish && todoList.getStatus() != Status.pending){
            return false;
        }
        TodoList one = todoListRepository.findById(todoList.getId()).get();
        if(one.equals(null)){
            return false;
        }else{
            todoListRepository.save(todoList);
            return true;
        }
    }

    public boolean deleteList(Integer id) {
        TodoList list = todoListRepository.findById(id).get();
        if (list.equals(null)) {
            return false;
        }else {
            todoListRepository.deleteById(list.getId());
            return true;
        }
    }
}
