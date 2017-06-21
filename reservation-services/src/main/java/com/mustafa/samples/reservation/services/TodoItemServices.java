package com.mustafa.samples.reservation.services;

import com.mebitech.robe.persistence.jpa.services.JpaService;
import com.mustafa.samples.reservation.domain.TodoItem;
import com.mustafa.samples.reservation.repository.TodoItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by kamilbukum on 06/03/2017.
 */
@Service
public class TodoItemServices extends JpaService<TodoItem, Long> {

    private TodoItemRepository repository;

    @Autowired
    public TodoItemServices(TodoItemRepository repository) {
        super(repository);
        this.repository = repository;
    }

    public List<TodoItem> findByParentOid(Long parentOid) {
        return repository.findByParent_id(parentOid);
    }
}
