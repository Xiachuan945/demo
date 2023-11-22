package com.example.demo;

import java.util.ArrayList;
import java.util.Scanner;

import org.assertj.core.util.Arrays;
import org.junit.jupiter.api.Test;
import org.springframework.util.StringUtils;

import com.example.demo.entity.Dog;

public class StringTest {

	@Test
	public void stringTest() {
		String str = "ABC";
		String str1 = new String("ABC");
		String str2 = "ABC";
		System.out.println(str == str1);
		System.out.println(str == str2);
		System.out.println("= = = = = = = =");
		System.out.println(str.equals(str1));
		System.out.println(str.equals(str2));
		System.out.println("= = = = = = = =");
		String str3 = "aBC";
		System.out.println(str.equals(str3));
		System.out.println(str.equalsIgnoreCase(str3));
	}

	@Test
	public void stringTest1() {
		String str = "ABC";
		String str1 = "";
		String str2 = "  ";
		System.out.println("str length : " + str.length());
		System.out.println("str1 length : " + str1.length());
		System.out.println("str2 length : " + str2.length());
		System.out.println("= = = = = = = =");
		// isEmpty�G�ݦr����׬O�_�� 0
		System.out.println("str1 isEmpty : " + str1.isEmpty());
		System.out.println("str2 isEmpty : " + str2.isEmpty());
		System.out.println("= = = = = = = =");
		// isBlank�G1. ���׬� 0 ; 2. �r�ꤺ�e�ѥ��ťղզ� ; �������� 1 or 2 �^�� true
		System.out.println("str1 isBlank : " + str1.isBlank());
		System.out.println("str2 isBlank : " + str2.isBlank());
	}

	@Test
	public void stringTest2() {
		Dog dog = new Dog();
		String name = dog.getName();
		String color = dog.getColor();
		System.out.println(name);
		System.out.println(color);
		System.out.println("= = = = = = = =");
		System.out.println(name.length());
//		System.out.println(color.length());
		System.out.println(color == null);
		System.out.println("= = = = = = = =");
		if (color == null || color.isBlank()) {
			System.out.println("color �O�Ŧr�� ! !");
		} else {
			System.out.println("color ���O�Ŧr��  ! !");
		}
		System.out.println("= = = = = = = =");
		System.out.println(StringUtils.hasLength("  "));
		System.out.println(StringUtils.hasText("  "));
		System.out.println("= = = = = = = =");
		color = "";
		if (color.isBlank()) {
			System.out.println("color �̨S�����e ! !");
		} else {
			System.out.println("color �̦����e  ! !");
		}
		System.out.println("= = = = = = = =");
		if (StringUtils.hasText(color)) {
			System.out.println("color �̦����e ! !");
		} else {
			System.out.println("color �̨S�����e  ! !");
		}
		System.out.println("= = = = = = = =");
		if (!StringUtils.hasText(color)) {
			System.out.println("color �̨S�����e ! !");
		} else {
			System.out.println("color �̦����e  ! !");
		}
	}

	@Test
	public void stringTest3() {
		String str = "����L�Q�O���L�P�p�s�k���G�ơA�ڤ����w�p�s�k���ҥP�A���M�p�s�k�b���L�����O�M�s��U";
		System.out.println("= = = = = = = =");
		System.out.println("�p�s�k�X�{�����ơG" + StringUtils.countOccurrencesOf(str, "�p�s�k"));
		System.out.println("�p�s�k�Ĥ@���X�{����m�G" + str.indexOf("�p�s�k"));
		System.out.println("= = = = = = = =");
		Scanner scan = new Scanner(System.in);
		String ans = scan.next(); // ans ����ʿ�J�n�䪺�r

		int index = 0; // �]�w���ޭȪ���l�Ȭ� index
		int count = 0; // �]�w�n�䪺���ƪ�l�Ȭ� count
		while (str.indexOf(ans, index) >= 0) {
			count = count + 1; // = count++ ; // ��쪺�ɭ� +1 �~���U�@�ӡF�䤣��|�^�� -1
			index = (str.indexOf(ans, index) + ans.length()); // .length���ؼЪ����סFindex �[�W�j�M�r�����
		}
		System.out.println(ans + "�X�{�����ơG" + count);
	}

	@Test
	public void replaceTest() {
		String str = "����L�Q�O���L�P�p�s�k���G�ơA�ڤ����w�p�s�k���ҥP�A" + "���M�p�s�k�b���L�����O�M�s��U";
		// replace()�G���N����
		str = str.replace("�p�s�k", "�pŢ�]"); // �u�p�s�k�v�������u�pŢ�]�v
		System.out.println(str);
		System.out.println("= = = = = = = =");
		// replaceAll�G���N����
		str = str.replaceAll("�pŢ�]", "�»��S");
		System.out.println(str);
	}

	@Test
	public void splitTest() {
		String str = "����L�Q�O���L�P�p�s�k���G�ơA�ڤ����w�p�s�k���ҥP�A" + "���M�p�s�k�b���L�����O�M�s��U";
		// split()�G�ھڵ��w�� regex (���W��F��)�ө���r��
		String[] array = str.split("�p�s�k"); // ��y��" "���r�|�]���}�Ӥ���
		for (String item : array) {
			System.out.println(item);
		}
		System.out.println("= = = = = = = =");
		String str1 = "ABCD";
		String[] array1 = str1.split("");
		for (String item : array1) {
			System.out.println(item);
		}
	}

	@Test
	public void trimTest() {
		String str = "ABC  DEF G";
		String str1 = " ABC DEF ";
		System.out.println(str == str1);
		System.out.println(str.equals(str1));
		System.out.println("= = = = = = = =");
		// trim( )�G�R���r��e��ť�
		str = str.trim();
		str1 = str1.trim();
		System.out.println(str);
		System.out.println(str1);
		System.out.println(str == str1);
		System.out.println(str.equals(str1));
		System.out.println("= = = = = = = =");
		str = str.replace(" ", "");
		System.out.println(str);
	}

	@Test
	public void substringTest() {
		String str = "����L�Q�O���L�P�p�s�k���G��";
		// substring()�G�^����ӯ��ަ�m�������r��A���ަ�m�q 0 �}�l
		String subStr = str.substring(5);
		String subStr1 = str.substring(5, 11);
		System.out.println(subStr);
		System.out.println(subStr1);
	}

	@Test
	public void stringBufferTest() {
		StringBuffer sb = new StringBuffer("ABC");
		// append�G�l�[ int �Ѽƨ즹�ǦC���r��
		sb.append("DEF");
		sb.append("> <");
		sb.append("Harry").append("Potter");
		System.out.println(sb);
		System.out.println("= = = = = = = =");
		String str = "ABC" + "DEF" + "> <" + "Harry" + "Potter";
		System.out.println(str);
	}

	@Test
	public void stringBufferTest1() {
		StringBuffer sb = new StringBuffer("ABC");
		StringBuffer sb1 = new StringBuffer("ABC");
		System.out.println(sb.equals(sb1));
		System.out.println("= = = = = = = =");
		// toString( )�G�ഫ���r��
		System.out.println(sb.toString().equals(sb1.toString()));
	}

	@Test
	public void replaceTest1() {
		String str = "ABACADEF";
		int index = 4;             // �������Ȭ����� 4 �� a
		String str1 = str.substring(0, index) + 'W' + str.substring(index + 1);
		System.out.println(str1);
		System.out.println("= = = = = = = =");
		int index1 = str.lastIndexOf("A");                    // index = 4
		String lastString = str.substring(index1);      // lastString = ADEF
		lastString = lastString.replace("A", "W");      // lastString = WDEF
		str = str.substring(0, index1) + lastString;     // ABAC + WDEF
		System.out.println(str1);
	}

	@Test
	public void replaceTest2() {
		String str = "ABACADEF" ;
		int index = str.lastIndexOf("A") ;
		StringBuffer sb = new StringBuffer(str) ;
//		sb.setCharAt(index, "W") ;
		System.out.println(sb.toString());
	}

	@Test
	public void stringBufferTest2() {
		Scanner scan = new Scanner(System.in);
		System.out.println("�п�J��r");
		String ans = scan.next();
		StringBuffer sb = new StringBuffer(ans);
		// ���e����A�ϥ� equals
		if (ans.equals(sb.reverse().toString())) {
			System.out.println(ans + "�O�j�� ! ");
		} else
			System.out.println(ans + "���O�j�� ! ! ");
	}

	@Test
	public void stringBufferTest3() {
		Scanner scan = new Scanner(System.in);
		for ( ; ; ) {
			System.out.println("�п�J�ܤ�2�ӥH�W����r");
			String ans = scan.next();
			if (ans.length() <= 2) {
				System.out.println("�A�դ@�� !");
				continue;
			}
			StringBuffer sb = new StringBuffer(ans);
			if (ans.equals(sb.reverse().toString())) {
				System.out.println(ans + "�O�j�� ! ");
			} else {
				System.out.println(ans + "���O�j�� ! ! ");
			}
			break;
		}
	}
	
	@Test
	public void listTest() {
		Scanner scan = new Scanner(System.in);
		System.out.println("�п�J�@�ӼƦr");
		int inputInt = scan.nextInt();
		inputInt ++ ;
		String str = String.valueOf(inputInt) ; 
		String [ ] strArray = str.split("") ;
		System.out.println(new ArrayList <>(Arrays.asList(strArray)));
	}
}