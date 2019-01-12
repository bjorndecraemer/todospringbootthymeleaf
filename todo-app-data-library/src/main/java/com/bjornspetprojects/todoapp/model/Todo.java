package com.bjornspetprojects.todoapp.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.lang.Nullable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "todos")
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

    @Column(name = "title")
    private String title;
    @Column(name = "description")
    private String description;
    @Column(name = "created_on")
    private LocalDateTime createdOn;
    @Column(name = "completed")
    private Boolean done = false;
    @Column(name = "completed_date")
    @Nullable
    private LocalDateTime finishedDate;
    public String getCreatedOnFriendlyFormat(){
        return createdOn.format(DateTimeFormatter.ofPattern("d MMM uuuu "));
    }
}
