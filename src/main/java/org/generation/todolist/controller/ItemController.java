package org.generation.todolist.controller;

import org.generation.todolist.repository.Entity.Item;
import org.generation.todolist.service.ItemService;
import org.generation.todolist.controller.dto.ItemDTO;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

//CRUD
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;     //submit new data to DB
import org.springframework.web.bind.annotation.PathVariable;    //existing data in DB

//class
//import org.generation.MyWebProject.repository.ItemRepository;

@RestController
@RequestMapping("/item")
public class ItemController {
    //improper way: direct accessing ItemRepository skipping service layers
    /*final ItemRepository itemRepository;

    public ItemController( @Autowired ItemRepository itemRepository ) {
        this.itemRepository = itemRepository;
    }

    @GetMapping
    public Iterable<Item> getItems() {
        return itemRepository.findAll();
    } */

    //proper way: accessing itemRepository via service layer
    final ItemService itemService;

    public ItemController( @Autowired ItemService itemService ) {
        this.itemService = itemService;
    }

    @CrossOrigin
    @GetMapping("/all")
    public Iterable<Item> getItems() {
        return itemService.all();
    }

    //To avoid CORS (Cross-Origin Resource Sharing)
    @CrossOrigin
    @PostMapping("/add")
//    @PostMapping(value="/add", consumes = MediaType.APPLICATION_JSON_VALUE)
    //application/x-www-form-urlencoded
    //multipart/form-data
//    @RequestMapping(value = "/admin/login", method = RequestMethod.POST, consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE, headers = "Accept=application/json")
    public Item save( @RequestBody ItemDTO itemDto ) {
        System.out.println("In Save");
        return itemService.save( new Item(itemDto));
    }

    @GetMapping("/{id}")
    public Item findItemById( @PathVariable Integer id) {
        return itemService.findById(id);
    }

    @CrossOrigin
    @PutMapping("/{id}")
    public Item update(@PathVariable Integer id, @RequestBody ItemDTO itemDto) {
//        System.out.println("Hello");
        Item item = itemService.findById(id);
        item.setTitle(itemDto.getTitle());
        item.setDescription(itemDto.getDescription());
        item.setTargetDate(itemDto.getTargetDate());
        return itemService.save(item);
    }

    @CrossOrigin
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        itemService.delete(id);
    }
}
