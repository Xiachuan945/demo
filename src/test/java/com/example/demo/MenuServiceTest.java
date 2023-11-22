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
		// name ���ű���
		Menu result = menuService.addMenu(new Menu("", 120));
		Assert.isTrue(result == null, "addMenu error !");
		// price = 0
		result = menuService.addMenu(new Menu("chicken", 0));
		Assert.isTrue(result == null, "addMenu error !");
		// ���`�s�W
		result = menuService.addMenu(new Menu("fish", 120));
		Assert.isTrue(result != null, "addMenu error !");
		// �s�W�w�s�b�� menu
		result = menuService.addMenu(new Menu("fish", 150));
		Assert.isTrue(result == null, "addMenu error !");
		// �R�����ո��
		menuDao.deleteById("fish") ;
	}
	
	@Test
	public void updateMenuTest() {
		// name ���ű���
		Menu result = menuService.updateMenu(new Menu("", 120));
		Assert.isTrue(result == null, "updateMenu error !");
		// price = 0
		result = menuService.updateMenu(new Menu("chicken", 0));
		Assert.isTrue(result == null, "updateMenu error !");
		// ��s���s�b�� menu
		result = menuService.updateMenu(new Menu("fish1", 120));
		Assert.isTrue(result == null, "updateMenu error !");
		// ���`�s�W��A��s
		result = menuService.addMenu(new Menu("fish", 120));
		result = menuService.updateMenu(new Menu("fish1", 150));
		Assert.isTrue(result != null, "addMenu error !");
		Assert.isTrue(result.getPrice() == 150, "updateMenu error !");
		// �R�����ո��
		menuDao.deleteById("fish1") ;
}
	
	@Test
	public void findByNameTest() {
		// name ���ű���
		Menu result = menuService.findByName("");
		Assert.isTrue(result == null, "findByName error !");
		// name ���s�b
		result = menuService.findByName("fish1");
		Assert.isTrue(result == null, "findByName error !");
		// �s�W���ո��
		result = menuService.addMenu(new Menu("fish", 120));
		result = menuService.findByName("fish1");
		Assert.isTrue(result != null, "findByName error !");
		// �R�����ո��
		menuDao.deleteById("fish1") ;
}

}
