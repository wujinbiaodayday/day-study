package com.study.api.service;

import com.study.api.params.UserEntity;

import java.util.List;

/**
 * 用户服务
 */
public interface UserService {

    /**
     * 查询
     * @return
     */
    List<UserEntity> getAllUser();

    /**
     * 新增
     * @param userEntity
     */
    String insertUser(UserEntity userEntity);

    /**
     * 修改
     * @param userEntity
     */
    String updateUser(UserEntity userEntity);

    /**
     * 删除
     * @param id
     */
    String deleteUser(Long id);

}
