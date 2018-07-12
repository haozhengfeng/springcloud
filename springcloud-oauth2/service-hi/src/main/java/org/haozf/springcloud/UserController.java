package org.haozf.springcloud;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

	private UserServiceImpl userService;
	
	@RequestMapping(value = "/registry",method = RequestMethod.POST)
	public User createUser(User user) {
		return userService.create(user);
	}
	
}
