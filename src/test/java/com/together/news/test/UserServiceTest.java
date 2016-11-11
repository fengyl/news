package com.together.news.test;

import com.together.news.entity.User;
import com.together.news.service.UserService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * UserServiceTest
 *
 * @author: zhangteng
 * @time: 2015/3/24 20:02
 */
public class UserServiceTest extends AbstractTestCase {
    @Autowired
    private UserService userService;

    @Test
    public void newUser() throws Exception {
        User user = new User();
        user.setUserName("123");
        user.setPassword("123456");

        userService.newUser(user);

    }
}
