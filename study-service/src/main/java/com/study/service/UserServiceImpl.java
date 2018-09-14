package com.study.service;

import com.alibaba.fastjson.JSON;
import com.study.api.params.UserEntity;
import com.study.api.service.UserService;
import com.study.dao.UserMapper;
import com.study.dto.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public List<UserEntity> getAllUser() {
        List<User> userList = userMapper.getAllUser();
        if (CollectionUtils.isEmpty(userList)) {
            return null;
        }
        return JSON.parseArray(JSON.toJSONString(userList), UserEntity.class);
    }

    @Override
    public String insertUser(UserEntity userEntity) {
        return "新增成功";
    }

    @Override
    public String updateUser(UserEntity userEntity) {
        return "修改成功";
    }

    @Override
    public String deleteUser(Long id) {
        return "删除成功";
    }
}
