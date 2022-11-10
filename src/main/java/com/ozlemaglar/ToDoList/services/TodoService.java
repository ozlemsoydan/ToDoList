package com.ozlemaglar.ToDoList.services;

import com.ozlemaglar.ToDoList.exception.ResourceNotFoundException;
import com.ozlemaglar.ToDoList.repo.ITodoRepo;
import com.ozlemaglar.ToDoList.services.impl.ITodoService;
import com.ozlemaglar.ToDoList.model.Item;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class TodoService implements ITodoService {

    @Autowired
    private final ITodoRepo repository;

    @Override
    public Item createTodo(Item item) {
        repository.save(item);
        return item;
    }

    @Override
    public Item getItemById(Long id) {
        Item item=repository.findById(id).orElseThrow(()->new ResourceNotFoundException(id+" id bulunamadı"));
        return item;
    }

    @Override
    public List<Item> getAllTodo() {
        return null;
    }

    @Override
    public Item updateTodo(Long id, Item item) {
        if(item!=null){
            item.setDescription(item.getDescription());
            repository.save(item);
        }
        return item;
    }

    @Override
    public Map<String, Boolean> deleteTodo(Long id) {
        Item item=repository.findById(id).orElseThrow(()->new ResourceNotFoundException(id+" id bulunamadı"));
        repository.delete(item);
        Map<String, Boolean> response=new HashMap<>();
        response.put("silindi",Boolean.TRUE);
        return response;
    }
}
