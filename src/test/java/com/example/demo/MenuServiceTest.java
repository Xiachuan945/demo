package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

import com.example.demo.entity.Menu;
import com.example.demo.repoistory.MenuDao;
import com.example.demo.service.ifs.MenuService;

@SpringBootTest
public class MenuServiceTest {

	@Autowired
	private MenuService menuService;

	@Autowired
	private MenuDao menuDao;

	@Test
	public void addMenuTest() {
		// name 不符條件
		Menu result = menuService.addMenu(new Menu("", 120));
		Assert.isTrue(result == null, "addMenu error !");
		// price = 0
		result = menuService.addMenu(new Menu("chicken", 0));
		Assert.isTrue(result == null, "addMenu error !");
		// 正常新增
		result = menuService.addMenu(new Menu("fish", 120));
		Assert.isTrue(result != null, "addMenu error !");
		// 新增已存在的 menu
		result = menuService.addMenu(new Menu("fish", 150));
		Assert.isTrue(result == null, "addMenu error !");
		// 刪除測試資料
		menuDao.deleteById("fish") ;
	}
	
	@Test
	public void updateMenuTest() {
		// name 不符條件
		Menu result = menuService.updateMenu(new Menu("", 120));
		Assert.isTrue(result == null, "updateMenu error !");
		// price = 0
		result = menuService.updateMenu(new Menu("chicken", 0));
		Assert.isTrue(result == null, "updateMenu error !");
		// 更新不存在的 menu
		result = menuService.updateMenu(new Menu("fish1", 120));
		Assert.isTrue(result == null, "updateMenu error !");
		// 正常新增後再更新
		result = menuService.addMenu(new Menu("fish", 120));
		result = menuService.updateMenu(new Menu("fish1", 150));
		Assert.isTrue(result != null, "addMenu error !");
		Assert.isTrue(result.getPrice() == 150, "updateMenu error !");
		// 刪除測試資料
		menuDao.deleteById("fish1") ;
}
	
	@Test
	public void findByNameTest() {
		// name 不符條件
		Menu result = menuService.findByName("");
		Assert.isTrue(result == null, "findByName error !");
		// name 不存在
		result = menuService.findByName("fish1");
		Assert.isTrue(result == null, "findByName error !");
		// 新增測試資料
		result = menuService.addMenu(new Menu("fish", 120));
		result = menuService.findByName("fish1");
		Assert.isTrue(result != null, "findByName error !");
		// 刪除測試資料
		menuDao.deleteById("fish1") ;
}

}
