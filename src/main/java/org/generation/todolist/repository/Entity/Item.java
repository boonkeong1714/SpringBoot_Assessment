package org.generation.todolist.repository.Entity;

import org.generation.todolist.controller.dto.ItemDTO;

import java.time.LocalDate;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Item {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    private Integer id;
    private String title;
    private String description;
    private LocalDate targetDate;

    public Item() {}

    public Item( ItemDTO itemDto ) {
        this.title = itemDto.getTitle();
        this.description = itemDto.getDescription();
        this.targetDate = itemDto.getTargetDate();
    }

    public Integer getId() { return id; }
    public void setId( Integer id ) { this.id = id; }

    public String getTitle() { return title; }
    public void setTitle( String title ) { this.title = title; }

    public String getDescription() { return description; }
    public void setDescription( String description ) { this.description = description; }

    public LocalDate getTargetDate() { return targetDate; }
    public void setTargetDate( LocalDate targetDate ) { this.targetDate = targetDate; }

    @Override
    public String toString() {
        return "Item{" + "id=" + id + ", title=" + title + '\'' + ", description='" + description + '\'' + ", target date='" + targetDate + "}";
    }
}
