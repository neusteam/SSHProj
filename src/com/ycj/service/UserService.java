package com.ycj.service;

import java.util.List;

import com.ycj.dao.Users;

public interface UserService {
public int addUser(Users user);
public List<Users> findUser(String username);
public List<Users> findAll();
}
