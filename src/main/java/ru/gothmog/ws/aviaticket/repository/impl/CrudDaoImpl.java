package ru.gothmog.ws.aviaticket.repository.impl;

import ru.gothmog.ws.aviaticket.repository.CrudDao;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class CrudDaoImpl<T> extends DaoImpl implements CrudDao<T>{
    private final Class<T> entityClass;

    public CrudDaoImpl(Class<T> entityClass) {
        this.entityClass = entityClass;
    }

    @Override
    public T create(T entity) {
        getSession().save(entity);
        return entity;
    }

    @Override
    public T getById(long id) {
        return getSession().get(entityClass, id);
    }

    @Override
    public T delete(T entity) {
        getSession().delete(entity);
        return entity;
    }

    @Override
    public List<T> getAllList() {
        CriteriaBuilder builder = getSession().getCriteriaBuilder();
        CriteriaQuery<T> criteriaQuery = builder.createQuery(entityClass);
        Root<T> root = criteriaQuery.from(entityClass);
        criteriaQuery.select(root);
        return getSession().createQuery(criteriaQuery).list();
    }

    @Override
    public T update(T entity) {
        getSession().update(entity);
        return entity;
    }
}
