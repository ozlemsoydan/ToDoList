package com.ozlemaglar.ToDoList.impl;

import com.ozlemaglar.ToDoList.model.Item;

import java.util.List;

public interface ITodoService {

    //add
    public Item createTodo(Item item);

    //find
    public Item getItemById(Long id);

    //list
    public List<Item> getAllTodo();

    //update
    public Item updateTodo(Long id,Item item);

    //delete
    public Item deleteTodo(Long id);
}
