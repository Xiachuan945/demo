package com.example.demo;

import org.junit.jupiter.api.Test;

import com.example.demo.entity.A1;
import com.example.demo.entity.Animal;
import com.example.demo.entity.Bird;
import com.example.demo.entity.C;
import com.example.demo.entity.Car;
import com.example.demo.entity.Cat;
import com.example.demo.entity.Dog;

public class ExtendsTest {

	@Test
	public void extendTest() {
		Animal anim = new Animal ();
		System.out.println("�����O Animal name : "+anim.getName());
		anim.eat( ) ;
		anim.sleep( ) ;
		Bird bird = new Bird() ;
		bird.setName("Tony") ;
		System.out.println("�l���O Bird name : "+bird.getName()) ;
		bird.eat( ) ;
		bird.sleep( ) ;
		bird.fly( ) ;
		Cat cat = new Cat() ;
		cat.setName("Sara") ;
		System.out.println("�l���O Cat name : "+cat.getName()) ;
		cat.eat( ) ;
		cat.sleep( ) ;
		cat.meow(); ;
	}
	
	@Test
	public void extendsTest1() {
		// �z�L���O A1 ���o���O C �����p���ݩ� city
		A1 a1 = new A1() ;
		// ����H�U�{���|�� NullPointerException
		// ���O A1 �����p���ݩ� C �]�O�����O�A���O���w�]�ȬO null
		// a1.getC( ) �o�쪺�ȬO null �Anull �b�I�s��k�ɴN�|����
		a1.getC().getCity() ;		
	}
	
	@Test
	public void extendsTest2() {
		// �z�L���O A1 ���o���O C �����p���ݩ� city
		A1 a1 = new A1() ;
		// ���O A1 �����p���ݩ� C  �����w�]�ȡA�w�]�ȴN���O null
		// �����O C �����ݩʨ��¬O�w�]�ȡA city  �O String�A �w�]���٬O null
		String city = a1.getC().getCity() ;
		System.out.println(city) ;
	}
	
	@Test
	public void extendsTest3() {
		C c = new C("AAA","BBB","CCC") ;
//		c.setCity("AAA") ;
//		c.setCountry("BBB") ;
//		c.setState("CCC") ;
		A1 a1 = new A1() ;
		a1.setC(c) ;
		a1.setAddress("DDD") ;
		System.out.println("= = = = = =");
		System.out.println("city: " + a1.getC().getCity());
		System.out.println("country: " + a1.getC().getCountry());
		System.out.println("state: " + a1.getC().getState());
		System.out.println("address: " + a1.getAddress());
	}
		
	@Test
	public void extendsTest4() {
		Animal anim = new Animal( );
		anim.eat( ) ;
		Bird bird = new Bird() ;
		bird.eat() ;
		Cat cat = new Cat() ;
		cat.eat();
		System.out.println("= = = = = =") ;
		Animal animm = new Animal( );
		animm.eat( ) ;
		Animal birdd = new Bird() ;
		birdd.eat() ;
		Animal catt = new Cat() ;
		catt.eat();
	}
	
	@Test
	public void interfaceTest() {
		Car car = new Car() ;
		car.run() ;
		Dog dog = new Dog() ;
		dog.run() ;
	}
	
}
