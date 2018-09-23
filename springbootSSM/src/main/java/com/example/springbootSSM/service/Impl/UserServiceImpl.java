package com.example.springbootSSM.service.Impl;

import com.example.springbootSSM.Dao.BaseDao;
import com.example.springbootSSM.model.User;
import com.example.springbootSSM.service.UserService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@CacheConfig(cacheNames = "user") //配置缓存名
public class UserServiceImpl implements UserService {
    private static Logger logger = Logger.getLogger(UserServiceImpl.class);
    @Autowired
    BaseDao baseDao;
    @Autowired
    CacheManager cacheManager;
    @Override
    @Transactional  //添加数据库事务功能（增删改一般需要添加事务）
    @CachePut(key = "#user.id") //保存数据的后将数据加入缓存
    public User insert(User user) {
        logger.info("cachemanager是："+cacheManager.toString());
        baseDao.insert("UserMapper.insertUser", user);
        logger.info("缓存名是："+cacheManager.getCacheNames());
        return user;

        /*int a = 0;
        a = 10 / a;//设置回滚条件*/

       /* //回滚条件
       try {
            int a = 0;
            a = 10 / a;
        } catch (ArithmeticException e) {
            logger.error("分母为0");
            throw new RuntimeException();
        }
        return 1;
*/
    }

    @Override
    @Cacheable(key="#id") //查询数据时先查缓存
    public User select(int id) {
        User user1=baseDao.selectOne("UserMapper.selectUser", id);
        return user1;
    }

    @Override
    @Transactional
    @CacheEvict(key = "#user.id")//默认删除数据后删除缓存
    public int delete(User user) {
       return baseDao.delete("UserMapper.deleteUser",user);

    }

    @Override
    @Transactional
    @CachePut(key = "#user.id") //更新数据后存入缓存
    public User update(User user) {
        baseDao.update("UserMapper.updateUser", user);
        return user;
    }
}
