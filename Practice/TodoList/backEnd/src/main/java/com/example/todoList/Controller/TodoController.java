package com.example.todoList.Controller;

import com.example.todoList.Service.TodoListService;
import com.example.todoList.domain.TodoList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api")
public class TodoController {

    @Autowired
    TodoListService todoListService;

    @GetMapping("/list")
    public ResponseEntity getList(){
        List<TodoList> all = todoListService.getAll();
        if (all.isEmpty()) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(all);
        }
    }

    @PostMapping("/list")
    public ResponseEntity addList(@RequestParam("description") String description){
        if(todoListService.create(description)){
            return ResponseEntity.ok().build();
        }else{
            return ResponseEntity.badRequest().build();
        }
    }

    @PatchMapping("/one")
    public ResponseEntity updateList(@RequestBody TodoList todoList){
        if(todoListService.update(todoList)){
            return ResponseEntity.ok(todoList);
        }else{
            return ResponseEntity.badRequest().build();
        }
    }

    @DeleteMapping("/one")
    public ResponseEntity deleteList(@RequestParam Integer id){
        if (todoListService.deleteList(id)) {
            return ResponseEntity.ok().build();
        }else{
            return ResponseEntity.badRequest().build();
        }
    }

}
