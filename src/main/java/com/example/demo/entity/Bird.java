package com.example.demo.entity;

public class Bird extends Animal {
	
	public Bird() {
		super();
//		System.out.println("Bird Animal �غc��k");
	}

	// Override�G�Ƽg or ���s�w�q
	// ���l���O�a���ۦP��k(�W��+�ѼƭӼ�)�A�l���O�惡��k���s�w�q�ۤv����@���e
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
