package com.beci.model.dao;

import com.beci.Utils;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Criterion;
import org.slf4j.Logger;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

public abstract class GenericDAO<T, ID extends Serializable> {
    @Resource private SessionFactory sessionFactory;
    @Resource protected Logger normalLogger;
    private Class<T> entityClass;

    protected GenericDAO() {

    }

    @PostConstruct
    public void init() {
        this.entityClass = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
    }

    protected Class<T> getEntityClass() {
        return entityClass;
    }

    public Session getSession() throws Exception{
        return sessionFactory.getCurrentSession();
    }

    public void persist(T entity) throws Exception{
        getSession().persist(entity);
    }

    public void persist(List<T> entityList) throws Exception{
        entityList.forEach( entity -> {
            try {
                getSession().persist(entity);
            } catch (Exception e) {
                try {
                    throw e;
                } catch (Exception e1) {
                    normalLogger.error("Exception : ", e);
                }
            }
        } );
    }

    public T update(T entity) throws Exception{
        getSession().saveOrUpdate(entity);
        return entity;
    }

    public T findByID(ID id) throws Exception{
        return (T) getSession().load(getEntityClass(), id);
    }

    public List<T> findAll() throws Exception{
        return findByCriteria();
    }

    public List<T> findByCriteria(Criterion... criterions) throws Exception{
        Criteria crit = getSession().createCriteria(getEntityClass());
        for (Criterion c : criterions) {
            crit.add(c);
        }
        return Utils.safetyList(crit.list());
    }

    public void delete(T entity) throws Exception{
        getSession().delete(entity);
    }

    public void delete(List<T> entityList) throws Exception{
        entityList.forEach( entity -> {
            try {
                getSession().delete(entity);
            } catch (Exception e) {
                try {
                    throw e;
                } catch (Exception e1) {
                    normalLogger.error("Exception : ", e);
                }
            }
        } );
    }

    public Criteria getCriteria() throws Exception{
        return getSession().createCriteria(getEntityClass());
    }

    public void flush() throws Exception{
        getSession().flush();
    }

    public List<T> findBySQL(String sql, Object... params) throws Exception{
        Query query = getSession().createSQLQuery(sql);
        for(int i=0; i<params.length; i++) {
            query.setParameter(i, params[i]);
        }
        return Utils.safetyList(query.list());
    }
}
