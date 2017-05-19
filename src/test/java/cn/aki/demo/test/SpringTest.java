package cn.aki.demo.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cn.aki.demo.dao.TestObjectMapper;
import cn.aki.demo.entity.TestObject;

@RunWith(SpringJUnit4ClassRunner.class)
//@WebAppConfiguration
@ContextConfiguration({"/spring/spring.xml"})
public class SpringTest {
	
	@Autowired
	private TestObjectMapper testObjectMapper;
	private static final Logger log = LoggerFactory.getLogger(SpringTest.class);

	@Test
	public void dateBaseTest(){
		TestObject obj = testObjectMapper.selectByPrimaryKey(1L);
		log.debug(obj.getText());
	}
}
