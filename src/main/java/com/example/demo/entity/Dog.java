package com.example.demo.entity;

import com.example.demo.service.ifs.RunService;

public class Dog implements RunService {

	private String name = "Jack";

	private String color;

	private int age;
	// �w�]�غc��k�G�v�� ���O�W��( ){ }
	public Dog() {
		super();
	}
	// �غc��k(�a���ݩ�/�Ѽ�)�G
	public Dog(String name, String color, int age) {
		super();
		this.name = name;
		this.color = color;
		this.age = age;
	}

	// ��k�G�v�� �^�ǫ��A �ܼ�
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public void setAttributes(String name, String color, int age) {
		this.name = name;
		this.color = color;
		this.age = age;
	}
	
	public void setAttributes() {
		System.out.println( );
	}
	public static void setAttributes2() {
		System.out.println( );
	}

	@Override
	public void run() {
		System.out.println("Dog is running.");
	}
}
