package org.haozf.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/html")
public class HelloHtmlController {

	@Value("${my.name}")
	private String name;

	@RequestMapping("/hello")
	public String hello(Model model) {
		model.addAttribute("name", name);
		return "hello";
	}

}
