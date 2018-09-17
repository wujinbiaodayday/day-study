package com.study.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * 用户的业务
 */
@Controller
@RequestMapping(value = "/user")
public class UserController {


    private Logger logger = LoggerFactory.getLogger(this.getClass());

    /**
     * 登陆页面视图
     */
    public String LOGIN_PAGE_VIEW = "/user/loginPage";

    /**
     * 登陆页面
     * @return
     */
    @RequestMapping(value = "/loginPage", method = RequestMethod.GET)
    public ModelAndView loginPage() {
        try {
            ModelAndView view = new ModelAndView(LOGIN_PAGE_VIEW);
            return view;
        } catch (Exception e) {
            logger.error(e.getMessage());
        }
        return null;
    }

}
