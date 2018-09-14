package com.study.service;

import com.alibaba.fastjson.JSON;
import com.study.api.params.UserEntity;
import com.study.api.service.UserService;
import com.study.dao.UserMapper;
import com.study.dto.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
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
    @Transactional
    public String insertUser(String userName, String password, Integer age) {
        int flag = userMapper.add(userName, password, age);
        if (flag == 0) {
            return "新增失败";
        }
        return "新增成功";
    }

    @Override
    @Transactional
    public String updateUser(String userName, String password, Integer age, Integer id) {
        int flag = userMapper.update(userName, password, age, id);
        if (flag == 0) {
            return "修改失败";
        }
        return "修改成功";
    }

    @Override
    @Transactional
    public String deleteUser(Integer id) {
        int flag = userMapper.delete(id);
        if (flag == 0) {
            return "删除失败";
        }
        return "删除成功";
    }
}
