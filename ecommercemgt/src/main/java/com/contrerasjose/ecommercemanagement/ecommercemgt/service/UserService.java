package com.contrerasjose.ecommercemanagement.ecommercemgt.service;

import com.contrerasjose.ecommercemanagement.ecommercemgt.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.contrerasjose.ecommercemanagement.ecommercemgt.controller.UserDao;

import java.util.List;

@Service
public class UserService {

@Autowired
    private UserDao userDao;

public User getUserById(Long id){
    return userDao.findById(id).orElse(null);
}

public List<User> getAllUsers() {
    return userDao.findAll();
}
public User saveOrUpdateUser(User user){
    return userDao.save(user);
}

public void deleteUser(Long id){
    userDao.deleteById(id);
}
}