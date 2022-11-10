package com.ozlemaglar.ToDoList.rest.controller;

import com.ozlemaglar.ToDoList.services.impl.ITodoService;
import com.ozlemaglar.ToDoList.model.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/todolist")
@CrossOrigin("http://localhost:3000")
public class TodoController {

    @Autowired
    private ITodoService todoService;

    @PostMapping("/add")
    public ResponseEntity createTodo(@RequestBody Item item) {
        todoService.createTodo(item);
        return new ResponseEntity(HttpStatus.CREATED);
    }

    @GetMapping("/list")
    public ResponseEntity<List<Item>> getAllTodo() {
        List<Item> list = todoService.getAllTodo();
        return ResponseEntity.ok(list);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Item> getItemById(@PathVariable(name = "id") Long id) {
        return ResponseEntity.ok(todoService.getItemById(id));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Item> updateTodo(@PathVariable(name = "id") Long id, @RequestBody Item item) {
        todoService.updateTodo(id,item);
        return ResponseEntity.ok(item);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Map<String, Boolean>> deleteTodo(@PathVariable(name = "id") Long id) {
        todoService.deleteTodo(id);
        Map<String,Boolean> response=new HashMap<>();
        response.put("silindi", Boolean.TRUE);
        return ResponseEntity.ok(response);
    }

}