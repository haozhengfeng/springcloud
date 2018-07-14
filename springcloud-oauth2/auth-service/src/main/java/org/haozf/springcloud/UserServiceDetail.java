package org.haozf.springcloud;

import java.util.List;

import org.haozf.springcloud.mybatis.mapper.UserMapper;
import org.haozf.springcloud.mybatis.model.User;
import org.haozf.springcloud.mybatis.model.UserExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserServiceDetail implements UserDetailsService{
	
	@Autowired
	UserMapper userMapper;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		UserExample example = new UserExample();
		example.or().andUserNameEqualTo(username);
		List<User> users = userMapper.selectByExample(example);
		UserDetail user = new UserDetail(users.get(0));

		return user;
	}

	
}
