package cn.edu.tju.service.impl;

import cn.edu.tju.domain.UserInfo;
import cn.edu.tju.mapper.UserMapper;
import cn.edu.tju.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;
    @Override
    public int selectUser(String username, String password) {
        return userMapper.selectUser(username, password);
    }

    @Override
    public List<UserInfo> getUserList() {
        return userMapper.getUserList();
    }

    @Override
    public int deleteUser(String username) {
        return userMapper.deleteUser(username);
    }

    @Override
    public int addUser(String username, String password) {
        return userMapper.addUser(username, password);
    }
}
