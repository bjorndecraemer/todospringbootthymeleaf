package com.bjornspetprojects.todoapp.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Todo extends BaseEntity{

    @Builder
    public Todo(Long id, String title, String description, LocalDateTime createdOn, Boolean done, LocalDateTime finishedDate) {
        super(id);
        this.title = title;
        this.description = description;
        this.createdOn = createdOn;
        this.done = done;
        this.finishedDate = finishedDate;
    }

    private String title;
    private String description;
    private LocalDateTime createdOn;
    private Boolean done;
    private LocalDateTime finishedDate;
}
