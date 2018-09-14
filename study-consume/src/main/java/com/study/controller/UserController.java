package com.study.controller;

import com.study.api.params.UserEntity;
import com.study.api.service.UserService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * user restfull
 */
@RestController
public class UserController {


    @Autowired
    private UserService userService;

    /**
     * 用户查询
     * @return
     */
    @ApiOperation(value="用户查询", notes = "用户查询")
    @RequestMapping(value = "/getAllUser", method = RequestMethod.GET)
    public List<UserEntity> getAllUser() {

        return userService.getAllUser();
    }

    /**
     * 用户新增
     * @param userEntity
     * @return
     */
    @ApiOperation(value="用户新增", notes = "用户新增")
    @RequestMapping(value = "/insertUser", method = RequestMethod.GET)
    public String insertUser(@RequestBody UserEntity userEntity) {

        return userService.insertUser(userEntity);
    }

    /**
     * 用户修改
     * @param userEntity
     * @return
     */
    @ApiOperation(value="用户修改", notes = "用户修改")
    @RequestMapping(value = "/updateUser", method = RequestMethod.GET)
    public String updateUser(@RequestBody UserEntity userEntity) {

        return userService.updateUser(userEntity);
    }

    /**
     * 用户删除
     * @param id
     * @return
     */
    @ApiOperation(value="用户删除", notes = "用户删除")
    @RequestMapping(value = "/deleteUser/{id}", method = RequestMethod.GET)
    public String deleteUser(@PathVariable Long id) {

        return userService.deleteUser(id);
    }




}
