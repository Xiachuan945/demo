package com.example.demo.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.constants.RtnCode;
import com.example.demo.service.ifs.AtmService;
import com.example.demo.vo.AtmRequest;
import com.example.demo.vo.AtmResponse;

@RestController
public class AtmController {

	@Autowired
	private AtmService atmService;

	@GetMapping(value = "atm/login")
	public AtmResponse login(@RequestBody AtmRequest req, HttpSession session) {
		System.out.println(session.getAttribute("account"));
		if (session.getAttribute("account") != null) {
			return new AtmResponse(null, RtnCode.SUCCESSFUL);
		}
		AtmResponse res = atmService.login(req.getAccount(), req.getPwd());
		if (res.getRtnCode().getCode() == 200) {
			session.setAttribute("account", req.getAccount());
			session.setAttribute("password", req.getPwd());
			// 設定 session 有效時間： 300秒
			session.setMaxInactiveInterval(300);
		}
		return res;
	}

//	@CacheEvict(cacheNames = "atm_login", key = "#account")
//	public  AtmResponse logout (@RequestBody AtmRequest req, HttpSession session ) {
	@GetMapping(value = "atm/logout") // url : localhost:8080/atm/logout?account=值
	@CacheEvict(cacheNames = "atm_get_balance", key = "#account")
	public AtmResponse logout(@RequestBody AtmRequest req, HttpSession session) {
		// 讓 session 失效
		session.invalidate();
		return new AtmResponse(null, RtnCode.SUCCESSFUL);
	}

	@PostMapping(value = "atm/add_info")
	public AtmResponse addInfo(@RequestBody AtmRequest req) {
		return atmService.addInfo(req.getAccount(), req.getPwd());
	}

	@GetMapping(value = "atm/get_balance")
	public AtmResponse getBalanceByAccount(HttpSession session) {
		System.out.println("session id :" + session.getId());
		String account = (String) session.getAttribute("account");
		String pwd = (String) session.getAttribute("password");
		if (StringUtils.hasText(account)) {
			return atmService.getBalanceByAccount(account, pwd);
		}
		return new AtmResponse(null, RtnCode.PLEASE_LOGIN_FIRST);
	}
}
