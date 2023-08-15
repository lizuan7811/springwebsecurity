package springwebsecurity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;

@Configuration
@EnableAuthorizationServer
public class AuthorizationServerconfig extends AuthorizationServerConfigurerAdapter {

	private final PasswordEncoder passwordEncoder;
	private final UserDetailsService userDetailsService;

	@Autowired
	public AuthorizationServerconfig(PasswordEncoder passwordEncoder,UserDetailsService userDetailsService) {
		this.passwordEncoder = passwordEncoder;
		this.userDetailsService=userDetailsService;
	}

	// 設定token連接使用的訊息
	public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
//		http://localhost:8081/oauth/authorize?client_id=client&response_type=code&redirect_uri=http://www.google.com.tw
		clients.inMemory().withClient("client").secret(passwordEncoder.encode("secret"))
				.redirectUris("http://www.google.com.tw").authorizedGrantTypes("authorization_code","refresh_token")
				.scopes("read:user");
	}
//	使用refresh_token，需要提供userdetailsservice; 
	public void configure(AuthorizationServerEndpointsConfigurer endpoints)throws Exception{
		endpoints.userDetailsService(userDetailsService);
	}

	
//	 登入驗證後拿到驗證碼，輸入驗證碼後，才拿到refresh_token
	
}
