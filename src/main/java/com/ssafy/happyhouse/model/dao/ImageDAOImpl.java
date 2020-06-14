package com.ssafy.happyhouse.model.dao;

import java.util.ArrayList;
import java.util.List;
import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Repository;

import com.ssafy.happyhouse.model.dto.NewsDto;

@Repository
public class ImageDAOImpl implements ImageDAO {

private static String URL = "https://search.naver.com/search.naver?where=image&sm=tab_jum&query=";
	
	@Override
	public String selectImage(String name) throws IOException {
		Document doc = Jsoup.connect(URL+name).get();
		Elements tmp = doc.select("a");
		String[] arr = tmp.toString().split("data-source=");
		String[] brr = arr[1].split(" data-width=");
		return brr[0].toString().substring(1, brr[0].length()-1);
	}

}
