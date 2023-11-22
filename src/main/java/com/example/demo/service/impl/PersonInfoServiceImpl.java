package com.example.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.example.demo.entity.PersonInfo;
import com.example.demo.repoistory.PersonInfoDao;
import com.example.demo.service.ifs.PersonInfoService;

@Service
public class PersonInfoServiceImpl implements PersonInfoService {

	@Autowired
	private PersonInfoDao personInfoDao;

	@Override
	public void addInfo(PersonInfo info) {
		String pattern = "[A-Za-z][1-2]\\d{8}";
		info.getId();
		// StringUtils 讓 id 裡的值為 null 的話也不會報錯，但要先寫在前面
		if (StringUtils.hasText(info.getId()) && info.getId().matches(pattern)) {
			personInfoDao.save(info);
		} else {
			System.out.println("id error !");
		}
	}
	
	@Override
	public void addInfoList (List<PersonInfo> infoList) {    // 假設 infoList 有 10 筆資料
		String pattern = "[A-Za-z][1-2]\\d{8}";
		for (PersonInfo item : infoList) {
			String id = item.getId() ;
//			if ( ! (StringUtils.hasText(id) && id.matches(pattern)) ){
//				System.out.println("id error !");
//				return ;
//			} 
			if ( ! StringUtils.hasText(id) || ! id.matches(pattern) ) {
				System.out.println("id error !");
				personInfoDao.save(item);
				return ;
			}
		}
		personInfoDao.saveAll(infoList);
	}

}
