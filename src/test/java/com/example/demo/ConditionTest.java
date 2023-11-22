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
		System.out.println("�п�J��r�G");
		String a = scan.next();
		System.out.println("��J����r�O�G" + a);
	}

	@Test
	public void ScannerTest1() {
		Scanner scan = new Scanner(System.in);
		System.out.println("�п�J��r�G");
		String a = scan.next();
		String b = scan.next();
		System.out.println("��J����r�O�G" + a + b);
	}

	@Test
	public void ScannerTest2() {
		Scanner scan = new Scanner(System.in);
		System.out.println("�п�J��r�G");
		String a = scan.nextLine();
		System.out.println("��J����r�O�G" + a);
	}

	@Test
	public void ScannerTest3() {
		Scanner scan = new Scanner(System.in);
		System.out.println("�п�J�Ʀr�G");
		int a = scan.nextInt();
		System.out.println("��J���Ʀr�O�G" + a);
	}

	@Test
	public void switchTest1() {
		Scanner scan = new Scanner(System.in);
		System.out.println("�п�J���Z�G");
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

	// switchTest2 ����ҥ��u

	@Test
	public void switchTest3() {
		Scanner scan = new Scanner(System.in);
		System.out.println("���ѬO�P���X�G");
		String inputStr = scan.next();
		int weekday = 0;
//		String[ ] strArray = { "��", "��", "�@", "�G", "�T", "�|", "��", "��" };
		switch (inputStr) { // �����ഫ���Ʀr(�ҡG���7)
		case "��":
		case "��":
			weekday = 7;
			break;
		case "��":
			weekday = 6;
			break;
		case "��":
			weekday = 5;
			break;
		case "�|":
			weekday = 4;
			break;
		case "�T":
			weekday = 3;
			break;
		case "�G":
			weekday = 2;
			break;
		case "�@":
			weekday = 1;
			break;
		}
		System.out.println("�п�J�X�ѫ᪺�ѼơG");
		int days = scan.nextInt();
		switch ((weekday + days) % 7) { // %s�G�r�� �B%d�G�Ʀr
		case 0:
			System.out.printf("���ѬO�P��%s,%d�ѫ�O�P����", inputStr, days);
			break;
		case 1:
			System.out.printf("���ѬO�P��%s,%d�ѫ�O�P���@", inputStr, days);
			break;
		case 2:
			System.out.printf("���ѬO�P��%s,%d�ѫ�O�P���G", inputStr, days);
			break;
		case 3:
			System.out.printf("���ѬO�P��%s,%d�ѫ�O�P���T", inputStr, days);
			break;
		case 4:
			System.out.printf("���ѬO�P��%s,%d�ѫ�O�P���|", inputStr, days);
			break;
		case 5:
			System.out.printf("���ѬO�P��%s,%d�ѫ�O�P����", inputStr, days);
			break;
		case 6:
			System.out.printf("���ѬO�P��%s,%d�ѫ�O�P����", inputStr, days);
			break;
		}
	}

	@Test
	public void switchTest4() {
		Scanner scan = new Scanner(System.in);
		System.out.println("���ѬO�P���X�G");
		int inputInt = scan.nextInt();
		String weekday = "��";
		switch (inputInt) { // �Ʀr�ഫ������(�ҡG7����)
		case 6:
			weekday = "��";
			break;
		case 5:
			weekday = "��";
			break;
		case 4:
			weekday = "�|";
			break;
		case 3:
			weekday = "�T";
			break;
		case 2:
			weekday = "�G";
			break;
		case 1:
			weekday = "�@";
			break;
		}
		System.out.println("�п�J�X�ѫ᪺�ѼơG");
		int days = scan.nextInt();
		switch ((inputInt + days) % 7) {
		case 0:
			System.out.printf("���ѬO�P��%s,%d�ѫ�O�P����", weekday, days);
			break;
		case 1:
			System.out.printf("���ѬO�P��%s,%d�ѫ�O�P���@", weekday, days);
			break;
		case 2:
			System.out.printf("���ѬO�P��%s,%d�ѫ�O�P���G", weekday, days);
			break;
		case 3:
			System.out.printf("���ѬO�P��%s,%d�ѫ�O�P���T", weekday, days);
			break;
		case 4:
			System.out.printf("���ѬO�P��%s,%d�ѫ�O�P���|", weekday, days);
			break;
		case 5:
			System.out.printf("���ѬO�P��%s,%d�ѫ�O�P����", weekday, days);
			break;
		case 6:
			System.out.printf("���ѬO�P��%s,%d�ѫ�O�P����", weekday, days);
			break;
		}

	}

	@Test
	// �D�{��
	public void switchTest5() {
		Scanner scan = new Scanner(System.in);
		System.out.println("���ѬO�P���X�G");
		int inputInt = scan.nextInt();
		String weekday = switchDay(inputInt);
		System.out.println("�п�J�X�ѫ᪺�ѼơG");
		int days = scan.nextInt();
		String output = switchDay((inputInt + days) % 7);
		System.out.printf("���ѬO�P��%s,%d�ѫ�O�P��%s", weekday, days, output);
	}

	// �l�{��
	// �N�쥻 void ���A��אּ String �A�N��k�����Ѽ�inputInt�A������ƫ��A int
	public String switchDay(int inputInt) {
		String weekday = "";
		switch (inputInt) {
		case 0:
			weekday = "��";
			break;
		case 6:
			weekday = "��";
			break;
		case 5:
			weekday = "��";
			break;
		case 4:
			weekday = "�|";
			break;
		case 3:
			weekday = "�T";
			break;
		case 2:
			weekday = "�G";
			break;
		case 1:
			weekday = "�@";
			break;
		}
		// return �^�Ǥ�k���ۤv�]�w���r�� weekday
		return weekday;
	}
}
