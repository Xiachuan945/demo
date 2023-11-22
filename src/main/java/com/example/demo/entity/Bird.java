package com.example.demo.entity;

public class Bird extends Animal {
	
	public Bird() {
		super();
//		System.out.println("Bird Animal 建構方法");
	}

	// Override：複寫 or 重新定義
	// 父子類別帶有相同方法(名稱+參數個數)，子類別對此方法重新定義自己的實作內容
	@Override
	public void eat() {
		System.out.println(super.getName() + " is eating and playing.") ;
	}
	
	@Override
	public void sleep() {
		System.out.println(super.getName()+ " is sleeping and eating.") ;
	}
	
	public void fly() {
		System.out.println( super.getName() + " is flying.") ;
	}
	
}
