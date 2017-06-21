package com.mustafa.samples.reservation.services;

import com.mebitech.robe.persistence.jpa.services.JpaService;
import com.mustafa.samples.reservation.domain.Todo;
import com.mustafa.samples.reservation.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by kamilbukum on 06/03/2017.
 */
@Service
public class TodoServices extends JpaService<Todo, Long> {

    @Autowired
    public TodoServices(TodoRepository repository) {
        super(repository);
    }
}
