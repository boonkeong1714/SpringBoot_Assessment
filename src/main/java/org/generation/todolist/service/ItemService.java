package org.generation.todolist.service;

import org.generation.todolist.repository.Entity.Item;
import java.util.List;

public interface ItemService {
    Item save( Item item );
    Item findById( int itemId );
    List<Item> all();
    void delete( int itemId );
}
