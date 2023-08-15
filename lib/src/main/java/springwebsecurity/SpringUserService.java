package springwebsecurity;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import springwebsecurity.entity.User;
import springwebsecurity.repo.LizUserRepo;

@Service
public class SpringUserService implements UserDetailsService{

	@Autowired
	private AppUserService appUserService;
	@Autowired
	private LizUserRepo lizUserRepo;
	@Override
	public UserDetails loadUserByUsername(String username)throws UsernameNotFoundException{

		User user =lizUserRepo.findUserByUsername(username, User.class);
//		
//		UserDet userDet= convertEntityToModel.convertEntityToModel(user, new UserDet()) ;
//
//		if(ObjectUtils.isEmpty(userDet))throw new UsernameNotFoundException("用戶不正確");
//		List<Role>roles=roleRepository.getRoleByuid(userDet.getId(),Role.class);
//		userDet.setRoles(roles);
//		return userDet;
		
		
		System.out.println("SpringUserService > loadUserByUsername");
		
		AppUser appUser=appUserService.getUserByEmail("");
		System.out.println(appUser.toString());
		return null;
//		return new User("lizuan", "{}Mars@@@7811", Collections.emptyList());

	}
	
}
