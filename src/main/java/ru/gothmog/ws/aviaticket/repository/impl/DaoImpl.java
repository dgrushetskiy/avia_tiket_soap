package ru.gothmog.ws.aviaticket.repository.impl;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import ru.gothmog.ws.aviaticket.repository.Dao;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

@Transactional
public class DaoImpl implements Dao{
    @Autowired
    private EntityManager entityManager;

    public Session getSession() {
        return entityManager.unwrap(Session.class);
    }
}
