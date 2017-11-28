package cn.aki.demo.test;

import cn.aki.demo.entity.TestObject;
import cn.aki.demo.lombok.LombokBean;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.apache.ibatis.jdbc.SQL;
import org.apache.ibatis.reflection.MetaObject;
import org.apache.ibatis.reflection.SystemMetaObject;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringBootVersion;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

public class SimpleTest {
	private static final Logger log = LoggerFactory.getLogger(SimpleTest.class);

	public static void main(String[] args) {
		System.err.println(Integer.parseInt("02"));
	}

	@Test
	public void semaphoreTest() {
		ExecutorService executor = Executors.newFixedThreadPool(30);
		final Semaphore semaphore = new Semaphore(10);
		for (int i = 0; i < 100; i++) {
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
	public void sqlTest() {
		SQL sql = new SQL().SELECT("val1, val2").FROM("table").WHERE("id=?");
		log.debug("sql:{}", sql.toString());

		SQL sql2 = new SQL() {
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
	public void metaObjectTest() {
		TestObject obj = new TestObject();
		obj.setTextValue("222");
		// mybatis提供的工具类
		MetaObject metaObject = SystemMetaObject.forObject(obj);
		System.err.println(metaObject.getValue("text"));
	}

	@Test
	public void lombokTest() {
		LombokBean bean = new LombokBean();
		bean.setText("ddd");
		System.err.println(bean.getText());

	}

	@Test
	public void logTest() {
		log.debug("{}{}{}", "a", "b");
	}

	@Test
	public void jsonTest() {
		JSONObject json = JSON.parseObject("{'a':'a'}");
		System.err.println(json.getString("a"));
		System.err.println(json.getString("b"));
	}

	@Test
	public void dateTest() {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		LocalDateTime now = LocalDateTime.now();
//		System.err.println(now.format(formatter));
//		System.err.println(formatter.format(now));

		// LocalDateTime -> Instant -> Date
		Date date = Date.from(now.toInstant(ZoneOffset.UTC));
		// Date -> Instant -> LocalDateTime
		LocalDateTime localDateTime = LocalDateTime.ofInstant(date.toInstant(), ZoneId.systemDefault());
		System.err.println(formatter.format(localDateTime));
	}

	@Test
	public void versionTest() {
		// 从META-INF/MANIFEST.MF文件中获取，maven打包时可以自动生成
		System.err.println(SpringBootVersion.getVersion());
	}
}
