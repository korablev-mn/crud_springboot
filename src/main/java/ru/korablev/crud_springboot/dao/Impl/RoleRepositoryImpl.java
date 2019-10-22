package ru.korablev.crud_springboot.dao.Impl;

import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.korablev.crud_springboot.dao.RoleRepository;
import ru.korablev.crud_springboot.model.Role;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.Set;

@Repository
public class RoleRepositoryImpl  implements RoleRepository {

    @Autowired
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    @Transactional(readOnly = true)
    public Role findByRole(String role) {

        Query query = (Query) entityManager.createQuery("select u from Role u where u.role = :role");
        query.setParameter("role", role);
        Role roleUser = (Role) query.getSingleResult();
        return roleUser;
    }

    @Override
    @Transactional(readOnly = true)
    public List<Role> findAll() {
        List<Role> roles;
        //noinspection JpaQlInspection
        Query query = (Query) entityManager.createQuery("select u from Role u");
        roles = query.getResultList();
        return roles;
    }

}
