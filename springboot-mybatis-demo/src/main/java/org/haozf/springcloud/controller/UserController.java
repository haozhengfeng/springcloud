package org.haozf.springcloud.controller;

import org.haozf.springcloud.mybatis.model.User;
import org.haozf.springcloud.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/add", produces = {"application/json;charset=UTF-8"})
    public int addUser(User user){
        return userService.addUser(user);
    }

    @RequestMapping(value = "/all/{pageNum}/{pageSize}", produces = {"application/json;charset=UTF-8"})
    public Object findAllUser(@PathVariable("pageNum") int pageNum, @PathVariable("pageSize") int pageSize){
        return userService.findAllUser(pageNum,pageSize);
    }
    
//    @GetMapping("/all/{pageNum}/{pageSize}")
//    public Object findAllUser(
//            @RequestParam(name = "pageNum", required = false, defaultValue = "1")
//                    int pageNum,
//            @RequestParam(name = "pageSize", required = false, defaultValue = "10")
//                    int pageSize){
//        return userService.findAllUser(pageNum,pageSize);
//    }
}
