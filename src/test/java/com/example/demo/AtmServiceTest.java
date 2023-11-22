package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.service.ifs.AtmService;
import com.example.demo.vo.AtmResponse;

@SpringBootTest
public class AtmServiceTest {

	@Autowired
	private AtmService atmService ;
	
	@Test
	public void addInfoTest() {
		AtmResponse result = atmService.addInfo("A01", "AA123") ;
		System.out.println(result.getRtnCode().getCode()) ;
		System.out.println(result.getRtnCode().getMessage()) ;
		System.out.println("±b¸¹¡G" + result.getAtm().getAccount());
		System.out.println("±K½X¡G" + result.getAtm().getPwd());
	}
	
	@Test
	public void addInfoTest2() {
		
	}
	
}
