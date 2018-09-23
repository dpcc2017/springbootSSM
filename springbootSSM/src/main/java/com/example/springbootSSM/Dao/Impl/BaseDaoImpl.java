package com.example.springbootSSM.Dao.Impl;

import com.example.springbootSSM.Dao.BaseDao;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class BaseDaoImpl implements BaseDao{
    @Autowired
    SqlSessionTemplate sqlSessionTemplate;
    @Override

    public int insert(String statement, Object parameter) {
        System.out.println("即将执行插入操作");
        return this.sqlSessionTemplate.insert(statement, parameter);

    }

    @Override
    public <T> T selectOne(String statement, Object parameter) {
         return  sqlSessionTemplate.selectOne(statement, parameter);
    }

    @Override
    public <T> List<T> select(String statement, Object parameter) {
        return sqlSessionTemplate.selectList(statement,parameter);
    }

    @Override
    public int delete(String statement, Object parameter) {
        return sqlSessionTemplate.delete(statement,parameter);
    }

    @Override
    public int update(String statement, Object parameter) {
        return sqlSessionTemplate.update(statement, parameter);
    }
}
