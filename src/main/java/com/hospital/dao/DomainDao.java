package com.hospital.dao;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Jimmy on 2017/3/11.
 */
public interface DomainDao<T,PK extends Serializable>{
    T load(PK id);

    T get(PK id);

    T getByName(String name);

    List<T> findAll();

    void persist(T entity);

    PK save(T entity);

    void saveOrUpdate(T entity);

    void delete(PK id);

    void flush();
}