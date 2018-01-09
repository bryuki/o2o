package com.kmn.bryuki.o2o;

import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Description:用来配置spring和junit整合,junit启动时加载springIOC容器
 *
 * @author: Feluna
 * @Date: 2018/1/1 19:12
 * @email: bryuki@outlook.com
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/spring-dao.xml", "classpath:spring/spring-service.xml"})
public class BaseTest {
}