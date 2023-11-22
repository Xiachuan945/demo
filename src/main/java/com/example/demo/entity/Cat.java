package com.example.demo.entity;

public class Cat extends Animal {

	public Cat () {
		super();
//		System.out.println("Cat Animal «Øºc¤èªk");
	}
	
	@Override
	public void eat() {
		System.out.println(super.getName()+ " is eating and laughing.") ;
	}
	
	@Override
	public void sleep() {
		System.out.println(super.getName() + " is sleeping and snoring.") ;
	}
	
	public void meow() {
		System.out.println( super.getName() +" is meowing.") ;
	}
	
}
