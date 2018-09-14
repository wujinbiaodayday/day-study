package com.study.service;

import com.study.api.params.UserEntity;
import com.study.api.service.UserService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {


    @Override
    public List<UserEntity> getAllUser() {
        UserEntity user = new UserEntity();
        user.setId(1L);
        user.setName("wujinbiao");
        user.setAge(28);
        user.setSex("男");
        List<UserEntity> list = new ArrayList<>(1);
        list.add(user);
        return list;
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
