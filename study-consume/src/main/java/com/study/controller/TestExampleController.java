package com.study.controller;

import com.alibaba.dubbo.common.utils.StringUtils;
import com.alibaba.fastjson.JSON;
import com.study.api.params.UserEntity;
import com.study.api.service.TestExampleApi;
import com.study.api.service.UserService;
import com.study.model.ResutModel;
import com.study.model.UserModel;
import com.study.util.Constants;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RestController
public class TestExampleController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private TestExampleApi testExampleApi;

    @Autowired
    private UserService userService;

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Autowired
    private RedisTemplate redisTemplate;

    @ApiOperation(value="测试用例", notes = "测试用例")
    @RequestMapping(value = "/testExample/{name}", method = RequestMethod.GET)
    public String hello(@PathVariable String name){
        return testExampleApi.getTest(name);
    }

    @ApiOperation(value = "redis测试", notes = "redis测试")
    @RequestMapping(value = "/testRedis/{name}", method = RequestMethod.GET)
    public String testRedis(@PathVariable String name) {
        String showName = stringRedisTemplate.opsForValue().get(Constants.REDIS_EXAMPLE);
        if (StringUtils.isBlank(showName)) {
            showName = testExampleApi.getTest(name) + stringRedisTemplate.toString();
            stringRedisTemplate.opsForValue().set(Constants.REDIS_EXAMPLE, showName);
        }
//        stringRedisTemplate.delete(Constants.REDIS_EXAMPLE);
        return showName;
    }


    /**
     * 1 无参数
     */
    @RequestMapping(value = "/searchList", method = RequestMethod.GET)
    public List<UserModel> searchList() {
        List<UserModel> list = new ArrayList();
        return list;
    }

    /**
     * 2 查询字符串参数，可选和必选参数2. 查询字符串参数，可选和必选参数
     */
    @RequestMapping(value="/listByName",method = RequestMethod.GET)
    public String listByName(@RequestParam(value = "name", required = true) String name) throws IOException {
        UserModel userModel = new UserModel();
        userModel.setName(name);
        return JSON.toJSONString(userModel);
    }

    /**
     * 3 json参数，RestController用实体类型接受
     */
    @RequestMapping(value="/addUser",method = RequestMethod.GET)
    public String addUser(@RequestBody UserModel userModel) throws IOException {
        return JSON.toJSONString(userModel);
    }

    /**
     * 4 路径参数
     */
    @RequestMapping(value="/searchListById/{name}",method = RequestMethod.GET)
    public String searchListById(@PathVariable String name) {
        return name;
    }

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
