package com.example.taskwebappanimals.dao;



import java.util.List;

public abstract class AbstractDao <T>{

    public abstract List<T> select() ;


    public abstract T selectOne(int id);


    public abstract int insert (T entity);


    public abstract int update(T entity);


    public abstract boolean delete(int id);
}
