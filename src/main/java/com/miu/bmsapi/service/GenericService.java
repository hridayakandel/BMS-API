package com.miu.bmsapi.service;

import java.util.List;

public interface GenericService <T>{
    T save(T t);
    T update(T t);
    T getById(int id);
    List<T> getAll();
}
