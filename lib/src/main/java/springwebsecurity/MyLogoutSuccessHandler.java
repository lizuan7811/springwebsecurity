package springwebsecurity;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;

import com.fasterxml.jackson.databind.ObjectMapper;

public class MyLogoutSuccessHandler implements LogoutSuccessHandler{

	@Override
	public void onLogoutSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication)
			throws IOException, ServletException {

		Map<String,Object> result=new HashMap<String,Object>();
		result.put("msg","登出成功，登出使用者為:"+authentication);
		result.put("status",200);
		response.setContentType("application/json;charset=UTF-8");
		response.getWriter().println(new ObjectMapper().writeValueAsString(result));
		
	}

}
