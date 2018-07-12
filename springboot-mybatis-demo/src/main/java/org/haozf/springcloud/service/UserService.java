package org.haozf.springcloud.service;

import java.util.List;

import org.haozf.springcloud.mybatis.model.User;

public interface UserService {

    int addUser(User user);

    List<User> findAllUser(int pageNum, int pageSize);
}