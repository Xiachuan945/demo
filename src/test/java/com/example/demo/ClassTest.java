package com.example.demo;

import java.util.Random;

import org.junit.jupiter.api.Test;
import org.springframework.util.Assert;

import com.example.demo.entity.Dog;
import com.example.demo.entity.TaipeiBank;

public class ClassTest {

	@Test
	public void classTest() {
		Dog dog = new Dog();
		String name = dog.getName();
		System.out.println(name);
		dog.setName("Jack"); // �]�w�W�r�� Jack
		name = dog.getName(); // �N�W�r���^�hDog.java �� getName
		System.out.println(name);
		System.out.println("= = = = = = = =");
	}

	@Test
	public void classTest1() {
		Dog yourdog = new Dog();
		System.out.println(yourdog.getName());
		yourdog.setName("Stacy");
		System.out.println("= = = = = = = =");
		////// //////////////////////////
		Dog mydog = new Dog();
		System.out.println(mydog.getName());
		mydog.setName("Moffy");
		System.out.println(yourdog.getName());
		System.out.println(mydog.getName());
		System.out.println("= = = = = = = =");
	}

	@Test
	public void classTest2() {
		Dog dog = new Dog();
		dog.setAttributes("Kiki", "White", 7);
		System.out.println("= = = = = = = =");
	}

	@Test
	public void classTest3() {
		TaipeiBank bank = new TaipeiBank();
		System.out.println(bank.getBalance());
		// �P�_�O�_���u�A( ) ���ݭn���ӧP�_���A�e�����G�����ܡA�X�{���
		Assert.isTrue(bank.getBalance() == 1000, "saving error ! !");
		///////////////////////////////////////////////
		bank.saving(-500);
		Assert.isTrue(bank.getBalance() == 1000, "saving error ! !");
		System.out.println(bank.getBalance());
		///////////////////////////////////////////////
		bank.saving(500);
		Assert.isTrue(bank.getBalance() == 1500, "saving error ! !");
		System.out.println(bank.getBalance());
		///////////////////////////////////////////////
		// 11/3HW
		bank.withdraw(500);
		Assert.isTrue(bank.getBalance() == 500, "saving error ! !");
		System.out.println(bank.getBalance());
		bank.withdraw(500);
		Assert.isTrue(bank.getBalance() == 1000, "saving error ! !");
		System.out.println(bank.getBalance());
	}

	@Test
	public void classTest4() {
		int a = 6;
		int b = 6;
		System.out.println(a == b);
		System.out.println("= = = = = = = =");
		Integer a1 = 12;
		Integer b1 = 12;
		System.out.println(a1 == b1);
		System.out.println("= = = = = = = =");
		boolean boo1 = false;
		boolean boo2 = false;
		System.out.println(boo1 == boo2);
		System.out.println("= = = = = = = =");
		Integer a2 = new Integer(18);
		Integer b2 = new Integer(18);
		System.out.println("a2==b2 : " + (a2 == b2));
		System.out.println("= = = = = = = =");

		Dog dog = new Dog();
		System.out.println(dog);
		Dog dogg = new Dog();
		System.out.println(dogg);
		System.out.println(dog == dogg);
		System.out.println("= = = = = = = =");
		Dog doggg = dog;
		System.out.println(doggg);
		System.out.println(dog == doggg);
		System.out.println("= = = = = = = =");
	}
	
	@Test
	public void classTest5() {
		TaipeiBank bank = new TaipeiBank();
		int a = 10;
		for ( int i = 0 ; i < 10 ; i ++ ) {
			System.out.println( i );
		}
		if ( a > 20 ) {
			System.out.println("= = = = = = = =");
		}
		int b = 20 ;
		System.out.println( b );
		System.out.println( a );
		b = 30 ;
	}
	
	@Test
	public void classTest6() {
		Dog dog = new Dog() ;
		dog.setName("Jason");
		dog.setColor("Blue");
		dog.setAge(2);
		System.out.println("= = = = = = = =");
		Dog dogg = new Dog( "Lisa", "Brown", 3) ;
		System.out.println("= = = = = = = =");
	}
	
	@Test
	public void classTest7() {
		Dog dog = new Dog() ;
		dog.setAttributes();       // �@���k���I�s�A�n�������O new �X��		
		Dog.setAttributes2();     // static ��k���I�s�A���������O�W��.static ��k
		System.out.println("= = = = = = = =");
		Math.random( );
		Random ran = new Random();
		ran.nextInt();
		int a = 100;
		a = 200 ;
		final int b = 500 ;		
	}
}
