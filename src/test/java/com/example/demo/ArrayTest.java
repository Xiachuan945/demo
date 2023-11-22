package com.example.demo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

public class ArrayTest {

	@Test
	public void arrayTest() {
		int[] a = new int[5]; // new ���O�G���@�ӰO����Ŷ�
		System.out.println(a);
		System.out.println(a.length);
		a[0] = 3; // �� 1 ���}�C a ���� 0 �Ӧ�m
		a[1] = 6;
		a[2] = 9;
		System.out.println(a);
		System.out.println("= = = = = = = = =");
		// �ŧi���P�ɡA������l��
		int[] b = { 1, 3, 5, 7, 9 };
		System.out.println(b[4]);
	}

	@Test
	public void listTest() {
		List<String> strList = new ArrayList<>();
		// List �O�����Ǫ��A�̷ӥ[�J�����ᶶ�ǱƧ�
		strList.add("S");
		strList.add("O");
		strList.add("N");
		strList.add("Y");
		System.out.println(strList);
		System.out.println("= = = = = = = =");
		System.out.println(strList.size());
		System.out.println("= = = = = = = =");
		for (int i = 0; i < strList.size(); i++) {
			System.out.println(strList.get(i));
		}
		System.out.println("= = = = = = = =");

		List<String> strList1 = List.of("M", "U", "J", "I");
		List<String> strList2 = Arrays.asList("P", "O", "Y", "A");
		// ����U�@��{���|�����A�]���� List.of ( ) ���ͪ� List �j�p�T�w�A�L�k�A�W�R
//		strList1.add("plus");
		// ����U�@��{���|�����A�]���� Arrays.asList ( ) ���ͪ� List �j�p�T�w�A�L�k�A�W�R
//		strList2.add("plus");
		System.out.println("= = = = = = = =");
		
		// ArrayList<>( ) �᭱���Ŷ��O�ʺA���A�G�i�H�� strList.add( ) �s�W��list��
		List<String> strList3 = new ArrayList<>(List.of("M", "U", "J", "I"));
		List<String> strList4 = new ArrayList<>(Arrays.asList("P", "O", "Y", "A"));
	}
	
	@Test
	public void foreachTest() {
		List<String> strList = new ArrayList<>(List.of("Z", "A", "R", "A"));
		for (int i = 0; i < strList.size(); i++) {
			System.out.println(strList.get(i));
		}
		System.out.println("= = = = = = = =");
		// foreach�G�M���C�N List �̪��C�Ӷ��رq�Y����@�Ӥ@�Ө��X
		// for ( ��Ƨ@�Ϋ��A �ܼ�_�n�����C�@�� : �n���X�� list ��H ) { }
		for(String item : strList) {
			System.out.println(item);
		};
		System.out.println("= = = = = = = =");

		strList.forEach(item ->{
			System.out.println(item);
		});
	}
	
	@Test
	public void listTest1() {
		int a = 5;
		int [ ] b = new int[5] ;
		System.out.println(a);
		System.out.println(b);
	}
	
	@Test
	public void listTest2() {
		int a = 5;
		int [ ] b = new int[5] ;
		System.out.println(a);
		System.out.println(b);
	}
}
