package cn.aki.demo.test;

import cn.aki.demo.Application;
import cn.aki.demo.dao.TestObjectMapper;
import cn.aki.demo.entity.TestObject;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Application.class)
public class SpringTest {
	
	@Autowired
	private TestObjectMapper testObjectMapper;

	@Value("${jdbc.url_:${jdbc.username_:hello}}")
	private String value;

	private static final Logger log = LoggerFactory.getLogger(SpringTest.class);

	@Test
	public void dateBaseTest(){
		TestObject obj = testObjectMapper.selectByPrimaryKey(1L);
		log.info(obj.getText());
	}

	@Test
	public void valueTest(){
		System.err.println(value);
	}

}
