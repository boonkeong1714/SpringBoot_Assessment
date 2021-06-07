package org.generation.todolist.controller.dto;

import java.time.LocalDate;

public class ItemDTO {
    private String title;
    private String description;
    private LocalDate targetDate;

    public ItemDTO(String title, String description, LocalDate targetDate) {
        this.title = title;
        this.description = description;
        this.targetDate = targetDate;
    }

    public String getTitle() { return title; }
    public void setTitle( String title ) { this.title = title; }

    public String getDescription() { return description; }
    public void setDescription( String description ) { this.description = description; }

    public LocalDate getTargetDate() { return targetDate; }
    public void setTargetDate( LocalDate targetDate ) { this.targetDate = targetDate; }

}
