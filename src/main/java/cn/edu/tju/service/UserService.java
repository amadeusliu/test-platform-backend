package cn.edu.tju.service;

import cn.edu.tju.domain.UserInfo;

import java.util.List;

public interface UserService {
    int selectUser(String username,String password);
    List<UserInfo> getUserList();
    int deleteUser(String username);
    int addUser(String username, String password);
}
