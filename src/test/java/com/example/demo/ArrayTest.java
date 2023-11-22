package com.example.demo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

public class ArrayTest {

	@Test
	public void arrayTest() {
		int[] a = new int[5]; // new 類別：給一個記憶體空間
		System.out.println(a);
		System.out.println(a.length);
		a[0] = 3; // 把 1 放到陣列 a 的第 0 個位置
		a[1] = 6;
		a[2] = 9;
		System.out.println(a);
		System.out.println("= = = = = = = = =");
		// 宣告的同時，給予初始值
		int[] b = { 1, 3, 5, 7, 9 };
		System.out.println(b[4]);
	}

	@Test
	public void listTest() {
		List<String> strList = new ArrayList<>();
		// List 是有順序的，依照加入的先後順序排序
		strList.add("S");
		strList.add("O");
		strList.add("N");
		strList.add("Y");
		System.out.println(strList);
		System.out.println("= = = = = = = =");
		System.out.println(strList.size());
		System.out.println("= = = = = = = =");
		for (int i = 0; i < strList.size(); i++) {
			System.out.println(strList.get(i));
		}
		System.out.println("= = = = = = = =");

		List<String> strList1 = List.of("M", "U", "J", "I");
		List<String> strList2 = Arrays.asList("P", "O", "Y", "A");
		// 執行下一行程式會報錯，因為用 List.of ( ) 產生的 List 大小固定，無法再增刪
//		strList1.add("plus");
		// 執行下一行程式會報錯，因為用 Arrays.asList ( ) 產生的 List 大小固定，無法再增刪
//		strList2.add("plus");
		System.out.println("= = = = = = = =");
		
		// ArrayList<>( ) 後面的空間是動態的，故可以用 strList.add( ) 新增至list中
		List<String> strList3 = new ArrayList<>(List.of("M", "U", "J", "I"));
		List<String> strList4 = new ArrayList<>(Arrays.asList("P", "O", "Y", "A"));
	}
	
	@Test
	public void foreachTest() {
		List<String> strList = new ArrayList<>(List.of("Z", "A", "R", "A"));
		for (int i = 0; i < strList.size(); i++) {
			System.out.println(strList.get(i));
		}
		System.out.println("= = = = = = = =");
		// foreach：遍歷。將 List 裡的每個項目從頭到尾一個一個取出
		// for ( 資料作用型態 變數_要取的每一項 : 要取出的 list 對象 ) { }
		for(String item : strList) {
			System.out.println(item);
		};
		System.out.println("= = = = = = = =");

		strList.forEach(item ->{
			System.out.println(item);
		});
	}
	
	@Test
	public void listTest1() {
		int a = 5;
		int [ ] b = new int[5] ;
		System.out.println(a);
		System.out.println(b);
	}
	
	@Test
	public void listTest2() {
		int a = 5;
		int [ ] b = new int[5] ;
		System.out.println(a);
		System.out.println(b);
	}
}
