package org.maumont.api.security;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.crypto.SecretKey;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

public class TokenUtils {
	
//	private final static SecretKey key = Keys.secretKeyFor(SignatureAlgorithm.HS256);
	private final static String ACCES_TOKEN_SECRET= "u37VQdpCZGBTxBvKXuAk8FlmAmaK9Tkf";
	private final static Long ACCES_TOKEN_VALIDITY_SECONDS = 86_400L;
	
	public static String createToken(UserDetailsImpl userDetailsImpl) {
		
		long expirationTime = ACCES_TOKEN_VALIDITY_SECONDS * 1000;
		Date expirationDate = new Date(System.currentTimeMillis() + expirationTime);
		
		Map<String, Object> extra =	new HashMap<>();
		extra.put("nombre", userDetailsImpl.getNombre());
		extra.put("roles", userDetailsImpl.getRol());
		
		return Jwts.builder()
				.setSubject(userDetailsImpl.getUsername())
				.setExpiration(expirationDate)
				.addClaims(extra)
				.signWith(Keys.hmacShaKeyFor(ACCES_TOKEN_SECRET.getBytes()))
				.compact();
	}
	
	public static UsernamePasswordAuthenticationToken getAuthentication(String token) {
		try {
			Claims claims = Jwts.parserBuilder()
					.setSigningKey(ACCES_TOKEN_SECRET.getBytes())
					.build()
					.parseClaimsJws(token) 	
					.getBody();
			
			String email = claims.getSubject();
			
			String rol = (String) claims.get("roles");
			
			List<GrantedAuthority> authorities = new ArrayList<>();
			
			if (rol == null) {
				authorities = Collections.emptyList();
			} else {
				authorities.add(new SimpleGrantedAuthority(rol));
			}
			
			
			

			
			System.out.println(authorities);

			return new UsernamePasswordAuthenticationToken(email, null, authorities);
		} catch(JwtException e) {
			return null;
		}

		
	}

}
