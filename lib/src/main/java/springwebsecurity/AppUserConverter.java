package springwebsecurity;

public class AppUserConverter {
	
	public static AppUser toAppUser(AppUserRequest appuser) {
		return new AppUser("lizuan","Mars@@@7811","mayahate77@gmail.com");
	}
	
	public static AppUserResponse toAppUserResponse(AppUser appuser) {
		return new AppUserResponse();
	}

}
