package io.github.awaters1.security.model;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

import lombok.Data;
import lombok.EqualsAndHashCode;


@Data
@EqualsAndHashCode(callSuper = false)
public class FirebaseAuthenticationToken extends UsernamePasswordAuthenticationToken {
	private static final long serialVersionUID = 1L;
	private final String token;
	
	public FirebaseAuthenticationToken(final String token) {
		super(null, null);
		this.token = token;
	}

}
