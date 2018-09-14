package com.study.controller;

import com.study.api.params.UserEntity;
import com.study.api.service.UserService;
import com.study.model.ResutModel;
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
        try {
            return userService.getAllUser();
        } catch (Exception e) {
            logger.error(e.getMessage());
        }
        return null;
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
    public ResutModel insertUser(@RequestParam String userName, @RequestParam String password,
                                 @RequestParam Integer age) {
        try {
            userService.insertUser(userName, password, age);
            return ResutModel.SUCCESS();
        } catch (Exception e) {
            logger.error(e.getMessage());
            return ResutModel.FAIL("用户新增失败", e.getMessage());
        }
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
    public ResutModel updateUser(@RequestParam String userName, @RequestParam String password,
                             @RequestParam Integer age, @RequestParam Integer id) {
        try {
            userService.updateUser(userName, password, age, id);
            return ResutModel.SUCCESS();
        } catch (Exception e) {
            logger.error(e.getMessage());
            return ResutModel.FAIL("用户修改失败", e.getMessage());
        }
    }

    /**
     * 用户删除
     * @param id
     * @return
     */
    @ApiOperation(value="用户删除", notes = "用户删除")
    @RequestMapping(value = "/deleteUser/{id}", method = RequestMethod.GET)
    public ResutModel deleteUser(@PathVariable Integer id) {
        try {
            userService.deleteUser(id);
            return ResutModel.SUCCESS();
        } catch (Exception e) {
            logger.error(e.getMessage());
            return ResutModel.FAIL("用户删除失败", e.getMessage());
        }
    }




}
