package cn.aki.demo.test;

import cn.aki.demo.entity.TestObject;
import cn.aki.demo.lombok.LombokBean;
import org.apache.ibatis.jdbc.SQL;
import org.apache.ibatis.reflection.MetaObject;
import org.apache.ibatis.reflection.SystemMetaObject;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

public class SimpleTest {
	private static final Logger log = LoggerFactory.getLogger(SimpleTest.class);
	
	@Test
	public void semaphoreTest(){
		ExecutorService executor = Executors.newFixedThreadPool(30);
		final Semaphore semaphore = new Semaphore(10);
		for(int i = 0; i < 100; i++){
			executor.execute(new Runnable() {
				public void run() {
					try {
						semaphore.acquire();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					System.err.println(Thread.currentThread().getName() + ":" + semaphore.availablePermits());
					semaphore.release();
				}
			});
		}
		executor.shutdown();
	}
	
	@Test
	public void sqlTest(){
		SQL sql = new SQL().SELECT("val1, val2").FROM("table").WHERE("id=?");
		log.debug("sql:{}", sql.toString());
		
		SQL sql2 = new SQL(){
			// 构造代码块
			{
				SELECT("val1, val2");
				FROM("table");
				WHERE("id=?");
			}
		};
		log.debug("sql2:{}", sql2.toString());
	}
	
	@Test
	public void metaObjectTest(){
		TestObject obj = new TestObject();
		obj.setText("222");
		// mybatis提供的工具类
		MetaObject metaObject = SystemMetaObject.forObject(obj);
		System.err.println(metaObject.getValue("text"));
	}

	@Test
	public void lombokTest(){
		LombokBean bean = new LombokBean();
		bean.setText("ddd");
		System.err.println(bean.getText());

	}

	@Test
	public void logTest(){
		log.debug("{}{}{}", "a", "b");
	}

}
