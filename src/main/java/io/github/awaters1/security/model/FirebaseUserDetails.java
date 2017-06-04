package io.github.awaters1.security.model;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import lombok.Data;

@Data
public class FirebaseUserDetails implements UserDetails {
	private static final long serialVersionUID = 1L;
	
	private final boolean enabled = true;
	private final boolean credentialsNonExpired = true;
	private final boolean accountNonLocked = true;
	private final boolean accountNonExpired = true;
	private final String password = null;
	private final String username;
	private final String id;
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return null;
	}
}
