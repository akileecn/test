package cn.aki.demo.entity;

import cn.aki.demo.proxy.IText;
import lombok.Data;

import javax.persistence.Id;
import java.io.Serializable;

@Data
public class TestObject implements IText, Serializable {
	@Id
	private Long id;
	private String varcharValue;
	private Boolean booleanValue;
	private String textValue;

	@Override
	public String getText() {
		return textValue;
	}
}