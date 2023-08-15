package springwebsecurity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Configuration
@EnableWebSecurity
public class WebSecureConfigure extends WebSecurityConfigurerAdapter {
//	@Autowired
//	private BCryptPasswordEncoder bCryptPasswordEncoder;
//	@Autowired
//	private SpringUserService springUserService;

	@Override
	protected void configure(HttpSecurity http) throws Exception {
//		log.debug("Using default configure(HttpSecurity). If subclassed this will potentially override subclass configure(HttpSecurity).");
		http.authorizeRequests().anyRequest()
		.authenticated().and()
		.formLogin().and().csrf().disable();
	}

//	@Override
//	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//		auth.userDetailsService(springUserService).passwordEncoder(bCryptPasswordEncoder);
//	}
//	取得資料庫中存的帳號
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		// inMemoryAuthentication 从内存中获取
		auth.userDetailsService(userDetailsService()).passwordEncoder(bCryptPasswordEncoder());
//		  auth.inMemoryAuthentication().passwordEncoder(new BCryptPasswordEncoder()).withUser("lizuan").password(new BCryptPasswordEncoder().encode("Mars@@@7811")).roles("USER");
	}

	@Bean
	public PasswordEncoder bCryptPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	public DaoAuthenticationProvider authProvider() {
		DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
		authProvider.setUserDetailsService(userDetailsService());
		authProvider.setPasswordEncoder(bCryptPasswordEncoder());
		return authProvider;
	}
	
	@Bean
	public UserDetailsService userDetailsService() {
		InMemoryUserDetailsManager inMemoryUserDetailsManager=new InMemoryUserDetailsManager();
		inMemoryUserDetailsManager.createUser(User.withUsername("root").password(bCryptPasswordEncoder().encode("root123")).roles("ADMIN").build());
		return inMemoryUserDetailsManager;
		
		
	}
}
