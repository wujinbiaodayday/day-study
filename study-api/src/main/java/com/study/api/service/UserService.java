package com.study.api.service;

import com.study.api.params.UserEntity;

import java.util.List;

/**
 * 用户服务
 */
public interface UserService {

    /**
     * 查询
     *
     * @return
     */
    List<UserEntity> getAllUser();

    /**
     * 新增
     *
     * @param userName
     * @param password
     * @param age
     * @return
     */
    String insertUser(String userName, String password, Integer age);

    /**
     * 修改
     *
     * @param userName
     * @param password
     * @param age
     * @param id
     * @return
     */
    String updateUser(String userName, String password, Integer age, Integer id);

    /**
     * 删除
     *
     * @param id
     */
    String deleteUser(Integer id);

}
