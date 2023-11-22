package com.example.demo;

import java.util.List;
import java.util.Scanner;

import org.junit.jupiter.api.Test;

public class ConditionTest {

	@Test
	public void ifTest() {
		int a = 5;
		if (a > 5) {
			System.out.println("true");
		} else {
			System.out.println("false");
		}
	}

	@Test
	public void ifTest1() {
		int a = 5;
		if (a > 5) {
			System.out.println("apple");
		} else if (a < 5) {
			System.out.println("banana");
		} else {
			System.out.println("coconut");
		}
	}

	@Test
	public void switchTest() {
		int a = 95;
		int b = 95 / 10;
		double c = 95 / 10.0;
		System.out.println("b:" + b);
		System.out.println("c:" + c);
	}

	@Test
	public void ScannerTest() {
		Scanner scan = new Scanner(System.in);
		System.out.println("請輸入文字：");
		String a = scan.next();
		System.out.println("輸入的文字是：" + a);
	}

	@Test
	public void ScannerTest1() {
		Scanner scan = new Scanner(System.in);
		System.out.println("請輸入文字：");
		String a = scan.next();
		String b = scan.next();
		System.out.println("輸入的文字是：" + a + b);
	}

	@Test
	public void ScannerTest2() {
		Scanner scan = new Scanner(System.in);
		System.out.println("請輸入文字：");
		String a = scan.nextLine();
		System.out.println("輸入的文字是：" + a);
	}

	@Test
	public void ScannerTest3() {
		Scanner scan = new Scanner(System.in);
		System.out.println("請輸入數字：");
		int a = scan.nextInt();
		System.out.println("輸入的數字是：" + a);
	}

	@Test
	public void switchTest1() {
		Scanner scan = new Scanner(System.in);
		System.out.println("請輸入成績：");
		int input = scan.nextInt();
		switch (input / 10) {
		case 10:
		case 9:
			System.out.println("A");
			break;
		case 8:
			System.out.println("B");
			break;
		case 7:
			System.out.println("C");
			break;
		default:
			System.out.println("D");
		}
	}

	// switchTest2 麥當勞打工

	@Test
	public void switchTest3() {
		Scanner scan = new Scanner(System.in);
		System.out.println("今天是星期幾：");
		String inputStr = scan.next();
		int weekday = 0;
//		String[ ] strArray = { "日", "天", "一", "二", "三", "四", "五", "六" };
		switch (inputStr) { // 中文轉換為數字(例：日→7)
		case "日":
		case "天":
			weekday = 7;
			break;
		case "六":
			weekday = 6;
			break;
		case "五":
			weekday = 5;
			break;
		case "四":
			weekday = 4;
			break;
		case "三":
			weekday = 3;
			break;
		case "二":
			weekday = 2;
			break;
		case "一":
			weekday = 1;
			break;
		}
		System.out.println("請輸入幾天後的天數：");
		int days = scan.nextInt();
		switch ((weekday + days) % 7) { // %s：字串 、%d：數字
		case 0:
			System.out.printf("今天是星期%s,%d天後是星期天", inputStr, days);
			break;
		case 1:
			System.out.printf("今天是星期%s,%d天後是星期一", inputStr, days);
			break;
		case 2:
			System.out.printf("今天是星期%s,%d天後是星期二", inputStr, days);
			break;
		case 3:
			System.out.printf("今天是星期%s,%d天後是星期三", inputStr, days);
			break;
		case 4:
			System.out.printf("今天是星期%s,%d天後是星期四", inputStr, days);
			break;
		case 5:
			System.out.printf("今天是星期%s,%d天後是星期五", inputStr, days);
			break;
		case 6:
			System.out.printf("今天是星期%s,%d天後是星期六", inputStr, days);
			break;
		}
	}

	@Test
	public void switchTest4() {
		Scanner scan = new Scanner(System.in);
		System.out.println("今天是星期幾：");
		int inputInt = scan.nextInt();
		String weekday = "日";
		switch (inputInt) { // 數字轉換為中文(例：7→日)
		case 6:
			weekday = "六";
			break;
		case 5:
			weekday = "五";
			break;
		case 4:
			weekday = "四";
			break;
		case 3:
			weekday = "三";
			break;
		case 2:
			weekday = "二";
			break;
		case 1:
			weekday = "一";
			break;
		}
		System.out.println("請輸入幾天後的天數：");
		int days = scan.nextInt();
		switch ((inputInt + days) % 7) {
		case 0:
			System.out.printf("今天是星期%s,%d天後是星期天", weekday, days);
			break;
		case 1:
			System.out.printf("今天是星期%s,%d天後是星期一", weekday, days);
			break;
		case 2:
			System.out.printf("今天是星期%s,%d天後是星期二", weekday, days);
			break;
		case 3:
			System.out.printf("今天是星期%s,%d天後是星期三", weekday, days);
			break;
		case 4:
			System.out.printf("今天是星期%s,%d天後是星期四", weekday, days);
			break;
		case 5:
			System.out.printf("今天是星期%s,%d天後是星期五", weekday, days);
			break;
		case 6:
			System.out.printf("今天是星期%s,%d天後是星期六", weekday, days);
			break;
		}

	}

	@Test
	// 主程式
	public void switchTest5() {
		Scanner scan = new Scanner(System.in);
		System.out.println("今天是星期幾：");
		int inputInt = scan.nextInt();
		String weekday = switchDay(inputInt);
		System.out.println("請輸入幾天後的天數：");
		int days = scan.nextInt();
		String output = switchDay((inputInt + days) % 7);
		System.out.printf("今天是星期%s,%d天後是星期%s", weekday, days, output);
	}

	// 子程式
	// 將原本 void 型態更改為 String ，將方法給予參數inputInt，給予資料型態 int
	public String switchDay(int inputInt) {
		String weekday = "";
		switch (inputInt) {
		case 0:
			weekday = "日";
			break;
		case 6:
			weekday = "六";
			break;
		case 5:
			weekday = "五";
			break;
		case 4:
			weekday = "四";
			break;
		case 3:
			weekday = "三";
			break;
		case 2:
			weekday = "二";
			break;
		case 1:
			weekday = "一";
			break;
		}
		// return 回傳方法中自己設定的字串 weekday
		return weekday;
	}
}
