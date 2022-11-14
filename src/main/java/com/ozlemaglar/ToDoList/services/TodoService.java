package com.ozlemaglar.ToDoList.services;

import com.ozlemaglar.ToDoList.exception.ResourceNotFoundException;
import com.ozlemaglar.ToDoList.repo.ITodoRepo;
import com.ozlemaglar.ToDoList.services.impl.ITodoService;
import com.ozlemaglar.ToDoList.model.Item;
import lombok.RequiredArgsConstructor;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.*;

@Service
@RequiredArgsConstructor
public class TodoService implements ITodoService {

    private final ITodoRepo repository;

    @Override
    public String getIndex() {
        return "index";
    }

    @Override
    public Item createTodo(Item item) {
        item.setCreatedDate(new Date());
        repository.save(item);
        return item;
    }

    @Override
    public Item getItemById(Long id) {
        Item item = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException(id + " id bulunamadı"));
        return item;
    }

    @Override
    public List<Item> getAllTodo() {
        return (List<Item>) repository.findAll();
    }

    @Override
    public Item updateTodo(Item item) {
        if (StringUtils.isNotEmpty(item.getId().toString())) {
            Optional<Item> item1 = repository.findById(item.getId());
            if(item1.isPresent()){
                item.setCreatedDate(item1.get().getCreatedDate());
                item.setUpdateDate(new Date());
                repository.save(item);

            }else {
                throw new ResourceNotFoundException("id bulunamadı");
            }
        } else {
            throw new ResourceNotFoundException("id boş olamaz");
        }
        return item;
    }

    @Override
    public Map<String, Boolean> deleteTodo(Long id) {
        Item item = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException(id + " id bulunamadı"));
        repository.delete(item);
        Map<String, Boolean> response = new HashMap<>();
        response.put("silindi", Boolean.TRUE);
        return response;
    }
}
