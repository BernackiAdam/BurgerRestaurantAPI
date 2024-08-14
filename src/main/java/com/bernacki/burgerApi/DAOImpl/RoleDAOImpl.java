package com.bernacki.burgerApi.DAOImpl;

import com.bernacki.burgerApi.DAO.RoleDAO;
import com.bernacki.burgerApi.Entity.Role;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class RoleDAOImpl implements RoleDAO {

    private EntityManager entityManager;

    @Autowired
    public RoleDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public Role findRoleByRoleName(String roleName) {
        TypedQuery<Role> query = entityManager.createQuery(
                "FROM Role WHERE userName=:rName", Role.class
        );
        query.setParameter("rName", roleName);
        Role role = null;
        try{
            role = query.getSingleResult();
        } catch (Exception e){
            role = null;
        }
        return role;
    }
}
