package org.haozf.springcloud;

import javax.annotation.Resource;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@EnableAutoConfiguration
@RequestMapping("/testboot")
public class TestBootController {
	
	@Resource
    private UserDao userDao;
	
    @RequestMapping("getuser")
    public User getUser() {
        User user = new User();
        user.setName("test");
        
        user = userDao.getUser(5);
        
        return user;
    }
}
