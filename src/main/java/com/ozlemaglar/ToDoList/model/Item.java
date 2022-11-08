package com.ozlemaglar.ToDoList.item;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class ToDoItem {
    private Long id;
    private String todoName;
    private boolean isDone;
}
