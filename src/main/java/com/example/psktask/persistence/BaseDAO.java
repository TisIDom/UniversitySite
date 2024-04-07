package com.example.psktask.persistence;

import java.util.List;

public interface BaseDAO<T, ID> {

    T findById(ID id);

    List<T> findAll();

    T save(T entity);

    void deleteById(ID id);
}
