package springwebsecurity;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;

import com.fasterxml.jackson.databind.ObjectMapper;

public class MyAuthenticationFailureHandler implements AuthenticationFailureHandler{

	@Override
	public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response,
			AuthenticationException exception) throws IOException, ServletException {

		Map<String,Object> result=new HashMap<String,Object>();
		result.put("msg", "登錄失敗"+exception.getMessage());
		result.put("status",500);
		response.setContentType("application/json;charset=UTF-8");
		response.getWriter().println(new ObjectMapper().writeValueAsString(result));
	}

	
}
