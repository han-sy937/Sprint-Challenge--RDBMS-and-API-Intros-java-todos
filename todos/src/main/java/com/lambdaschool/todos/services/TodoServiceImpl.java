package com.lambdaschool.todos.services;

import com.lambdaschool.todos.models.Todos;
import com.lambdaschool.todos.models.User;
import com.lambdaschool.todos.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service(value = "todoService")
public class TodoServiceImpl implements TodosService{

    @Autowired
    TodoRepository todorepos;

    @Autowired
    UserService  userService;

    @Transactional
    @Override
    public void markComplete(long todoid) {
        todorepos.findById(todoid).get().setCompleted(true);
    }

    @Transactional

    @Override
    public Todos save(Todos todos) {
        return todorepos.save(todos);
    }
}

