package kr.yjh.lecture.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.yjh.lecture.service.TestService;
import kr.yjh.lecture.vo.TestVO;

@Controller
public class TestController {

	@Autowired
	private TestService testService;

	@RequestMapping(value = "/testVO")
	@ResponseBody
	public TestVO testObject() {
		return new TestVO(1, "윤종휘", 22);
	}

	@RequestMapping(value = "/testText", produces = "text/plain;charset=utf-8")
	@ResponseBody
	public String testText() {
		return "한글qwerty 12345!@#@!";
	}

	@RequestMapping(value = "/testDB")
	public String testDB(Model model) {
		model.addAttribute("today", testService.today());
		model.addAttribute("mul", testService.mul(11, 21));
		model.addAttribute("sum", testService.sum(11, 22, 33));
		return "testDB";

	}
}
