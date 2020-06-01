package com.ssafy.happyhouse.model.service;

import java.sql.SQLException;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.happyhouse.HappyHouseException;
import com.ssafy.happyhouse.model.dao.HouseDao;
import com.ssafy.happyhouse.model.dto.HouseDeal;
import com.ssafy.happyhouse.model.dto.Pair;
import com.ssafy.happyhouse.model.dto.SearchDto;
import com.ssafy.happyhouse.util.PageNavigation;

@Service
public class HouseServiceImpl implements HouseService {

   @Autowired
   private HouseDao dao;

   /**
    * 검색 조건(key) 검색 단어(word)에 해당하는 아파트 거래 정보(HouseInfo)를 검색해서 반환.
    * 
    * @param bean 검색 조건과 검색 단어가 있는 객체
    * @return 조회한 식품 목록
    */
   public List<HouseDeal> detaillist(SearchDto searchDto) throws SQLException {
      System.err.println("service");
      List<HouseDeal> list = dao.detaillist(searchDto);
      // 정렬 알고리즘 -->퀵
      if (list.size() != 0) {
         for (int i = 0; i < list.size(); i++) {
            String temp = list.get(i).getDealAmount().replaceAll(",", "");
            temp = temp.replaceAll(" ", "");
            list.get(i).setDealAmount(temp);
         }
         quicksort(list, 0, list.size() - 1);
      } else {
         list = null;
      }
      return list;
   }

   private void quicksort(List<HouseDeal> list, int start, int end) {
      int left = start;
      int right = end;
      int pivot = Integer.parseInt(list.get((left + right) / 2).getDealAmount());
      do {
         while (Integer.parseInt(list.get(left).getDealAmount()) < pivot) {
            left++;
         }
         while (Integer.parseInt(list.get(right).getDealAmount()) > pivot) {
            right--;
         }
         if (left <= right) {
            Collections.swap(list, left, right);
            left++;
            right--;
         }
      } while (left <= right);
      if (start < right) {
         quicksort(list, start, right);
      }
      if (end > left) {
         quicksort(list, left, end);
      }

   }

   /**
    * 아파트 식별 번호에 해당하는 아파트 거래 정보를 검색해서 반환.
    * 
    * @param no 검색할 아파트 식별 번호
    * @return 아파트 식별 번호에 해당하는 아파트 거래 정보를 찾아서 리턴한다, 없으면 null이 리턴됨
    */
   @Override
   public HouseDeal searchHouseByNo(int no) {
      return dao.searchByNo(no);
   }

   @Override
   public List<HouseDeal> searchAll(int currentPage, int sizePerPage) throws SQLException {
      Pair pa = new Pair();
      pa.setX(currentPage);
      pa.setY(sizePerPage);
      return dao.searchAll(pa);
   }

   @Override
   public PageNavigation makePageNavigation(int currentPage, int sizePerPage) throws SQLException {
      PageNavigation pageNavigation = new PageNavigation();
      int naviSize = 10;// 페이지 갯수
      pageNavigation.setCurrentPage(currentPage);
      pageNavigation.setNaviSize(naviSize);
      int totalCount = dao.getTotalCount();// 총 개시글수
      System.out.println(totalCount);
      pageNavigation.setTotalCount(totalCount);
      int totalPageCount = (totalCount - 1) / sizePerPage + 1;// 총 페이지수
      pageNavigation.setTotalPageCount(totalPageCount);
      boolean startRange = currentPage <= naviSize;// startRange true : 이전:X false: 이전 O
      pageNavigation.setStartRange(startRange);
      boolean endRange = (totalPageCount - 1) / naviSize * naviSize < currentPage;// endRange ture : 다음 X false : 다음 O
      pageNavigation.setEndRange(endRange);
      pageNavigation.makeNavigator();
      return pageNavigation;
   }

  
}