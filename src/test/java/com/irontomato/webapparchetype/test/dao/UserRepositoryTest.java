package com.irontomato.webapparchetype.test.dao;

import com.irontomato.webapparchetype.dao.UserRepository;
import com.irontomato.webapparchetype.entity.User;
import com.irontomato.webapparchetype.test.TestBase;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;

@ActiveProfiles(profiles = {"db.h2"})
public class UserRepositoryTest extends TestBase {

    @Autowired
    private UserRepository userRepository;

    @Test
    public void testFindByUsername(){
        User user = userRepository.findByUsername("admin");
        Assert.assertEquals("admin123", user.getPassword());
    }
    @Test
    public void testCount(){
        Assert.assertEquals(1L, userRepository.count());
    }
}
