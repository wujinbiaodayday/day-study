package com.study.controller;

import com.study.api.service.TestExampleApi;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestExampleController {

    @Autowired
    private TestExampleApi testExampleApi;

    @ApiOperation(value="测试用例", notes = "测试用例")
    @RequestMapping(value = "/testExample/{name}", method = RequestMethod.GET)
    public String hello(@PathVariable String name){
        return testExampleApi.getTest(name);
    }
}
