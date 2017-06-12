package cn.aki.demo.test;

import com.google.common.base.Joiner;
import com.google.common.collect.Lists;
import com.google.common.reflect.TypeToken;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.*;
import java.util.function.Predicate;

/**
 * Created by Administrator on 2017/5/31.
 */
public class GuavaTest {
	private static final Logger log = LoggerFactory.getLogger(GuavaTest.class);

	@Test
	public void test(){
		Optional<String> optional = Optional.empty();
//		optional.get();
//		System.err.println(optional.isPresent());

		Predicate<String> result = object -> {
			System.err.println("xxx");
			return Objects.isNull(object);
		};
		result = Objects::isNull;
		System.err.println(result.test(""));

		List<String> list = Lists.newArrayList("a", "b", "c");
		System.err.println(list.size());
		list.forEach(item -> System.err.println("<"+item+">"));

		list.stream();

	}

	private List<String> list;
	@Test
	public void TypeTest () throws Exception{
		Field field = GuavaTest.class.getDeclaredField("list");
		Type type = field.getGenericType();
		Type rawType = field.getType();
		TypeToken typeToken = TypeToken.of(type);
		Type genericType = ((ParameterizedType)type).getActualTypeArguments()[0];

		log.debug("typeName:{}", type.getTypeName()); // java.util.List<java.lang.String>
		log.debug("genericTypeName:{}", genericType.getTypeName()); // java.lang.String
		log.debug("isSubtypeOf:{}", typeToken.isSubtypeOf(Collection.class)); // true
		log.debug("isSupertypeOf:{}", typeToken.isSupertypeOf(ArrayList.class)); // false
		log.debug("rawType isSupertypeOf:{}", TypeToken.of(rawType).isSupertypeOf(ArrayList.class)); // true

	}

	@Test
	public void joinerTest(){
		System.err.println(Joiner.on(",").join(Lists.newArrayList(1,2,3,4)));
	}
}
