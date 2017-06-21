package com.mustafa.samples.reservation.web.controller.dao;

import com.mustafa.samples.reservation.dao.TodoItemDao;
import com.mustafa.samples.reservation.domain.TodoItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

/**
 * Created by kamilbukum on 06/03/2017.
 */
@RestController
@RequestMapping(value = "dao-todo-items")
@Transactional
public class DTodoItemController {
    @Autowired
    private TodoItemDao todoItemDao;

    @RequestMapping(method = RequestMethod.POST)
    public TodoItem create(@RequestBody TodoItem todoItem) {
        return todoItemDao.create(todoItem);
    }


    @RequestMapping(method = RequestMethod.DELETE, value = "{oid}")
    public TodoItem delete(@PathVariable("oid") Long id) {
        return todoItemDao.delete(id);
    }
}
