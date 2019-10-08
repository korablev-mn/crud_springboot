package ru.korablev.crud_springboot.dao;

import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.korablev.crud_springboot.model.Role;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class RoleRepositoryImpl implements RoleRepository {

    @Autowired
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Role findByRole(String role) {

        Query query = (Query) entityManager.createQuery("select u from Role u where u.role = :role");
        query.setParameter("role", role);
        Role roleUser = (Role) query.getSingleResult();
        return roleUser;
    }
}
