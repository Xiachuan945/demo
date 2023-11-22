package com.example.demo;

import java.util.Scanner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);

		// 螢幕輸入
		Scanner scan = new Scanner(System.in);
		int x, y;
		String str;
		x = scan.nextInt();
		y = scan.nextInt();
		str = scan.next();        // 字串
		System.out.println(x + "\t" + y + "\t" + str);

//		System.out.println( ) 快捷鍵： syso + alt + ?
		// Cctrl + shift + f =自動將程式碼空行好
		// 跳出需要的 Library 快捷鍵：Ctrl + Shift + O

	}

}
