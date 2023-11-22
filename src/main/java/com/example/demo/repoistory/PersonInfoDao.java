package com.example.demo.repoistory;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.PersonInfo;

@Repository
public interface PersonInfoDao extends JpaRepository<PersonInfo, String> {

	public List<PersonInfo> findByCity(String city) ;
	
	public List<PersonInfo> findByNameAndCity(String name, String city) ;
	
	public List<PersonInfo> findByNameOrCity(String name, String city) ;
	// 4. 找出年紀大於輸入條件的所有個人資訊
	public List<PersonInfo> findByAgeGreaterThan(int age) ;
	// 5. 年紀小於等於輸入條件的所有個人資訊 ( 依年齡由小到大排序 ) 
	public List<PersonInfo> findByAgeLessThanEqualOrderByAge(int age) ;
	// 6. 年齡小於輸入條件 1或是大於輸入條件 2的資訊
	public List<PersonInfo> findByAgeLessThanOrAgeGreaterThan(int age1, int age2) ;
	// 7. 找到年紀介於 2 個數字之間 (有包含) 的資訊 ( 依年齡由大到小排序 - 只取前 3 筆資料 )
	public List<PersonInfo> findTop3ByAgeBetweenOrderByAgeDesc(int age1, int age2) ; 
	// 8. 取得 city 包含某個特定字的所有個人資訊
	public List<PersonInfo> findByCityContaining(String city) ;
	// 9. 年紀大於輸入條件 &  city 包含某個特定字的所有人資訊 ( 依年齡由大到小排序 )
	public List<PersonInfo> findByAgeGreaterThanAndCityContainingOrderByAgeDesc(int age, String city) ;
}
