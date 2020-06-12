package com.ssafy.happyhouse.model.dto;

import java.util.Arrays;

public class SearchDto {
	//private String[] type;
	private String searchType;
	private String searchWord;

//	public String[] getType() {
//		return type;
//	}
//	public void setType(String[] type) {
//		this.type = type;
//	}
	public String getSearchType() {
		return searchType;
	}
	public void setSearchType(String searchType) {
		this.searchType = searchType;
	}
	public String getSearchWord() {
		return searchWord;
	}
	public void setSearchWord(String searchWord) {
		this.searchWord = searchWord;
	}
//	@Override
//	public String toString() {
//		return "SearchDto [type=" + Arrays.toString(type) + ", searchType=" + searchType + ", searchWord=" + searchWord + "]";
//	}
	
}
