package com.study.controller;

import com.alibaba.dubbo.common.json.JSON;
import com.alibaba.dubbo.common.utils.StringUtils;
import com.study.api.service.TestExampleApi;
import com.study.model.UserModel;
import com.study.util.Constants;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RestController
public class TestExampleController {

    @Autowired
    private TestExampleApi testExampleApi;

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
        return JSON.json(userModel);
    }

    /**
     * 3 json参数，RestController用实体类型接受
     */
    @RequestMapping(value="/addUser",method = RequestMethod.GET)
    public String addUser(@RequestBody UserModel userModel) throws IOException {
        return JSON.json(userModel);
    }

    /**
     * 4 路径参数
     */
    @RequestMapping(value="/searchListById/{name}",method = RequestMethod.GET)
    public String searchListById(@PathVariable String name) {
        return name;
    }











}
