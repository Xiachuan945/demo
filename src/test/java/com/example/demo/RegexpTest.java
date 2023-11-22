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
		String pattern_x = "(\\d{2})\\d(8} " ;               // �榡�G2 �X 8 �X�A���]�t�p�A���F�p�A�����ե�
		String pattern_y = "\\(\\d{2}\\)\\d(8} " ;      // �榡�G(2 �X) 8 �X�A�]�t�p�A��
		System.out.println("= = = = = = = =");
		String pattern = "\\(\\d{2}\\)\\d(7} " ;          // �榡�G(2 �X) 7 �X�A�]�t�p�A��
		String pattern1 = "\\(\\d{2}\\)\\d(8} " ;        // �榡�G(2 �X) 8 �X�A�]�t�p�A��
		String pattern2 = "\\d{2}-\\d(7} " ;                   // �榡�G2 �X -  7 �X
		String pattern3 = "\\d{2}-\\d(8} " ;                   // �榡�G2 �X -  8 �X
		Scanner scan = new Scanner(System.in);
		System.out.println("�п�J�q�ܸ��X�G");
		System.out.println("�q�ܮ榡���G(�ϰ�2�X)�q�ܸ��X7�X��8�X�G");
		System.out.println("�q�ܮ榡���G�ϰ�2�X-�q�ܸ��X7�X��8�X�G");
		String input = scan.next();
		if(input.matches(pattern) ||  input.matches(pattern1) ||  input.matches(pattern2) || input.matches(pattern3)) {
			System.out.println( input + "�ŦX�榡 ! ");
		} else {
			System.out.println( input + "���ŦX�榡! !");
		} 
	}	
	
	@Test
	public void regexpTest3() {
		String pattern0 = "\\(\\d{2}\\)\\d(7} " ;        // �榡�G(2 �X) 7 �X�A�]�t�p�A��
		String pattern1 = "\\(\\d{2}\\)\\d(8} " ;        // �榡�G(2 �X) 8 �X�A�]�t�p�A��
		// �H�U�O�N pattern0 �M pattern1 ��X�@�_�A�ܤ@�ϥ�
		String patternA = "\\(\\d{2}\\)\\d{7}||\\(\\\\d{2}\\)\\d{8})" ;        // (02)1234567 or (02)12345678
		String patternB = "\\(\\d{2}\\)(\\d{7}||\\d{8})" ;                                   // (02)1234567 or (02)12345678
		String patternC = "\\(\\d{2}\\)\\d{7,8}" ;                                                 // (02)1234567 or (02)12345678
		
		String pattern2 = "\\d{2}-\\d(7} " ;                   // �榡�G2 �X -  7 �X
		String pattern3 = "\\d{2}-\\d(8} " ;                   // �榡�G2 �X -  8 �X
		// �N pattern2 �M pattern3 ��X�� patternD
		String patternD = "\\d{2}-\\d{7,8}" ;       
		// �N patternC �M patternD ��X
		String patternE = "(\\(\\d{2}\\)||\\d{2}-)\\d{7,8}" ;  

		Scanner scan = new Scanner(System.in);
		System.out.println("�п�J�q�ܸ��X�G");
		System.out.println("�q�ܮ榡���G(�ϰ�2�X)�q�ܸ��X7�X��8�X�G");
		System.out.println("�q�ܮ榡���G�ϰ�2�X-�q�ܸ��X7�X��8�X�G");
		String input = scan.next();
		if(input.matches(patternE)) {
			System.out.println( input + "�ŦX�榡 ! ");
		} else {
			System.out.println( input + "���ŦX�榡! !");
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
		// �u\\w�v�e�Τ@�Ӧr���A���d���Y�b [ A-Za-z0-9 ]
		String pattern= "\\w" ; 
		String pattern1= "\\w." ;       //�u.�v�G������Ÿ�(\n)���~����L�Ҧ��r���A���u�e�@�Ӧr��
		String pattern2= "\\w.*" ;    // �u.*�v�G 0~�h�Ӧr���A�᭱�r���i���i�L
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
		System.out.println("�п�J�����Ҧr��") ;
		System.out.println("�榡�G��1�X���^��A��9�X���Ʀr") ;
		String input = scan.next() ;
		if( input.matches(pattern)) {
			System.out.println("�����Ҧr����J���T");
		} else {
			System.out.println("��J���~�A�ЦA��J�@��");
		} 
	}
	
	@Test
	public void idcheckTest2() {
		String pattern = "([A-Za-z&&[^ABDEFHabdefh]])[1-2]\\d{8}" ;
		Scanner scan = new Scanner(System.in);
		System.out.println("�п�J�����Ҧr��") ;
		System.out.println("�榡�G��1�X���^��A��9�X���Ʀr") ;
		String input = scan.next() ;
		if( input.matches(pattern)) {
			System.out.println("�����Ҧr����J���T");
		} else {
			System.out.println("��J���~�A�ЦA��J�@��");
		} 
	}
}
