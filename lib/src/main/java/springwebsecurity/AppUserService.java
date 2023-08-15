package springwebsecurity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class AppUserService {
	private final AppUserRepository appUserRepository;
	
	@Autowired
	private AppUserService(AppUserRepository appUserRepository) {
		this.appUserRepository=appUserRepository;
	}
	
	
	public AppUser getUserByEmail(String email) {
		
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		System.out.println(encoder.encode("Mars@@@7811"));
//		{bcrypt}
		return new AppUser("lizuan","$2a$10$/4bkq8fsgRP/xrf5jf/NguVKfQugDnf7MqIdTyNLqPpVPcbUzi8bW","mayahate77@gmail.com");
	}
	
			
}
