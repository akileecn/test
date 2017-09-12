package cn.aki.demo.test;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;

import java.util.UUID;

public class RedisTest extends AbstractSpringTest {

	@Autowired
	private StringRedisTemplate redisTemplate;

	@Test
	public void test() {
		ValueOperations<String, String> ops = redisTemplate.opsForValue();
		ops.set("foo:bar", UUID.randomUUID().toString());
		System.err.println(ops.get("foo:bar"));
	}

	@Test
	public void increaseTest() {
		ValueOperations<String, String> ops = redisTemplate.opsForValue();
		ops.increment("counter", 1);
		System.err.println(ops.get("counter"));
	}
}
