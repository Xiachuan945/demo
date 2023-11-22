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
		// isEmpty：看字串長度是否為 0
		System.out.println("str1 isEmpty : " + str1.isEmpty());
		System.out.println("str2 isEmpty : " + str2.isEmpty());
		System.out.println("= = = = = = = =");
		// isBlank：1. 長度為 0 ; 2. 字串內容由全空白組成 ; 滿足條件 1 or 2 回傳 true
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
			System.out.println("color 是空字串 ! !");
		} else {
			System.out.println("color 不是空字串  ! !");
		}
		System.out.println("= = = = = = = =");
		System.out.println(StringUtils.hasLength("  "));
		System.out.println(StringUtils.hasText("  "));
		System.out.println("= = = = = = = =");
		color = "";
		if (color.isBlank()) {
			System.out.println("color 裡沒有內容 ! !");
		} else {
			System.out.println("color 裡有內容  ! !");
		}
		System.out.println("= = = = = = = =");
		if (StringUtils.hasText(color)) {
			System.out.println("color 裡有內容 ! !");
		} else {
			System.out.println("color 裡沒有內容  ! !");
		}
		System.out.println("= = = = = = = =");
		if (!StringUtils.hasText(color)) {
			System.out.println("color 裡沒有內容 ! !");
		} else {
			System.out.println("color 裡有內容  ! !");
		}
	}

	@Test
	public void stringTest3() {
		String str = "神鵰俠侶是楊過與小龍女的故事，我不喜歡小龍女的甲仙，雖然小龍女在楊過眼中是清新脫俗";
		System.out.println("= = = = = = = =");
		System.out.println("小龍女出現的次數：" + StringUtils.countOccurrencesOf(str, "小龍女"));
		System.out.println("小龍女第一次出現的位置：" + str.indexOf("小龍女"));
		System.out.println("= = = = = = = =");
		Scanner scan = new Scanner(System.in);
		String ans = scan.next(); // ans 為手動輸入要找的字

		int index = 0; // 設定索引值的初始值為 index
		int count = 0; // 設定要找的次數初始值為 count
		while (str.indexOf(ans, index) >= 0) {
			count = count + 1; // = count++ ; // 找到的時候 +1 繼續找下一個；找不到會回傳 -1
			index = (str.indexOf(ans, index) + ans.length()); // .length為目標的長度；index 加上搜尋字串長度
		}
		System.out.println(ans + "出現的次數：" + count);
	}

	@Test
	public void replaceTest() {
		String str = "神鵰俠侶是楊過與小龍女的故事，我不喜歡小龍女的甲仙，" + "雖然小龍女在楊過眼中是清新脫俗";
		// replace()：取代全部
		str = str.replace("小龍女", "小籠包"); // 「小龍女」替換成「小籠包」
		System.out.println(str);
		System.out.println("= = = = = = = =");
		// replaceAll：取代全部
		str = str.replaceAll("小籠包", "麻辣燙");
		System.out.println(str);
	}

	@Test
	public void splitTest() {
		String str = "神鵰俠侶是楊過與小龍女的故事，我不喜歡小龍女的甲仙，" + "雖然小龍女在楊過眼中是清新脫俗";
		// split()：根據給定的 regex (正規表達式)來拆分字串
		String[] array = str.split("小龍女"); // 原句中" "的字會因切開而不見
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
		// trim( )：刪除字串前後空白
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
		String str = "神鵰俠侶是楊過與小龍女的故事";
		// substring()：擷取兩個索引位置之間的字串，索引位置從 0 開始
		String subStr = str.substring(5);
		String subStr1 = str.substring(5, 11);
		System.out.println(subStr);
		System.out.println(subStr1);
	}

	@Test
	public void stringBufferTest() {
		StringBuffer sb = new StringBuffer("ABC");
		// append：追加 int 參數到此序列的字串
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
		// toString( )：轉換成字串
		System.out.println(sb.toString().equals(sb1.toString()));
	}

	@Test
	public void replaceTest1() {
		String str = "ABACADEF";
		int index = 4;             // 替換的值為索引 4 → a
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
		System.out.println("請輸入文字");
		String ans = scan.next();
		StringBuffer sb = new StringBuffer(ans);
		// 內容比較，使用 equals
		if (ans.equals(sb.reverse().toString())) {
			System.out.println(ans + "是迴文 ! ");
		} else
			System.out.println(ans + "不是迴文 ! ! ");
	}

	@Test
	public void stringBufferTest3() {
		Scanner scan = new Scanner(System.in);
		for ( ; ; ) {
			System.out.println("請輸入至少2個以上的文字");
			String ans = scan.next();
			if (ans.length() <= 2) {
				System.out.println("再試一次 !");
				continue;
			}
			StringBuffer sb = new StringBuffer(ans);
			if (ans.equals(sb.reverse().toString())) {
				System.out.println(ans + "是迴文 ! ");
			} else {
				System.out.println(ans + "不是迴文 ! ! ");
			}
			break;
		}
	}
	
	@Test
	public void listTest() {
		Scanner scan = new Scanner(System.in);
		System.out.println("請輸入一個數字");
		int inputInt = scan.nextInt();
		inputInt ++ ;
		String str = String.valueOf(inputInt) ; 
		String [ ] strArray = str.split("") ;
		System.out.println(new ArrayList <>(Arrays.asList(strArray)));
	}
}