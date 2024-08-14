package com.bernacki.burgerApi.DAO;

import com.bernacki.burgerApi.Entity.User;

public interface UserDAO {
    User findByUserName(String username);
}
