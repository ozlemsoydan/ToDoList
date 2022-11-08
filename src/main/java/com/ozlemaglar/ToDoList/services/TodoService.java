package com.ozlemaglar.ToDoList.services;

import com.ozlemaglar.ToDoList.impl.ITodoService;
import com.ozlemaglar.ToDoList.model.Item;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TodoService implements ITodoService {


    @Override
    public Item createTodo(Item item) {
        return null;
    }

    @Override
    public Item getItemById(Long id) {
        return null;
    }

    @Override
    public List<Item> getAllTodo() {
        return null;
    }

    @Override
    public Item updateTodo(Long id, Item item) {
        return null;
    }

    @Override
    public Item deleteTodo(Long id) {
        return null;
    }
}
