package com.ssafy.happyhouse.model.dto;

public class SearchDto {
	private String[] type;
	private String option;
	private String searchWord;

	public String[] getType() {
		return type;
	}
	public void setType(String[] type) {
		this.type = type;
	}
	public String getOption() {
		return option;
	}
	public void setOption(String option) {
		this.option = option;
	}
	public String getSearchWord() {
		return searchWord;
	}
	public void setSearchWord(String searchWord) {
		this.searchWord = searchWord;
	}
}
