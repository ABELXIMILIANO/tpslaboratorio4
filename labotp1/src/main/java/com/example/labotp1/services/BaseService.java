package com.example.labotp1.services;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface BaseService <E>{

    public List<E>findAll() throws Exception;
    public E findById(long id) throws Exception;
    public E save(E entity) throws Exception;
    public E update(Long id, E entity) throws Exception;
    public boolean delete(Long id) throws Exception;


}
