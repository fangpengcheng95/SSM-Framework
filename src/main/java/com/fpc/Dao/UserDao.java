package com.fpc.Dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.fpc.Entity.User;
import com.fpc.Util.Page;

@Repository
public interface UserDao {
 public User selectById(int userId);
 
 public List<User> selectUser(int start,int limit);
 
 public List<User> getUsersListPage(  @Param("page") Page page);
}
