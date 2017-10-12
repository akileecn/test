package cn.aki.demo.test;

import cn.aki.demo.dao.TestObjectMapper;
import cn.aki.demo.entity.TestObject;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import java.util.List;

public class SpringTest extends AbstractSpringTest {

	@Autowired
	private TestObjectMapper testObjectMapper;

	@Value("${jdbc.url_:${jdbc.username_:hello}}")
	private String value;

	private static final Logger log = LoggerFactory.getLogger(SpringTest.class);

	@Test
	public void dateBaseTest() {
		TestObject obj = testObjectMapper.selectByPrimaryKey(1L);
		log.info(obj.getText());
	}

	@Test
	public void updateTest(){
		TestObject obj = new TestObject();
		obj.setId(1L);
		obj.setTextValue("xxxx");
		testObjectMapper.updateByPrimaryKeySelective(obj);
	}

	@Test
	public void listTest(){
		List<TestObject> list = testObjectMapper.list();
		System.err.println(list);
	}

	@Test
	public void valueTest() {
		System.err.println(value);
	}

}
