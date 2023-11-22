package com.example.demo.service.ifs;

import com.example.demo.entity.Atm;
import com.example.demo.vo.AtmResponse;

public interface AtmService {
	public AtmResponse login(String account, String pwd) ;
	// 新增資訊：:addInfo
	public AtmResponse addInfo(String account, String pwd) ;
	// 透過帳號取得餘額 ( 檢查帳號和密碼、顯示帳號和餘額 )
	public AtmResponse getBalanceByAccount(String account, String pwd) ;
	// 修改密碼 ( 檢查帳號和密碼、資訊防呆 )
	public AtmResponse updatePwd(String account, String oldPwd, String newPwd) ;
	// 存款 ( 檢查帳號和密碼、資訊防呆、顯示帳號.存款後的餘額 )
	public AtmResponse deposit(String account, String pwd, int amount) ;
	// 提款 ( 檢查帳號和密碼、資訊防呆、顯示帳號.提款後的餘額 )
	public AtmResponse withdraw(String account, String pwd, int amount) ;	
}
