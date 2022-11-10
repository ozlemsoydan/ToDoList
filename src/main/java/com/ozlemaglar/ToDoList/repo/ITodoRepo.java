package com.ozlemaglar.ToDoList.repo;

import com.ozlemaglar.ToDoList.model.Item;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;

@Repository
public interface ITodoRepo extends CrudRepository<Item, Long> {

    @Query(value = "SELECT u FROM Item u order by u.createdDate desc")
    List<Item> findAllByOrderByDateDesc();
}
