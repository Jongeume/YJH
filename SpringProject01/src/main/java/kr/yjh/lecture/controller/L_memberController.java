package kr.yjh.lecture.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.yjh.lecture.service.L_memberService;
import kr.yjh.lecture.vo.L_memberVO;

@Controller
public class L_memberController {

	@Autowired
	private L_memberService lms;

	@RequestMapping(value="/L_member/login")
	public String login(HttpServletRequest request, Model model) {
		// 쿠키를 읽자
		Cookie[] cookies = request.getCookies();
		if(cookies!=null && cookies.length>0) {
			for(Cookie cookie : cookies) {
				if(cookie.getName().equals("ID")) {
					model.addAttribute("ID", cookie.getValue());
					break;
				}
			}
		}
		return "login";
	}
	
	@RequestMapping(value="/L_member/join")
	public String join() {
		return "join";
	}
	@RequestMapping(value="/L_member/joinOk", method=RequestMethod.GET)
	public String joinOkGET() {
		return "redirect:login";
	}
	
	@RequestMapping(value="/L_member/joinOk", method=RequestMethod.POST)
	public String joinOkPOST(@ModelAttribute L_memberVO lvo) {
		System.out.println(lvo + "*************** joinOkPOST ***************************");
		// 서비스를 호출해서 DB에 저장
		lms.insert(lvo);
		return "redirect:login";
	}
	@RequestMapping(value="/L_member/confirm")
	public String confirm(@RequestParam String ID) {
		System.out.println(ID + "****************** confirm ***************************");
		// 서비스를 호출해서 회원 인증
		lms.confirm(ID);
		return "redirect:login";
	}
	@RequestMapping(value="/L_member/idCheck")
	@ResponseBody
	public String idCheck(@RequestParam String ID) {
		System.out.println(ID + "******************* idCheck **************************");
		// 서비스를 호출해서 아이디 중복 검사
		String result = lms.idCheck(ID);
		return result;
	}
	@RequestMapping(value="/L_member/loginOk", method=RequestMethod.GET)
	public String loginOkGET() {
		return "redirect:login";
	}
	
	@RequestMapping(value="/member/loginOk", method=RequestMethod.POST)
	public String loginOkPOST(@ModelAttribute L_memberVO lvo, @RequestParam(required=false) String remember,
			                  HttpServletRequest request, HttpServletResponse response) {
		System.out.println(lvo + "*************** joinOkPOST ***************************");
		System.out.println(remember + "*************** joinOkPOST ***************************");
		// 서비스를 호출해서 로그인 확인
		L_memberVO vo = lms.loginOk(lvo);
		if(vo==null) {
			return "redirect:/L_member/login";
		}else {
			request.getSession().setAttribute("vo", vo); // 세션에 저장
			// 아이디 자동 저장
			if(remember!=null && remember.equals("save")) {
				Cookie cookie = new Cookie("ID", vo.getID());
				cookie.setMaxAge(60*60*24*7); // 일주일
				response.addCookie(cookie);
			}else {
				// 쿠키 삭제
				Cookie cookie = new Cookie("ID", "");
				cookie.setMaxAge(0); 
				response.addCookie(cookie);
			}
			return "redirect:/";
		}
	}
	
	@RequestMapping(value="/L_member/logout")
	public String loginOut(HttpServletRequest request) {
		request.getSession().removeAttribute("vo");
		return "redirect:/";
	}
	
	@RequestMapping(value="/L_member/idSearch")
	public String idSearch() {
		return "idSearch";
	}

	@RequestMapping(value="/L_member/idSearchOk", method=RequestMethod.GET)
	public String idSearchOkGET() {
		return "redirect:login";
	}
	
	@RequestMapping(value="/member/idSearchOk", method=RequestMethod.POST)
	public String idSearchOkPOST(@ModelAttribute L_memberVO lvo, Model model) {
		System.out.println(lvo + "*************** idSearchOkPOST ***************************");
		// 서비스를 호출해서 로그인 확인
		L_memberVO vo = lms.idSearch(lvo);
		if(vo==null) {
			return "redirect:/L_member/idSearch";
		}else {
			model.addAttribute("vo", vo);
			return "viewUserId";
		}
	}
	
	@RequestMapping(value="/L_member/passwordSearch")
	public String passwordSearch() {
		return "passwordSearch";
	}
	
	@RequestMapping(value="/L_member/passwordSearchOk", method=RequestMethod.GET)
	public String passwordSearchOkGET() {
		return "redirect:login";
	}
	
	@RequestMapping(value="/L_member/passwordSearchOk", method=RequestMethod.POST)
	public String passwordSearchOkPOST(@ModelAttribute L_memberVO lvo, Model model) {
		System.out.println(lvo + "*************** passwordSearchOkPOST ***************************");
		// 서비스를 호출해서 로그인 확인
		L_memberVO vo = lms.passwordSearch(lvo);
		if(vo==null) {
			return "redirect:/L_member/passwordSearch";
		}else {
			model.addAttribute("vo", vo);
			return "viewPassword";
		}
		
	}

}
