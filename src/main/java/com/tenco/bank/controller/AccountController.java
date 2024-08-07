package com.tenco.bank.controller;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.tenco.bank.dto.SaveDTO;
import com.tenco.bank.handler.exception.DataDeliveryException;
import com.tenco.bank.handler.exception.UnAuthorizedException;
import com.tenco.bank.repository.model.User;
import com.tenco.bank.service.AccountService;

import jakarta.servlet.http.HttpSession;


@Controller // IoC 대상(싱글톤으로 관리)
@RequestMapping("/account")
public class AccountController {

	// 계좌 생성 화면 요청 - DI 처리
	private final HttpSession session;
	private final AccountService accountService;
	
	public AccountController(HttpSession session,AccountService accountService) {
		this.session = session;
		this.accountService = accountService;
	}
	
	/*
	 * 계좌 생성 페이지 요청
	 * 주소 설계 : http://localhost:8080/account/save
	 * @return save.jsp
	 */
	@GetMapping("/save")
	public String savePage() {
		
		// 1. 인증 검사가 필요(account 전체가 필요함)
		User principal = (User)session.getAttribute("principal");
		if(principal == null) {
			throw new UnAuthorizedException("인증된 사용자가 아닙니다", HttpStatus.UNAUTHORIZED);
		}
		
		return "account/save";
	}
	
	@PostMapping("/save")
	public String saveHandler(SaveDTO account) {
		User principal = (User)session.getAttribute("principal");
		if(principal == null) {
			throw new UnAuthorizedException("인증된 사용자가 아닙니다.", HttpStatus.UNAUTHORIZED);
		}
		int userId = principal.getId();
		if(account.getBalance() == null || account.getBalance() <= 0) {
			throw new DataDeliveryException("계좌 잔액을 입력해주세요", HttpStatus.BAD_REQUEST);
		}	
		
		if(account.getNumber() == null || account.getNumber().isEmpty()) {
			throw new DataDeliveryException("계좌번호를 입력해주세요", HttpStatus.BAD_REQUEST);
		}
		
		if(account.getPassword() == null || account.getNumber().isEmpty()) {
			throw new DataDeliveryException("비밀번호를 입력해주세요", HttpStatus.BAD_REQUEST);
		}
		accountService.createAccount(account,userId);
		return "redirect:/index";
	}
	
	/*
	 * 계좌 생성 페이지 요청
	 * 주소 설계 : http://localhost:8080/account/save
	 * @return : 추후 계좌 목록 페이지 이동 처리
	 * 
	 */
	// 1.
	// 2.
	// 3.
	// 4.
}
