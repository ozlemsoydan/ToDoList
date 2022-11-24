package com.ozlemaglar.ToDoList.repo;

import com.ozlemaglar.ToDoList.model.Item;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ITodoRepo extends CrudRepository<Item, Long> {

    @Query(value = "SELECT i FROM Item i order by i.createDate desc")
    List<Item> findAllByCreatedDateBefore();

    @Query(value = "SELECT i FROM Item i order by i.updateDate desc")
    List<Item> findAllByUpdateDateBefore();

    @Query(value = "SELECT i FROM Item i order by i.isDone ")
    List<Item> findAllByDoneIsAfter();

    @Query(value = "SELECT i FROM Item i order by i.isDone desc ")
    List<Item> findAllByDoneIsBefore();


}
