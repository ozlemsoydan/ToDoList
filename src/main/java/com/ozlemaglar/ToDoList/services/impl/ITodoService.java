package com.ozlemaglar.ToDoList.services.impl;

import com.ozlemaglar.ToDoList.model.Item;

import java.util.List;
import java.util.Map;

public interface ITodoService {

    public String getIndex();

    //add
    public Item createTodo(Item item);

    //find
    public Item getItemById(Long id);

    //list
    public List<Item> getAllTodo();

    //update
    public Item updateTodo(Item item);

    //delete
    public Map<String, Boolean> deleteTodo(Long id);
}
