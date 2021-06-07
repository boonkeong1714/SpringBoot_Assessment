package org.generation.todolist.service;

//class
import org.generation.todolist.repository.ItemRepository;
import org.generation.todolist.repository.Entity.Item;

//annotation
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class ItemServiceMySQL implements ItemService {

    private final ItemRepository itemRepository;

    public ItemServiceMySQL( @Autowired ItemRepository itemRepository ) {
        this.itemRepository = itemRepository;
    }

    //Create
    @Override
    public Item save( Item item ) {
        return itemRepository.save(item);
    }

    //Read
    @Override
    public Item findById( int itemId ) {
        Optional<Item> item = itemRepository.findById( itemId );
        Item itemResponse = item.get();
        return itemResponse;
    }

    @Override
    public List<Item> all() {
        List<Item> result = new ArrayList<>();
        itemRepository.findAll().forEach( result::add );
        return result;
    }

    //Delete
    @Override
    public void delete( int itemId ) {
        itemRepository.deleteById( itemId );
    }

}
