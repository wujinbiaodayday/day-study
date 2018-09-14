package com.study.controller;

import com.study.api.params.UserEntity;
import com.study.api.service.UserService;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * user restfull
 */
@RestController
public class UserController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());


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
     * @param userName
     * @param password
     * @param age
     * @return
     */
    @ApiOperation(value="用户新增", notes = "用户新增")
    @RequestMapping(value = "/insertUser", method = RequestMethod.GET)
    public String insertUser(@RequestParam String userName, @RequestParam String password,
                             @RequestParam Integer age) {
        return userService.insertUser(userName, password, age);
    }

    /**
     * 用户修改
     * @param userName
     * @param password
     * @param age
     * @param id
     * @return
     */
    @ApiOperation(value="用户修改", notes = "用户修改")
    @RequestMapping(value = "/updateUser", method = RequestMethod.GET)
    public String updateUser(@RequestParam String userName, @RequestParam String password,
                             @RequestParam Integer age, @RequestParam Integer id) {
        return userService.updateUser(userName, password, age, id);
    }

    /**
     * 用户删除
     * @param id
     * @return
     */
    @ApiOperation(value="用户删除", notes = "用户删除")
    @RequestMapping(value = "/deleteUser/{id}", method = RequestMethod.GET)
    public String deleteUser(@PathVariable Integer id) {
        return userService.deleteUser(id);
    }




}
