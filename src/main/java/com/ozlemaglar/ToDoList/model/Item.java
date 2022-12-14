package com.ozlemaglar.ToDoList.model;

import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

@Entity
@Table(name="item")

public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    @NotNull(message = "task.validation.constraints.NotNull.message")
    private String description;

    @Column
    private boolean isDone;

    @Column(name = "create_date")
    @CreatedDate
    private Date createDate;

    @Column(name = "update_date")
    @LastModifiedDate
    private Date updateDate;
}
