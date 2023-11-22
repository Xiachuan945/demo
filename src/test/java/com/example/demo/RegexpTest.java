package com.example.demo;

import java.util.Scanner;

import org.junit.jupiter.api.Test;

public class RegexpTest {
	
	@Test
	public void regexpTest() {
		String str = "0912-345-678" ;
		String pattern = "\\d\\d\\d\\d-\\d\\d\\d-\\d\\d\\d" ;
		System.out.println(str.matches(pattern)) ;		
		System.out.println("= = = = = = = = ");		
		String pattern2 = "\\d{4}-\\d{3}-\\d{3}" ;
		System.out.println(str.matches(pattern2)) ;
		System.out.println("= = = = = = = = ");		
		String pattern3 = "\\d{4}(-\\d{3}){2}" ;
		System.out.println(str.matches(pattern3)) ;
	}
	
	@Test
	public void regexpTest2() {
		String pattern_x = "(\\d{2})\\d(8} " ;               // 格式：2 碼 8 碼，不包含小括號；小括號分組用
		String pattern_y = "\\(\\d{2}\\)\\d(8} " ;      // 格式：(2 碼) 8 碼，包含小括號
		System.out.println("= = = = = = = =");
		String pattern = "\\(\\d{2}\\)\\d(7} " ;          // 格式：(2 碼) 7 碼，包含小括號
		String pattern1 = "\\(\\d{2}\\)\\d(8} " ;        // 格式：(2 碼) 8 碼，包含小括號
		String pattern2 = "\\d{2}-\\d(7} " ;                   // 格式：2 碼 -  7 碼
		String pattern3 = "\\d{2}-\\d(8} " ;                   // 格式：2 碼 -  8 碼
		Scanner scan = new Scanner(System.in);
		System.out.println("請輸入電話號碼：");
		System.out.println("電話格式為：(區域2碼)電話號碼7碼或8碼：");
		System.out.println("電話格式為：區域2碼-電話號碼7碼或8碼：");
		String input = scan.next();
		if(input.matches(pattern) ||  input.matches(pattern1) ||  input.matches(pattern2) || input.matches(pattern3)) {
			System.out.println( input + "符合格式 ! ");
		} else {
			System.out.println( input + "不符合格式! !");
		} 
	}	
	
	@Test
	public void regexpTest3() {
		String pattern0 = "\\(\\d{2}\\)\\d(7} " ;        // 格式：(2 碼) 7 碼，包含小括號
		String pattern1 = "\\(\\d{2}\\)\\d(8} " ;        // 格式：(2 碼) 8 碼，包含小括號
		// 以下是將 pattern0 和 pattern1 整合一起，擇一使用
		String patternA = "\\(\\d{2}\\)\\d{7}||\\(\\\\d{2}\\)\\d{8})" ;        // (02)1234567 or (02)12345678
		String patternB = "\\(\\d{2}\\)(\\d{7}||\\d{8})" ;                                   // (02)1234567 or (02)12345678
		String patternC = "\\(\\d{2}\\)\\d{7,8}" ;                                                 // (02)1234567 or (02)12345678
		
		String pattern2 = "\\d{2}-\\d(7} " ;                   // 格式：2 碼 -  7 碼
		String pattern3 = "\\d{2}-\\d(8} " ;                   // 格式：2 碼 -  8 碼
		// 將 pattern2 和 pattern3 整合成 patternD
		String patternD = "\\d{2}-\\d{7,8}" ;       
		// 將 patternC 和 patternD 整合
		String patternE = "(\\(\\d{2}\\)||\\d{2}-)\\d{7,8}" ;  

		Scanner scan = new Scanner(System.in);
		System.out.println("請輸入電話號碼：");
		System.out.println("電話格式為：(區域2碼)電話號碼7碼或8碼：");
		System.out.println("電話格式為：區域2碼-電話號碼7碼或8碼：");
		String input = scan.next();
		if(input.matches(patternE)) {
			System.out.println( input + "符合格式 ! ");
		} else {
			System.out.println( input + "不符合格式! !");
		} 
	}	
	
	@Test
	public void regexpTest4() {
		String str1 = "ABC " ; 
		String str2 = "MVP" ;
		String pattern= "^ [A-Za-z]" ; 
		System.out.println(str1.matches(pattern)) ;
		System.out.println(str2.matches(pattern)) ;
		String pattern2= " [A-Za-z] P$" ; 
		System.out.println(str1.matches(pattern2)) ;
		System.out.println(str2.matches(pattern2)) ;
	}
	
	@Test
	public void regexpTest5() {
		String str = "a" ;
		String str1 = "AB" ;
		// 「\\w」占用一個字元，但範圍限縮在 [ A-Za-z0-9 ]
		String pattern= "\\w" ; 
		String pattern1= "\\w." ;       //「.」：除換行符號(\n)之外的其他所有字元，但只占一個字元
		String pattern2= "\\w.*" ;    // 「.*」： 0~多個字元，後面字元可有可無
		System.out.println(str.matches(pattern)) ;
		System.out.println(str1.matches(pattern)) ;
		System.out.println("= = = = = =");
		System.out.println(str.matches(pattern1)) ;
		System.out.println(str1.matches(pattern1)) ;
		System.out.println("= = = = = =");
		System.out.println(str.matches(pattern2)) ;
		System.out.println(str1.matches(pattern2)) ;
	}
	
	@Test
	public void regexpTest6() {
		String str = " Hello~Java, I love Java !" ;
		String pattern = "Java" ;
		String pattern2 = "Python" ;
		System.out.println(str.replaceFirst(pattern, pattern2)) ;
		System.out.println("= = = = = =");
		System.out.println(str.replaceAll(pattern, pattern2)) ;
		System.out.println("= = = = = =");
		pattern = ".*(Java).*" ;
		System.out.println(str.replaceFirst(pattern, pattern2)) ;
	}
	
	@Test
	public void idcheckTest() {
		String pattern = "[A-Za-z][1-2]\\d{8}" ;
		Scanner scan = new Scanner(System.in);
		System.out.println("請輸入身份證字號") ;
		System.out.println("格式：第1碼為英文，後9碼為數字") ;
		String input = scan.next() ;
		if( input.matches(pattern)) {
			System.out.println("身分證字號輸入正確");
		} else {
			System.out.println("輸入錯誤，請再輸入一次");
		} 
	}
	
	@Test
	public void idcheckTest2() {
		String pattern = "([A-Za-z&&[^ABDEFHabdefh]])[1-2]\\d{8}" ;
		Scanner scan = new Scanner(System.in);
		System.out.println("請輸入身份證字號") ;
		System.out.println("格式：第1碼為英文，後9碼為數字") ;
		String input = scan.next() ;
		if( input.matches(pattern)) {
			System.out.println("身分證字號輸入正確");
		} else {
			System.out.println("輸入錯誤，請再輸入一次");
		} 
	}
}
