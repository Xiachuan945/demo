package com.example.demo;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.entity.PersonInfo;
import com.example.demo.repoistory.PersonInfoDao;
import com.example.demo.service.ifs.PersonInfoService;

@SpringBootTest
public class PersonInfoTest {

	@Autowired
	private PersonInfoService personInfoService;

	@Autowired
	private PersonInfoDao personInfoDao;

	@Test
	public void addInfoTest() {
		personInfoService.addInfo(new PersonInfo("A123456789", "Zack", 20, "Tainan"));
		personInfoService.addInfo(new PersonInfo("F258093732", "Amy", 20, "Tainan"));
		personInfoService.addInfo(new PersonInfo(null, "Lin", 20, "Taipei"));
	}

	@Test
	public void addInfoTest2() {
		List<PersonInfo> list = new ArrayList<>();
		list.add(new PersonInfo("D289036508", "Abbie", 27, "Miaoli"));
		list.add(new PersonInfo("E183960123", "Liuz", 29, "Chiayi"));
		personInfoService.addInfoList(list);
	}

	@Test
	public void daoSaveTest() {
		List<PersonInfo> list = new ArrayList<>();
		list.add(new PersonInfo("B234578789", "Sally", 23, "Taichung"));
		list.add(new PersonInfo("C171979461", "Edwin", 25, "Kaohsiung"));
		personInfoDao.saveAll(list);
	}

	@Test
	public void daoFindTest() {
		Optional<PersonInfo> infoOp = personInfoDao.findById("B234578789");
		if (infoOp.isEmpty()) {
			System.out.println("Not found !");
			return;
		}
		System.out.println(infoOp.get().getName());
	}

	@Test
	public void daoFindTest2() {
		List<PersonInfo> list = personInfoDao.findAll();
		for (PersonInfo item : list) {
			System.out.println(item.getName());
		}
	}

	@Test
	public void daoFindTest3() {
		boolean result = personInfoDao.existsById("B234578789");
		System.out.println(result);
	}

	@Test
	public void daoFindTest4() {
		List<PersonInfo> result = personInfoDao.findByCity("Tainan");
		List<PersonInfo> result2 = personInfoDao.findByNameAndCity("Zack","Tainan");
		List<PersonInfo> result3 = personInfoDao.findByNameOrCity("Zack","Tainan");
		for (PersonInfo item : result) {
			System.out.println(item.getName());
		}
	}
	// 4. 年紀大於輸入條件的所有個人資訊
	@Test
	public void compareTest() {
			List<PersonInfo> result = personInfoDao.findByAgeGreaterThan(25);
			for (PersonInfo item : result) {
				System.out.println(item.getId() + " " + item.getName()+": " + item.getAge() + "_" + item.getCity());
			}
	}
	// 5. 年紀小於等於輸入條件的所有個人資訊 (依年齡由小到大排序)
	@Test
	public void compareTest2() {
		List<PersonInfo> result = personInfoDao.findByAgeLessThanEqualOrderByAge(23) ;
		for (PersonInfo item : result) {
			System.out.println(item.getId() + " " + item.getName()+": " + item.getAge() + "_" + item.getCity());
		}
	}
	// 6. 年齡小於輸入條件 1或是大於輸入條件 2的資訊
	@Test
	public void compareTest3() {
		List<PersonInfo> result = personInfoDao.findByAgeLessThanOrAgeGreaterThan(25, 29) ;
		for (PersonInfo item : result) {
			System.out.println(item.getId() + " " + item.getName()+": " + item.getAge() + "_" + item.getCity());
		}
	}
	// 7. 找到年紀介於 2個數字之間 (有包含)的資訊
	@Test
	public void betweenTest() {
		List<PersonInfo> result = personInfoDao.findTop3ByAgeBetweenOrderByAgeDesc(23, 26);
		for (PersonInfo item : result) {
			System.out.println(item.getId() + " " + item.getName()+": " + item.getAge() + "_" + item.getCity());
		}
	}
	// 8. 取得 city 包含某個特定字的所有個人資訊
	@Test
	public void containingTest() {
		List<PersonInfo> result = personInfoDao.findByCityContaining("Tainan") ;
		for (PersonInfo item : result) {
			System.out.println(item.getId() + " " + item.getName()+": " + item.getAge() + "_" + item.getCity());
		}
	}	
	// 9. 年紀大於輸入條件 &  city 包含某個特定字的所有人資訊(年齡由大到小排序)
	@Test
	public void containingTest2() {
		List<PersonInfo> result = personInfoDao.findByAgeGreaterThanAndCityContainingOrderByAgeDesc(23, "g") ;
		for (PersonInfo item : result) {
			System.out.println(item.getId() + " " + item.getName()+": " + item.getAge() + "_" + item.getCity());
		}
	}


}
