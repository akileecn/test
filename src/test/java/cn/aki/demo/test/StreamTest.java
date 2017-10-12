package cn.aki.demo.test;

import org.junit.Test;

import java.util.Random;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamTest {

	@Test
	public void test() {
		Random random = new Random();
		Stream.generate(() -> random.nextInt(10))
				.limit(10)
				.forEach(System.out::println);
	}

	@Test
	public void randomTest() {
		Random random = new Random();
		IntStream.range(1, 10).map(random::nextInt).forEach(System.err::println);
	}
}
