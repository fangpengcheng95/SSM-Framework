package com.fpc.Service;

import java.util.List;

import com.fpc.Entity.User;
import com.fpc.Util.Page;
public interface IUserService {
	public User getUserById(int userId);
	public List<User> selectUser(int start,int limit);
	public List<User> getUsersListPage(Page page);
}
