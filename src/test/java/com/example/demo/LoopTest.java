package com.example.demo;

import java.util.Random;
import java.util.Random.*;

import java.util.Scanner;

import org.junit.jupiter.api.Test;

public class LoopTest {

	@Test
	public void loopTest() {
		System.out.println("= = = = = = = = ");
		for (int i = 1; i < 5; i++) {
			System.out.println("i=" + i);
		}
		System.out.println("= = = = = = = = ");
		for (int i = 1; i < 5; i++) {
			System.out.println("i=" + i);
		}
	}

	@Test
	public void loopTest2() {
		a: for (int i = 1; i <= 9; i++) {
			for (int j = 1; j <= 9; j++) {
				if (j == 2) {
					break a;
				}
				System.out.printf("%d*%d=%2d\t", i, j, i * j);
			}
			System.out.println(""); // 換行輸出
		}
	}

	@Test
	public void randomTest() {
		// 公式：( 區間上限值 - 區間下限值 + 1 ) + 區間下限值
		// 1~99 ：( 區間上限值 = 99 區間下限值 = 1 )
		double random = Math.random() * (99 - 1 + 1) + 1;
		// 20~50：( 區間上限值 = 20 區間下限值 = 50 )
		double random1 = Math.random() * (50 - 20 + 1) + 20;
		System.out.println("= = = = = = = = = = = = = = = = = = =");
		Random ran = new Random();
		// Random 類別裡的 nextInt (整數 i ) ：會產生 0~ 小於輸入整數 i 的值
		// 產生 1~99
		int a = ran.nextInt(99) + 1;
		System.out.println("a="+a);
//		int b = ran.nextInt(20,30);
//		System.out.println("b="+b);


	}

	@Test
	public void guessTest() {
		Scanner scan = new Scanner(System.in);
		Random ran = new Random();
		int pwd = ran.nextInt(99) + 1;
		int min = 1;
		int max = 99;
		while (true) {
			System.out.printf("終極密碼大挑戰：在 %d~%d 之間猜一個數字", min, max);
			int guessNum = scan.nextInt();
			if (guessNum > max || min > guessNum) {
				System.out.printf("請輸入 %d~%d 內的數字", min, max);
				continue;
			}
			if (guessNum == pwd) {
				System.out.println("Bingo！");
				break;
			}
			if (guessNum > pwd) {
				max = guessNum;
			} else {
				min = guessNum;
			} 
		}
	}

}
