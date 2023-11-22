package com.example.demo.repoistory;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Meal;
import com.example.demo.entity.MealId;

@Repository
public interface MealDao extends JpaRepository<Meal, MealId> {
	
	// findTop�Ʀr�G����j�M���G�^�ǵ���
	public List<Meal> findTop2ByName(String name) ;
	// findFirst�Ʀr�G����j�M���G�^�ǵ���
	public List<Meal> findFirst2ByName(String name) ;

	// OrderBy�G�Ƨ� (�w�] ASC )
	// ASC�G�Ѥp��j �FDESC�G�Ѥj��p
	public List<Meal> findByNameOrderByPrice(String name) ;
	// public List<Meal> findAllByOrderByPriceAsc( )�G �Ѥp��j�Ƨ�
	public List<Meal> findAllByOrderByPrice() ;
	
	public List<Meal> findAllByOrderByPriceDesc() ;

	// �Ʀr������j�p�G
	// 1. �j��GGreaterThan  2. �j�󵥩�GGreaterThanEqual
	// 3. �p��GLessThan         4. �p�󵥩�GLessThanEqual
	public List<Meal> findByPriceGreaterThan(int price) ;

	// �h����� + ����j�p
	public List<Meal> findByNameAndPriceGreaterThan(String name, int price) ;
	
	// containing�G�]�t (�ҽk�j�M)
	public List<Meal> findByNameContaining(String name) ;
	
	public List<Meal> findByNameContainingAndCookingStyleContaining(String name, String cookingStyle) ;

	// between�G���]�t�W�U�ɪ���
	public List<Meal> findByPriceBetween(int price1 , int price2) ;
	
	public List<Meal> findByPriceBetweenOrderByPrice(int price1 , int price2) ;

	// in
	public List<Meal> findByPriceIn(List<Integer> price) ;
	// notIn
	public List<Meal> findByPriceNotIn(List<Integer> price) ;
}
