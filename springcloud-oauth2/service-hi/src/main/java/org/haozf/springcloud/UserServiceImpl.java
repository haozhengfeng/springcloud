package org.haozf.springcloud;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{

	private static final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

	@Override
	public User create(User user) {
		String hash = encoder.encode(user.getPassword());
		user.setPassword(hash);
		return user;
	}
	
	
	
}
