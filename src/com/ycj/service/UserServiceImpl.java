package com.ycj.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ycj.dao.Users;
import com.ycj.dao.UsersDAO;
@Transactional
@Service("userService")
public class UserServiceImpl implements UserService {
    @Autowired
	private UsersDAO usersDao;
	public int addUser(Users user) {
		this.usersDao.save(user);
		// TODO Auto-generated method stub
		return 0;
	}

}
