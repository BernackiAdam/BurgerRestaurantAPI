package com.bernacki.burgerApi.DAO;

import com.bernacki.burgerApi.Entity.Role;

public interface RoleDAO {
    Role findRoleByRoleName(String name);
}
