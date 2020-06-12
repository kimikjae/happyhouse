package com.ssafy.happyhouse.model.dto;

public class NewsDto {
	int no;
	String headLine;
	String summary;
	String contents;
	String pressName;
	@Override
	public String toString() {
		return "NewsDto [no=" + no + ", headLine=" + headLine + ", summary=" + summary + ", contents=" + contents
				+ ", pressName=" + pressName + "]";
	}
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getHeadLine() {
		return headLine;
	}
	public void setHeadLine(String headLine) {
		this.headLine = headLine;
	}
	public String getSummary() {
		return summary;
	}
	public void setSummary(String summary) {
		this.summary = summary;
	}
	public String getContents() {
		return contents;
	}
	public void setContents(String contents) {
		this.contents = contents;
	}
	public String getPressName() {
		return pressName;
	}
	public void setPressName(String pressName) {
		this.pressName = pressName;
	}
	public NewsDto(int no, String headLine, String summary, String contents, String pressName) {
		this.no = no;
		this.headLine = headLine;
		this.summary = summary;
		this.contents = contents;
		this.pressName = pressName;
	}
	public NewsDto() {
	}
	
	
}
