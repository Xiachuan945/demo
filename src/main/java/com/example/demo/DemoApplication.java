package com.example.demo;

import java.util.Scanner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);

		// �ù���J
		Scanner scan = new Scanner(System.in);
		int x, y;
		String str;
		x = scan.nextInt();
		y = scan.nextInt();
		str = scan.next();        // �r��
		System.out.println(x + "\t" + y + "\t" + str);

//		System.out.println( ) �ֱ���G syso + alt + ?
		// Cctrl + shift + f =�۰ʱN�{���X�Ŧ�n
		// ���X�ݭn�� Library �ֱ���GCtrl + Shift + O

	}

}
