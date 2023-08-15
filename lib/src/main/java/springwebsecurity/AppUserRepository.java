package springwebsecurity;

//import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

//@Repository
public interface AppUserRepository {
	
	public AppUser insert(AppUser appUser);
}
