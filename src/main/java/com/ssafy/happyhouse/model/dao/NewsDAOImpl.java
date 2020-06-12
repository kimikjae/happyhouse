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
public class NewsDAOImpl implements NewsDAO {

private static String URL = "https://search.naver.com/search.naver?sm=tab_hty.top&where=news&query=%EC%A3%BC%ED%83%9D";
	
	@Override
	public List<NewsDto> selectNews() throws IOException {
		Document doc = Jsoup.connect(URL).get();
		Elements headLines = doc.select("ul.type01 dl dt a");
		Elements press = doc.select("span._sp_each_source");
		String[][] strarr = new String[10][3];
		List<NewsDto> list = new ArrayList<NewsDto>();
		int i = 0;
		for(Element e : headLines) {
			if(e.text().length()==0) continue;
			//			System.out.print("헤드라인 : " + e.text()+" ");
			strarr[i][0] = (String)e.text();
			//			System.out.println("뉴스 링크 : " + e.attr("href"));
			strarr[i][1] = (String)e.attr("href");
			i++;
		}
		i = 0;
		for(Element e : press) {
			if(e.text().length()==0) continue;
			int idx = e.text().indexOf("언");
			String str = e.text();
			if(idx != -1) {
				String result = str.substring(0,idx);
				//				System.out.println("신문사 : " + result);
				strarr[i][2] = result;
			} else {
				//				System.out.println("신문사 : " + str);				
				strarr[i][2] = str;
			}
			i++;
		}
		i = 1;
		for(String[] arr : strarr) {
			NewsDto tmp = new NewsDto();
			tmp.setNo(i);
			tmp.setHeadLine(arr[0]);
			tmp.setSummary(arr[1]);
			tmp.setPressName(arr[2]);
			list.add(tmp);
			i++;
		}
		for(NewsDto dto : list) {
			System.out.println(dto.toString());
		}
		return list;
	}

}
