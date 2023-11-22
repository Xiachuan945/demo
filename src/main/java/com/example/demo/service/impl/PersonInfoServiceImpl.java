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
		// StringUtils �� id �̪��Ȭ� null ���ܤ]���|�����A���n���g�b�e��
		if (StringUtils.hasText(info.getId()) && info.getId().matches(pattern)) {
			personInfoDao.save(info);
		} else {
			System.out.println("id error !");
		}
	}
	
	@Override
	public void addInfoList (List<PersonInfo> infoList) {    // ���] infoList �� 10 �����
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
