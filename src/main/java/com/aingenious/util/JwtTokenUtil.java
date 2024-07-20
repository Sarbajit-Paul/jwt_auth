package com.aingenious.util;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

@Component
public class JwtTokenUtil {
	private ExpiringSet<String> tokenHolder=  new ExpiringSet<>(25, TimeUnit.MINUTES);
	private static final String SECRET_KEY = "your_secret_key"; // Replace with your secret key
	private static final long JWT_TOKEN_VALIDITY = 20* 60 * 1000; // 20 minutes

	public String generateToken(String username) {
		Map<String, Object> claims = new HashMap<>();
		String token = doGenerateToken(claims, username);
		tokenHolder.add(token);
		return token;
	}

	private String doGenerateToken(Map<String, Object> claims, String subject) {
		return Jwts.builder()
				.setClaims(claims)
				.setSubject(subject)
				.setIssuedAt(new Date(System.currentTimeMillis()))
				.setExpiration(new Date(System.currentTimeMillis() + JWT_TOKEN_VALIDITY))
				.signWith(SignatureAlgorithm.HS512, SECRET_KEY)
				.compact();
	}

	public String getUsernameFromToken(String token) {
		return getClaimFromToken(token, Claims::getSubject);
	}

	public Date getExpirationDateFromToken(String token) {
		return getClaimFromToken(token, Claims::getExpiration);
	}

	public <T> T getClaimFromToken(String token, Function<Claims, T> claimsResolver) {
		final Claims claims = getAllClaimsFromToken(token);
		return claimsResolver.apply(claims);
	}

	private Claims getAllClaimsFromToken(String token) {
		return Jwts.parser().setSigningKey(SECRET_KEY).parseClaimsJws(token).getBody();
	}

	public Boolean isTokenExpired(String token) {
		try {
			final Date expiration = getExpirationDateFromToken(token);
			return expiration.before(new Date());
		}catch(io.jsonwebtoken.ExpiredJwtException ex){return true;}}

	public ExpiringSet<String> getTokenHolder() {
		return tokenHolder;
	}
}

