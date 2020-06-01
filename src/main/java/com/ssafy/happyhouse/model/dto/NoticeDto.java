package com.ssafy.happyhouse.model.dto;

public class NoticeDto {
	private int noticeno;
	private String id;
	private String name;
	private String subject;
	private String content;
	private String uploaddate;
	
	public String getUploaddate() {
		return uploaddate;
	}
	public void setUploaddate(String uploaddate) {
		this.uploaddate = uploaddate;
	}
	public int getNoticeno() {
		return noticeno;
	}
	public void setNoticeno(int noticeno) {
		this.noticeno = noticeno;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	@Override
	public String toString() {
		return "NoticeDto [noticeno=" + noticeno + ", id=" + id + ", name=" + name + ", subject=" + subject
				+ ", content=" + content + "]";
	}
}
