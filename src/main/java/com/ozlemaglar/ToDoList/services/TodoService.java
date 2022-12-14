package com.ozlemaglar.ToDoList.services;

import com.ozlemaglar.ToDoList.exception.ResourceNotFoundException;
import com.ozlemaglar.ToDoList.model.Item;
import com.ozlemaglar.ToDoList.repo.ITodoRepo;
import com.ozlemaglar.ToDoList.enums.Sort;
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
        item.setCreateDate(new Date());
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
    public List<Item> getAllTodo(String sort) {
        //gelen parametreye göre ilgili repo methoduna git

        if (sort.equals(Sort.CREATE_DATE.toString())) {
            //Oluşturma tarihine göre sıralama
            //List<Item> orderList = (List<Item>) repository.findAll();
            //orderList.sort(Comparator.comparing(Item::getCreateDate).reversed());
            return repository.findAllByCreatedDateBefore();

        } else if (sort.equals(Sort.UPDATE_DATE.toString())) {
            return repository.findAllByUpdateDateBefore();

        } else if (sort.equals(Sort.DONE.toString())) {
            return repository.findAllByDoneIsBefore();

        } else if (sort.equals(Sort.NOT_DONE.toString())) {
            return repository.findAllByDoneIsAfter();

        } else {
            throw new ResourceNotFoundException("Hatalı sorgu");
        }


    }

    @Override
    public Item updateTodo(Item item) {
        if (StringUtils.isNotEmpty(item.getId().toString())) {
            Optional<Item> item1 = repository.findById(item.getId());
            if (item1.isPresent()) {
                item.setCreateDate(item1.get().getCreateDate());
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
