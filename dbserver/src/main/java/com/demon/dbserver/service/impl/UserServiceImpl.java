package com.demon.dbserver.service.impl;


import com.demon.dbserver.bean.User;
import com.demon.dbserver.dao.UserDao;
import com.demon.dbserver.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        return userDao.loadUserByUsername(s);
    }

    @Override
    public int addUser(String username, String password) {
        if (userDao.loadUserByUsername(username) != null) {
            return -1; //已存在该用户名
        }
        try {
            int id = userDao.getMaxId() + 1;
            password = DigestUtils.md5DigestAsHex(password.getBytes());
            User user = new User(id, username, password, "visitor");
            userDao.addUser(user);
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
        return 1;
    }
}
