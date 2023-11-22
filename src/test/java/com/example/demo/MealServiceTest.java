package com.example.demo;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

import com.example.demo.entity.Meal;
import com.example.demo.entity.MealId;
import com.example.demo.repoistory.MealDao;
import com.example.demo.service.ifs.MealService;

@SpringBootTest
public class MealServiceTest {

	@Autowired
	private MealService mealService ;
	
	@Autowired
	private MealDao mealDao ;
	
	@Test
	public void addMeal() {
		mealService.addMeal(new Meal("beaf" ,  "BBQ", 180)) ;
		mealService.addMeal(new Meal("beaf" ,  "fry", 150)) ;
		mealService.addMeal(new Meal("pork" ,  "fried", 220)) ;
		mealService.addMeal(new Meal("chicken" ,  "stew", 260)) ;
		mealService.addMeal(new Meal("chicken" ,  "BBQ", 120)) ;
		mealService.addMeal(new Meal("chicken" ,  "steam", 520)) ;
	}
	
	@Test
	public void addMealTest() {
		// name ぃ才兵ン
		Meal result = mealService.addMeal(new Meal("" ,  "BBQ", 180)) ;
		Assert.isTrue(result == null, "addMeal error !");
		// cooking_style ぃ才
		result = mealService.addMeal(new Meal("beef" ,  "", 180)) ;
		Assert.isTrue(result == null, "addMeal error !");
		// price ぃ才
		result = mealService.addMeal(new Meal("beef" ,  "BBQ", 0)) ;
		Assert.isTrue(result == null, "addMeal error !");
		// タ盽穝糤
		result = mealService.addMeal(new Meal("beef" ,  "BBQ", 180)) ;
		Assert.isTrue(result != null, "addMeal error !");
		// 穝糤 meal
		result = mealService.addMeal(new Meal("beef" ,  "BBQ", 180)) ;
		Assert.isTrue(result == null, "addMeal error !");
		// 埃代刚戈
		mealDao.deleteById(new MealId("beaf" , "BBQ"));
	}
	
	@Test
	public void limitTest() {
		List<Meal> res = mealDao.findTop2ByName("chicken") ;
		System.out.println(res.size());
		Assert.isTrue(res.size() == 2 , "find_limit_error !");
	}
	
	@Test
	public void limitTest2() {
//		List<Meal> res = mealDao.findByNameOrderByPrice("chicken") ;
		List<Meal> res = mealDao.findAllByOrderByPrice() ;
//		List<Meal> res = mealDao.findAllByOrderByPriceDesc() ;
		for(Meal item : res) {
			System.out.println(item.getName() + "-" + item.getCookingStyle() + ": $" + item.getPrice());
		}
	}
	
	@Test
	public void compareTest() {
		List<Meal> res = mealDao.findByPriceGreaterThan(200) ;
		for(Meal item : res) {
			System.out.println(item.getName() + "-" + item.getCookingStyle() + ": $" + item.getPrice());
		}
	}
	
	@Test
	public void comtainingTest() {
		List<Meal> res = mealDao.findByNameContaining("e") ;
//		List<Meal> res = mealDao.findByNameContainingAndCookingStyleContaining("e", "B") ;
		for(Meal item : res) {
			System.out.println(item.getName() + "-" + item.getCookingStyle() + ": $" + item.getPrice());
		}
	}
	
	@Test
	public void betweenTest() {
		List<Meal> res = mealDao.findByPriceBetween(100, 300) ;
//		List<Meal> res = mealDao.findByPriceBetweenOrderByPrice(100, 300) ;
		for(Meal item : res) {
			System.out.println(item.getName() + "-" + item.getCookingStyle() + ": $" + item.getPrice());
		}
	}
	
	@Test
	public void inTest() {
//		List<Meal> res = mealDao.findByPriceIn(new ArrayList<>(List.of(100,120,150,180,200) ));
		List<Meal> res = mealDao.findByPriceNotIn(new ArrayList<>(List.of(100,120,150,180,200) ));
		for(Meal item : res) {
			System.out.println(item.getName() + "-" + item.getCookingStyle() + ": $" + item.getPrice());
		}
	}
}
