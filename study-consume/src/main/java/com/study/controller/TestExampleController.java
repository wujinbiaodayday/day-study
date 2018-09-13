package com.study.controller;

import com.alibaba.dubbo.common.utils.StringUtils;
import com.study.api.service.TestExampleApi;
import com.study.util.Constants;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.*;

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

//    @ApiOperation(value = "redis测试", notes = "redis测试")
//    @RequestMapping(value = "/testRedis?{name}", method = RequestMethod.GET)
//    public String testRedis(@RequestParam String name) {
//        String showName = stringRedisTemplate.opsForValue().get(Constants.REDIS_EXAMPLE);
//        if (StringUtils.isBlank(showName)) {
//            showName = testExampleApi.getTest(name) + stringRedisTemplate.toString();
//            stringRedisTemplate.opsForValue().set(Constants.REDIS_EXAMPLE, showName);
//        }
////        stringRedisTemplate.delete(Constants.REDIS_EXAMPLE);
//        return showName;
//    }



}
