package com.example.demo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.demo.domain.Code;

@Controller
public class HomeController {
	private static final Logger log = LoggerFactory.getLogger(HomeController.class);

	@GetMapping("")
	public String home() {
		return "index";
	}

	@GetMapping("/test")
	public String test(String response_type, String client_id, String redirect_url, String scope, Integer expires_in) {
		return String.format(
				"redirect:https://www.fitbit.com/oauth2/authorize?response_type=%s&client_id=%s&redirect_url=%s&"
						+ "scope=%s&expires_in=%d",
				response_type, client_id, redirect_url, scope, expires_in);
	}

	@GetMapping("/callback")
	public String callback(String code) {
		Code code2 = new Code(code);
		System.out.println(code2.getCode());
		return "index";
	}

}
