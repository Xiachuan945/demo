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
		System.out.println("父類別 Animal name : "+anim.getName());
		anim.eat( ) ;
		anim.sleep( ) ;
		Bird bird = new Bird() ;
		bird.setName("Tony") ;
		System.out.println("子類別 Bird name : "+bird.getName()) ;
		bird.eat( ) ;
		bird.sleep( ) ;
		bird.fly( ) ;
		Cat cat = new Cat() ;
		cat.setName("Sara") ;
		System.out.println("子類別 Cat name : "+cat.getName()) ;
		cat.eat( ) ;
		cat.sleep( ) ;
		cat.meow(); ;
	}
	
	@Test
	public void extendsTest1() {
		// 透過類別 A1 取得類別 C 中的私有屬性 city
		A1 a1 = new A1() ;
		// 執行以下程式會報 NullPointerException
		// 類別 A1 中的私有屬性 C 也是個類別，類別的預設值是 null
		// a1.getC( ) 得到的值是 null ，null 在呼叫方法時就會報錯
		a1.getC().getCity() ;		
	}
	
	@Test
	public void extendsTest2() {
		// 透過類別 A1 取得類別 C 中的私有屬性 city
		A1 a1 = new A1() ;
		// 類別 A1 中的私有屬性 C  有給預設值，預設值就不是 null
		// 但類別 C 中的屬性依舊是預設值， city  是 String， 預設值還是 null
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
