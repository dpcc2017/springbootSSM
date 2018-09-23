package com.example.springbootSSM.Dao;

import java.util.List;

public interface BaseDao {
    public int insert(String statement, Object parameter);

    public <T> T selectOne(String statement, Object parameter);

    public <T> List<T> select(String statement, Object parameter);

    public int delete(String statement, Object parameter);

    public int update(String statement, Object parameter);
}
