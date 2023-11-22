package com.example.demo.repoistory;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Meal;
import com.example.demo.entity.MealId;

@Repository
public interface MealDao extends JpaRepository<Meal, MealId> {
	
	// findTop數字：限制搜尋結果回傳筆數
	public List<Meal> findTop2ByName(String name) ;
	// findFirst數字：限制搜尋結果回傳筆數
	public List<Meal> findFirst2ByName(String name) ;

	// OrderBy：排序 (預設 ASC )
	// ASC：由小到大 ；DESC：由大到小
	public List<Meal> findByNameOrderByPrice(String name) ;
	// public List<Meal> findAllByOrderByPriceAsc( )： 由小到大排序
	public List<Meal> findAllByOrderByPrice() ;
	
	public List<Meal> findAllByOrderByPriceDesc() ;

	// 數字的比較大小：
	// 1. 大於：GreaterThan  2. 大於等於：GreaterThanEqual
	// 3. 小於：LessThan         4. 小於等於：LessThanEqual
	public List<Meal> findByPriceGreaterThan(int price) ;

	// 多個欄位 + 比較大小
	public List<Meal> findByNameAndPriceGreaterThan(String name, int price) ;
	
	// containing：包含 (模糊搜尋)
	public List<Meal> findByNameContaining(String name) ;
	
	public List<Meal> findByNameContainingAndCookingStyleContaining(String name, String cookingStyle) ;

	// between：有包含上下界的值
	public List<Meal> findByPriceBetween(int price1 , int price2) ;
	
	public List<Meal> findByPriceBetweenOrderByPrice(int price1 , int price2) ;

	// in
	public List<Meal> findByPriceIn(List<Integer> price) ;
	// notIn
	public List<Meal> findByPriceNotIn(List<Integer> price) ;
}
