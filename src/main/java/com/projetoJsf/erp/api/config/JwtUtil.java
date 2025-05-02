package com.projetoJsf.erp.api.config;

import java.util.Date;
import java.util.UUID;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

public class JwtUtil {

	private static final String SECRET_KEY = "46944159C3C4B6642A37ED61AE721";
	private static final long EXPIRATION_TIME = 86400000;

	public static String gerarToken(String username) {
		return Jwts.builder().setSubject(username).setId(UUID.randomUUID().toString())
				.setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
				.signWith(SignatureAlgorithm.HS512, SECRET_KEY).compact();
	}

	public static String validarToken(String token) {
		return Jwts.parser().setSigningKey(SECRET_KEY).parseClaimsJws(token).getBody().getSubject();

	}
}
