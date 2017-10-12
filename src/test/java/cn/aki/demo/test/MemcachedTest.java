package cn.aki.demo.test;

import lombok.Data;
import net.spy.memcached.MemcachedClient;
import net.spy.memcached.internal.OperationFuture;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;
import java.util.concurrent.ExecutionException;

public class MemcachedTest extends AbstractSpringTest {
	@Autowired
	private MemcachedClient client;

	@Test
	public void addTest() throws ExecutionException, InterruptedException {
		StoreObject object = new StoreObject();
		object.value = "test";
		OperationFuture<Boolean> future = client.add("key", 60, object);
		System.err.println(future.get());
	}

	@Test
	public void getTest() {
		Object object = client.get("key");
		System.err.println(object);
	}

	@Data
	private static class StoreObject implements Serializable {
		private String value;
	}
}
