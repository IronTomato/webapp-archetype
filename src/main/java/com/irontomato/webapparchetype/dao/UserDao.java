package com.irontomato.webapparchetype.dao;

import com.irontomato.webapparchetype.entity.User;

public interface UserDao {
    void addUser(User user);

    User getUser(long id);

    void saveUser(User user);
}
