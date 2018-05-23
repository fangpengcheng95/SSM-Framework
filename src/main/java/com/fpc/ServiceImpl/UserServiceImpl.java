package com.fpc.ServiceImpl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.fpc.Dao.UserDao;
import com.fpc.Entity.User;
import com.fpc.Service.IUserService;
import com.fpc.Util.Page;

@Service("userService")
public class UserServiceImpl implements IUserService {
	@Resource
	private UserDao userDao;
	public User getUserById(int userId) {
		// TODO Auto-generated method stub
		return userDao.selectById(userId);
	}
	@Override
	public List<User> selectUser(int start, int limit) {
		// TODO Auto-generated method stub
		return userDao.selectUser(start,limit);
	}
	@Override
	public List<User> getUsersListPage(Page page) {
		// TODO Auto-generated method stub
		return userDao.getUsersListPage(page);
	}

}
