package com.exam.controller;


import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.exam.dto.Member;
import com.exam.service.MemberService;


@Controller
public class MemberController {

	private Logger logger = LoggerFactory.getLogger(getClass());
	
	MemberService memberService;
	
	public MemberController(MemberService memberService) {
		this.memberService = memberService;
	}

	@GetMapping(value={"/signup"})
	public String showSignupPage(ModelMap model) {
		
		model.put("member", new Member());  // modelAttribute="member", 반드시 Command bean 이름으로 key값을 설정해야 됨.
		return "memberForm";
	}

	@PostMapping(value={"/signup"})
	public String showSignUpSuccessPage(@Valid Member member, 
			BindingResult result) {
		logger.debug("logger:{}", member);
		
		if(result.hasErrors()) {
			return "memberForm";
		}

		//서비스 연동
		// 비번 암호화 필수
		String encptPw = 
				new BCryptPasswordEncoder().encode(member.getPasswd());
		member.setPasswd(encptPw);
		
		int n = memberService.save(member);
		return "redirect:home";
	}
	
	@GetMapping(value={"/mypage"})
	public String mypage() {
		//AuthProvider에 저장된 아이디/비번(회원정보) Authentication 불러오기
		//Authentication의 실제 데이터는 
		//UsernamePassowrdAuthenticationToken token에 있다.
		//이 토큰을 객체생성할 때 mem, null, list를 생성한다.
		//첫번째 파라미터를 불러오는 녀석은 Principal, 두번째는 Credential이다.
		//token = new UsernamePasswordAuthenticationToken(mem, null, list);
		//new UsernamePasswordAuthenticationToken(Principal, Credentials);
		
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		logger.info("logger: Authentication {}",auth);
		Member xxx=(Member)auth.getPrincipal();
		logger.info("logger: Member: {}",xxx);
		return "redirect:home";
	}
}





