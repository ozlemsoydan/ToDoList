package com.ozlemaglar.ToDoList.services;

import com.ozlemaglar.ToDoList.exception.ResourceNotFoundException;
import com.ozlemaglar.ToDoList.model.Item;
import com.ozlemaglar.ToDoList.repo.ITodoRepo;
import com.ozlemaglar.ToDoList.services.impl.ITodoService;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@RequiredArgsConstructor
public class TodoService implements ITodoService {

    private final ITodoRepo repository;


    @Override
    public Item createTodo(Item item) {
        item.setCreatedDate(new Date());
        item.setDone(false);
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
//        //tarihe göre tesrten sırala
//        List<Item> orderList = (List<Item>) repository.findAll();
//        orderList.sort(Comparator.comparing(Item::getCreatedDate).reversed());

        return repository.findAllByOrderByUpdateDateDesc();
    }

    @Override
    public Item updateTodo(Item item) {
        if (StringUtils.isNotEmpty(item.getId().toString())) {
            Optional<Item> item1 = repository.findById(item.getId());
            if (item1.isPresent()) {
                item.setCreatedDate(item1.get().getCreatedDate());
                item.setUpdateDate(new Date());
                repository.save(item);

            } else {
                throw new ResourceNotFoundException("id bulunamadı");
            }
        } else {
            throw new ResourceNotFoundException("id boş olamaz");
        }
        return item;
    }

    @Override
    public Map<String, Boolean> deleteTodo(Long id) {
        if (id == -1) {
            repository.deleteAll();
        } else {
            Item item = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException(id + " id bulunamadı"));
            repository.delete(item);

        }
        Map<String, Boolean> response = new HashMap<>();
        response.put("silindi", Boolean.TRUE);
        return response;
    }
}
