package com.ssafy.happyhouse.model.service;

import java.sql.SQLException;
import java.util.List;

import com.ssafy.happyhouse.model.dao.HouseInfoDao;
import com.ssafy.happyhouse.model.dao.HouseInfoDaoImpl;
import com.ssafy.happyhouse.model.dto.HouseInfo;

public class HouseInfoService {
	
	private HouseInfoDao dao;

	public HouseInfoService() {
		dao = new HouseInfoDaoImpl();
	}
	/**
	 * 
	 * @return
	 */
	public List<HouseInfo> getHouseInfos (){
		try {
			return dao.searchAllHouseInfo();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	/**
	 * 
	 * @param no
	 * @return
	 */
	public HouseInfo getHouseInfo(int no) {
		try {
			return dao.searchHouseInfo(no);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	/**
	 * 
	 * @param dong
	 * @param aptname
	 * @return
	 */
	public HouseInfo getHouseInfo(String dong, String aptname) {
		try {
			return dao.searchHouseInfo(dong, aptname);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	
	public static void main(String[] args) {
		HouseInfoService service = new HouseInfoService();
		
		try {
			service.dao.searchAllHouseInfo().forEach(System.out::println);
			System.out.println(service.dao.searchHouseInfo(1));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
}

