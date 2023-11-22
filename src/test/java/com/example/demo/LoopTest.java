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
			System.out.println(""); // �����X
		}
	}

	@Test
	public void randomTest() {
		// �����G( �϶��W���� - �϶��U���� + 1 ) + �϶��U����
		// 1~99 �G( �϶��W���� = 99 �϶��U���� = 1 )
		double random = Math.random() * (99 - 1 + 1) + 1;
		// 20~50�G( �϶��W���� = 20 �϶��U���� = 50 )
		double random1 = Math.random() * (50 - 20 + 1) + 20;
		System.out.println("= = = = = = = = = = = = = = = = = = =");
		Random ran = new Random();
		// Random ���O�̪� nextInt (��� i ) �G�|���� 0~ �p���J��� i ����
		// ���� 1~99
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
			System.out.printf("�׷��K�X�j�D�ԡG�b %d~%d �����q�@�ӼƦr", min, max);
			int guessNum = scan.nextInt();
			if (guessNum > max || min > guessNum) {
				System.out.printf("�п�J %d~%d �����Ʀr", min, max);
				continue;
			}
			if (guessNum == pwd) {
				System.out.println("Bingo�I");
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
