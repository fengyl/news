package com.together.news.controller;

import com.together.news.entity.User;
import com.together.news.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * IndexController
 *
 * @author: zhangteng
 * @time: 2015/3/24 16:57
 *
 * Modify by houseyoung on 15/8/24.
 */
@Controller
@RequestMapping(value = "")
public class IndexController {
    @Resource
    private UserService userService;

    @RequestMapping(value = {"", "/", "login"}, method = RequestMethod.GET)
    public String toLogin(HttpServletRequest request)
    {
        //If session have attribute "user", jump to index page, else jump to login page.
        if (request.getSession().getAttribute("user") != null){
            return "body/index";
        }
        else {
            return "login";
        }
    }


    //Login
    @RequestMapping(value = "login", method = RequestMethod.POST)
    public String login(User user, Model model, HttpServletRequest request) throws Exception{
        try {
            //If pass, set attribute to session, then redirect to index page.
            if (userService.checkLogin(user)) {
                request.getSession().setAttribute("user", user);
                return "redirect:index";
            }
            //If not pass, send error attribute.
            else{
                model.addAttribute("login_err", "登录失败!");
                return "login";
            }
        } catch (Exception e) {
            model.addAttribute("error", e.getMessage());
            return "login";
        }
    }

    //Log off
    @RequestMapping(value = {"logoff"}, method = RequestMethod.GET)
    public String logoff(HttpServletRequest request) {
        request.getSession().removeAttribute("user");
        return "redirect:login";
    }
}