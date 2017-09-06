package cn.gss.lk.pojo;

import java.util.Date;

public class Notice {
	private int id;
	private String name;
	private String content;
	private Date times;

	public Notice(int id, String name, String content, Date times) {
		this.id = id;
		this.name = name;
		this.content = content;
		this.times = times;
	}

	public Notice(String name, String content) {

		this.name = name;
		this.content = content;
	}

	public Notice() {

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getTimes() {
		return times;
	}

	public void setTimes(Date times) {
		this.times = times;
	}
}
