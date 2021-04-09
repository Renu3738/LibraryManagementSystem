package com.library.util;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import com.library.MyUserDetail;
import com.library.entity.User;

@Component
public class AuthenticationUtil {

	public static User getCurrentUser() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		if (authentication == null) {
			return null;
		}
		Object principal = authentication.getPrincipal();
		if (principal instanceof MyUserDetail) {
			MyUserDetail udi = (MyUserDetail) principal;
			return udi.getUser();

		}
		return null;

	}

}
