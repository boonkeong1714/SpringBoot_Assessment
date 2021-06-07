package org.generation.todolist.repository;

import org.generation.todolist.repository.Entity.Item;
import org.springframework.data.repository.CrudRepository;

// this will be AUTO IMPLEMENTED by spring into a bean called itemRepository
// CRUD refers Create, Read, Update, Delete
public interface ItemRepository extends CrudRepository<Item, Integer> { }
