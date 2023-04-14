package org.maumont.api.security;

import java.util.Collections;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.fasterxml.jackson.databind.ObjectMapper;

import io.jsonwebtoken.io.IOException;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class JwtAuthenticationFilter extends UsernamePasswordAuthenticationFilter {

	@Override
	public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
			throws AuthenticationException {

		AuthCredentials authCredentials = new AuthCredentials();
		
		try {
			authCredentials = new ObjectMapper().readValue(request.getReader(), AuthCredentials.class);

		}catch(IOException | java.io.IOException e) {
		}
		
		UsernamePasswordAuthenticationToken usernamePat = new UsernamePasswordAuthenticationToken(
				authCredentials.getEmail(),
				authCredentials.getPassword(),
				Collections.emptyList());
				
		return getAuthenticationManager().authenticate(usernamePat);
	}

	@Override
	protected void successfulAuthentication(HttpServletRequest request,
			HttpServletResponse response,
			FilterChain chain,
			Authentication authResult) throws java.io.IOException, ServletException {
		
		UserDetailsImpl userDetails = (UserDetailsImpl)authResult.getPrincipal();
		String token = TokenUtils.createToken(userDetails);
		
		response.addHeader("Authorization","Bearer " + token);
		response.getWriter().flush();
		
		super.successfulAuthentication(request, response, chain, authResult);
	}

	
}
