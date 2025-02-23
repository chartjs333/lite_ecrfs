package net.mdsgene.admin.admintool.business;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.AuthorityUtils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
//import net.mdsgene.admin.tags.ArrayLinksTag;
//import net.mdsgene.admin.tags.LinkToTag;

public class UserDecorator {
	public static boolean is_user_logged_in(HttpServletRequest req, String mdsDomain) {
		// check the principal if user already logged in
		Object  principal = org.springframework.security.core.context.SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		boolean result = true;
		if(principal == null) result = false;
		if((principal instanceof String) && "anonymousUser".equals(principal)) result = false;
		if((principal instanceof String) && !"anonymousUser".equals(principal)) result = true;
		try {
			//if user is not logged in
			if (!result) {
				Cookie[] cookies = req.getCookies();
				// find in the cookies login token
				for (int i = 0; i < cookies.length; i++) {
					if (cookies[i].getName().equals("loginToken")) {
						String loginToken = cookies[i].getValue();
						MDSUserVerificationHelper mdsUserVerificationHelper = new MDSUserVerificationHelper();
						mdsUserVerificationHelper.mdsDomain = mdsDomain;
						// verify if user valid
						int status = mdsUserVerificationHelper.getObjectAccessorValue(loginToken);
						result = (status == 200);
						// if yes set principal for this user as valid
						if (result == true) {
							UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(
									loginToken, loginToken, AuthorityUtils.createAuthorityList("USER"));
							org.springframework.security.core.context.SecurityContextHolder.getContext().setAuthentication(token);									
						} else {
							UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(
									"anonymousUser", "anonymousUser", AuthorityUtils.createAuthorityList("USER"));
							org.springframework.security.core.context.SecurityContextHolder.getContext().setAuthentication(token);									
						}
						break;
					}
				}
			}
		} catch (Exception ex) {
			
		}
		return result;
	}				
	
	public static boolean is_user_logged_in() {
		Object  principal = org.springframework.security.core.context.SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		boolean result = true;
		if(principal == null) result = false;
		if((principal instanceof String) && "anonymousUser".equals(principal)) result = false;
		if((principal instanceof String) && !"anonymousUser".equals(principal)) result = true;
		return result;
	}
}
