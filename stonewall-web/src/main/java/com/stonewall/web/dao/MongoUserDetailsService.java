package com.stonewall.web.dao;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.util.Assert;

import com.stonewall.web.model.MongoUser;

public class MongoUserDetailsService implements UserDetailsService, InitializingBean {

	private static final Logger logger = LoggerFactory.getLogger(MongoUserDetailsService.class);

	@Autowired
	private MongoUserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		if (logger.isDebugEnabled()) {
			logger.debug("searching for user with username :  " + username);
		}
		try {
			return userRepository.findByUsername(username);
		} catch (Exception e) {
			logger.error("Error retreiving user :" + username, e);
			throw new RuntimeException("Error retreiving user, please try again later");
		}
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		Assert.notNull(userRepository, "User repository cannot be null");
		try {
			logger.info("Checking for admin user yoda");
			if (userRepository.findByUsername("yoda") == null) {
				// TODO possible mongoDB bug. add test
				logger.warn("Adding admin user yoda");
				List<GrantedAuthority> roles = new ArrayList<GrantedAuthority>();
				roles.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
				MongoUser adminUser = new MongoUser("yoda", "reloaded", roles);
				userRepository.save(adminUser);
			} else {
				logger.info("Admin user yoda found");
			}
		} catch (Exception e) {
			logger.error("Error checking admin user yoda", e);
		}
	}
}
