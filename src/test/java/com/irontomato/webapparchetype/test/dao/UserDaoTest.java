package com.irontomato.webapparchetype.test.dao;

import com.irontomato.webapparchetype.dao.UserDao;
import com.irontomato.webapparchetype.entity.User;
import com.irontomato.webapparchetype.test.TestBase;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;

@ActiveProfiles(profiles = {"db.h2"})
public class UserDaoTest extends TestBase {

    @Autowired
    private UserDao userDao;

    @Test
    public void testFind(){
        User user = userDao.getUser(1);
        Assert.assertEquals("admin", user.getUsername());
        Assert.assertEquals("admin123", user.getPassword());
    }

    @Test
    public void testAdd(){
        User user = new User();
        user.setId(2);
        user.setUsername("irontomato");
        user.setPassword("irontomato123");
        userDao.addUser(user);
        User user1 = userDao.getUser(user.getId());
        Assert.assertEquals(user.getUsername(), user1.getUsername());
        Assert.assertEquals(user.getPassword(), user1.getPassword());
    }
}
