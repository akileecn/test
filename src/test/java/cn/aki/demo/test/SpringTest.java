package cn.aki.demo.test;

import cn.aki.demo.Application;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cn.aki.demo.dao.TestObjectMapper;
import cn.aki.demo.entity.TestObject;
import org.springframework.test.context.web.WebAppConfiguration;

@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration({"/spring/spring.xml"})
@SpringBootTest(classes = Application.class)
public class SpringTest {
	
	@Autowired
	private TestObjectMapper testObjectMapper;

	private static final Logger log = LoggerFactory.getLogger(SpringTest.class);

	@Test
	public void dateBaseTest(){
		TestObject obj = testObjectMapper.selectByPrimaryKey(1L);
		log.info(obj.getText());
	}

}
