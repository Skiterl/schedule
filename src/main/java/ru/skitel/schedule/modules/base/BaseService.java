package ru.skitel.schedule.modules.base;


import jakarta.transaction.Transactional;

import java.util.List;

public interface BaseService<T> {
    @Transactional
    T insert(T entity);
    @Transactional
    List<T> getAll();
    @Transactional
    void deleteById(int id);
}
