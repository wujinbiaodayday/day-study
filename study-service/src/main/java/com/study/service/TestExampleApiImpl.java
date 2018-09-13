package com.study.service;


import com.study.api.service.TestExampleApi;
import org.springframework.stereotype.Service;

@Service("testExampleApi")
public class TestExampleApiImpl implements TestExampleApi {

    @Override
    public String getTest(String example) {
        return example;
    }
}
