package springwebsecurity;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import springwebsecurity.entity.User;
@Configuration
public class SecurityConfigProperty {
//	@Bean
//	public BCryptPasswordEncoder passwordEncoder() {
//		return new BCryptPasswordEncoder();
//	}
	@Bean
	public Class<User> calssUser(){
		return User.class;
	}
}
