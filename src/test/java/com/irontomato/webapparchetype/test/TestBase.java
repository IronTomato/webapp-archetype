package com.irontomato.webapparchetype.test;

import com.irontomato.webapparchetype.config.RootConfig;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;

@ContextConfiguration(classes = {RootConfig.class})
public class TestBase extends AbstractJUnit4SpringContextTests{
}
