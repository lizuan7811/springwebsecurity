package springwebsecurity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class AppUser {

	private String userName;
	private String passord;
	private String mailAddress;
	
	
}
