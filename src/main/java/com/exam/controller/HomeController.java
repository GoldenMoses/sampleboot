package com.exam.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

	private Logger logger = LoggerFactory.getLogger(getClass());

	//Home 요청
	//Home 요청 2 hotfix
	@GetMapping(value={"/home"})
	public String showHomePage() {
		return "home";
	}
}
