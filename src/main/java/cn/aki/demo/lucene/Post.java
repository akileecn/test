package cn.aki.demo.lucene;

import lombok.Data;

@Data
public class Post {
	private String id;
	private String title;
	private String content;

	public Post(String id, String title, String content) {
		this.id = id;
		this.title = title;
		this.content = content;
	}
}
