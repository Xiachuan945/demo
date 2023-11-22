package com.example.demo.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.example.demo.constants.RtnCode;
import com.example.demo.entity.Atm;
import com.example.demo.repoistory.AtmDao;
import com.example.demo.service.ifs.AtmService;
import com.example.demo.vo.AtmResponse;

@Service
public class AtmServiceImpl implements AtmService {
	
	private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder() ;

	@Autowired
	private AtmDao atmDao ;
	
	@Override
	public AtmResponse login(String account, String pwd) {
		if ( ! StringUtils.hasText(account) ||  ! StringUtils.hasText(pwd)) {
			return new AtmResponse(null , RtnCode.PARAM_ERROR ) ;
		}
		Optional<Atm> op = atmDao.findById(account) ;
		if (op.isEmpty()) {
			return new AtmResponse(null , RtnCode.ACCOUNT_NOT_FOUND ) ;
		}
		if(!encoder.matches(pwd, op.get().getPwd())) {
			return new AtmResponse(null , RtnCode.LOGIN_ERROR ) ;
		}
		return new AtmResponse(null , RtnCode.SUCCESSFUL ) ;
	}
	
	@Override
	public AtmResponse addInfo(String account, String pwd) {
		if ( ! StringUtils.hasText(account) ||  ! StringUtils.hasText(pwd)) {
			return new AtmResponse(null , RtnCode.PARAM_ERROR ) ;
		}
		if (atmDao.existsById(account)) {
			return new AtmResponse(null , RtnCode.ACCOUNT_EXISTED ) ;
		}
		// BCryptPasswordEncoder�G��K�X�i��[�K
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder() ;
		Atm result = atmDao.save(new Atm(account, encoder.encode(pwd))) ;
		// .setPwd() �G���^����� pwd�A����Ʒ|�ǰe�ܸ�Ʈw
//		result.setPwd("") ;
		return new AtmResponse(result , RtnCode.SUCCESSFUL) ;
	}
	// �z�L�b�����o�l�B
	
	@Cacheable (cacheNames = "atm_get_balance", key = "#account" , unless = "#result.rtnCode.code != 200")
	@Override
	public AtmResponse getBalanceByAccount(String account, String pwd) {
		if ( ! StringUtils.hasText(account)) {
			return new AtmResponse(null , RtnCode.PARAM_ERROR ) ;
		}
		Optional<Atm> op = atmDao.findById(account) ;
		if ( op.isEmpty()) {
			return new AtmResponse(null , RtnCode.ACCOUNT_NOT_FOUND) ;
		}
		Atm result = op.get() ;
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder() ;
		if ( ! encoder.matches(pwd, result.getPwd())) {
			return new AtmResponse(null , RtnCode.ACCOUNT_NOT_FOUND) ;
		}
		result.setPwd("") ;
		return new AtmResponse(result , RtnCode.SUCCESSFUL) ;
	}
	// �ק�K�X
	@Override
	public AtmResponse updatePwd(String account, String oldPwd, String newPwd) {
		if ( ! StringUtils.hasText(account) ||  ! StringUtils.hasText(oldPwd) || ! StringUtils.hasText(newPwd)) {
			return new AtmResponse(null , RtnCode.PARAM_ERROR ) ;
		}
		Optional<Atm> op = atmDao.findById(account) ;
		if (op.isEmpty()) {
			return new AtmResponse(null , RtnCode.ACCOUNT_NOT_FOUND) ;
		}
		Atm result = op.get() ;
//		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder() ;
		if ( ! encoder.matches(oldPwd, result.getPwd())) {
			return new AtmResponse(null , RtnCode.ACCOUNT_NOT_FOUND) ;
		}
		result.setPwd(encoder.encode(newPwd));
		atmDao.save(result) ;
		result.setPwd("");
		return new AtmResponse(result , RtnCode.SUCCESSFUL) ;
	}
	// �s��
	@Override
	public AtmResponse deposit(String account, String pwd, int amount) {
		if ( ! StringUtils.hasText(account) ||  ! StringUtils.hasText(pwd) || amount <=0) {
			return new AtmResponse(null , RtnCode.PARAM_ERROR ) ;
		}		
		Optional<Atm> op = atmDao.findById(account) ;
		if (op.isEmpty()) {
			return new AtmResponse(null , RtnCode.ACCOUNT_NOT_FOUND) ;
		}
		Atm result = op.get() ;
//		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder() ;
		if ( ! encoder.matches(pwd, result.getPwd())) {
			return new AtmResponse(null , RtnCode.ACCOUNT_NOT_FOUND) ;
		}
		result.setBalance(result.getBalance() + amount) ; // �s�l�B = �l�B+�s��
		atmDao.save(result) ;
		result.setPwd("");
		return new AtmResponse(result , RtnCode.SUCCESSFUL) ;
	}
	// ����
	@Override
	public AtmResponse withdraw(String account, String pwd, int amount) {
		if ( ! StringUtils.hasText(account) ||  ! StringUtils.hasText(pwd) || amount <=0 ) {
			return new AtmResponse(null , RtnCode.PARAM_ERROR ) ;
		}
		Optional<Atm> op = atmDao.findById(account) ;
		if (op.isEmpty()) {
			return new AtmResponse(null , RtnCode.ACCOUNT_NOT_FOUND) ;
		}
		Atm result = op.get() ;
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder() ;
		if ( ! encoder.matches(pwd, result.getPwd())) {
			return new AtmResponse(null , RtnCode.ACCOUNT_NOT_FOUND) ;
		}
		// �ˬd�l�B�j�󴣴ڪ��B
		if (result.getBalance() < amount) {
			result.setPwd("");
			return new AtmResponse(result , RtnCode.INSUFFICIENT_BALANCE ) ;
		}
		result.setBalance(result.getBalance() - amount) ;  // �s�l�B = �l�B-����
		atmDao.save(result) ;
		result.setPwd("");
		return new AtmResponse(result , RtnCode.SUCCESSFUL) ;
	}	
	
}
