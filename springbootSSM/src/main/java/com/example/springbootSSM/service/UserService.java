package com.example.springbootSSM.service;

import com.example.springbootSSM.model.User;

public interface UserService {
    public User insert(User user);

    public User select(int id);

    public int delete(User user);

    public User update(User user);

}
