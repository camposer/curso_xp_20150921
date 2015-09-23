package service;

import org.junit.Ignore;
import org.junit.runner.RunWith;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import config.BeanConfig;
import config.DatabaseConfig;
import config.PropertyConfig;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { DatabaseConfig.class, PropertyConfig.class, BeanConfig.class })
@ActiveProfiles("test")
@Transactional
@Ignore
public class ServiceTest {

}
