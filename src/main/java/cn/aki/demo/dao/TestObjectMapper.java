package cn.aki.demo.dao;

import cn.aki.demo.entity.TestObject;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface TestObjectMapper extends Mapper<TestObject> {
	List<TestObject> list();
}