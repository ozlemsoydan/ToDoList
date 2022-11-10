package com.ozlemaglar.ToDoList.rest;

import com.ozlemaglar.ToDoList.impl.ITodoService;
import com.ozlemaglar.ToDoList.model.Item;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/todolist")
@CrossOrigin("http://localhost:3000")
public class TodoController {

    private ITodoService todoService;

    @PostMapping("/add/todolist")
    public ResponseEntity createTodo(@RequestBody Item item) {
        todoService.createTodo(item);
        return new ResponseEntity(HttpStatus.CREATED);
    }

    @GetMapping("/list/todolist")
    public ResponseEntity<List<Item>> getAllTodo() {
        List<Item> list = todoService.getAllTodo();
        return ResponseEntity.ok(list);
    }

    @GetMapping("/find/todolist/{id}")
    public ResponseEntity<Item> getItemById(@PathVariable(name = "id") Long id) {
        return ResponseEntity.ok(todoService.getItemById(id));
    }

    @PutMapping("/update/todolist/{id}")
    public ResponseEntity<Item> updateTodo(@PathVariable(name = "id") Long id, @RequestBody Item item) {
        todoService.updateTodo(id,item);
        return ResponseEntity.ok(item);
    }

    @DeleteMapping("/delete/todolist/{id}")
    public ResponseEntity deleteTodo(@PathVariable(name = "id") Long id) {
        todoService.deleteTodo(id);
        return new ResponseEntity(HttpStatus.ACCEPTED);
    }

}
