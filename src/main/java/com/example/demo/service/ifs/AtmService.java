package com.example.demo.service.ifs;

import com.example.demo.entity.Atm;
import com.example.demo.vo.AtmResponse;

public interface AtmService {
	public AtmResponse login(String account, String pwd) ;
	// �s�W��T�G:addInfo
	public AtmResponse addInfo(String account, String pwd) ;
	// �z�L�b�����o�l�B ( �ˬd�b���M�K�X�B��ܱb���M�l�B )
	public AtmResponse getBalanceByAccount(String account, String pwd) ;
	// �ק�K�X ( �ˬd�b���M�K�X�B��T���b )
	public AtmResponse updatePwd(String account, String oldPwd, String newPwd) ;
	// �s�� ( �ˬd�b���M�K�X�B��T���b�B��ܱb��.�s�ګ᪺�l�B )
	public AtmResponse deposit(String account, String pwd, int amount) ;
	// ���� ( �ˬd�b���M�K�X�B��T���b�B��ܱb��.���ګ᪺�l�B )
	public AtmResponse withdraw(String account, String pwd, int amount) ;	
}
