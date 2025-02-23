package net.mdsgene.admin.controllers;

import net.mdsgene.admin.WebSecurityConfig;
import net.mdsgene.admin.admintool.business.MDSUserVerificationHelper;
import net.mdsgene.admin.admintool.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;


@Controller
@EnableWebSecurity
public class UserController {
	@Autowired
	User user;

	@Autowired
	WebSecurityConfig ws;

	@Autowired
	MDSUserVerificationHelper mdsUserVerificationHelper;

	@Autowired
	CrossroadController crossroadController;

	@PersistenceContext
    private EntityManager em;


	/**
	 * This method will read the information from the url.
	 * 1. If there is the parameter IntegratedLoginToken presented.
	 * 		1.1 Create the cookies with the name "loginToken"
	 *		1.2 Add user to the session
	 * @param model
	 * @param integratedLoginToken
	 * @param webServiceURL
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@GetMapping("/user/sign_in")
	public String signIn(ModelMap model, @RequestParam(name="IntegratedLoginToken",required = false) String integratedLoginToken,
			@RequestParam(name="WebServiceURL",required = false) String webServiceURL,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		//check login from the prompt line
		if (null != integratedLoginToken) {
			javax.servlet.http.Cookie cookie = new javax.servlet.http.Cookie("loginToken", integratedLoginToken);
			cookie.setMaxAge(604800);
			cookie.setPath("/");
			response.addCookie(cookie);

			Authentication auth =
				      new UsernamePasswordAuthenticationToken(integratedLoginToken, integratedLoginToken,
				    	        AuthorityUtils.createAuthorityList("USER"));
			ws.userDetailsServiceBean().loadUserByUsername(integratedLoginToken);
			ws.authenticationManagerBean().authenticate(auth);
			SecurityContextHolder.getContext().setAuthentication(auth);
//			SecurityContextHolder.getContext().getAuthentication().getPrincipal()

			//init variables for this page
			crossroadController.gene4disease(model);
			return "crossroad/gene4disease";
		}
		//redirect to members login screen
		model.addAttribute("user", user);
		return "user/sign_in";
	}

	public List<Cookie> getCookie(HttpServletRequest request, String name) {
		List<Cookie> cookies = new ArrayList<>();
	    if (request.getCookies() != null) {
	      for (Cookie cookie : request.getCookies()) {
	        if (cookie.getName().equals(name)) {
	        	cookies.add(cookie);
	        }
	      }
	    }

	    return cookies;
	}

	@GetMapping("/user/sign_out_clean")
	public String signOut(ModelMap model,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		List<Cookie> loginTokens = getCookie(request, "loginToken");
//		if (!loginTokens.isEmpty()) {
//			loginTokens.forEach(loginToken -> {
//				try {
//					mdsUserVerificationHelper.deleteToken(loginToken.getValue());
//				} catch (Exception e) {
//				}
//			});
//			eraseCookie(request, response);
//		}
		model.addAttribute("user", user);
		return "user/sign_in";
	}

	private void eraseCookie(HttpServletRequest req, HttpServletResponse resp) {
	    Cookie[] cookies = req.getCookies();
	    if (cookies != null)
	        for (Cookie cookie : cookies) {
	        	if (cookie.getName().equals("loginToken")) {
		            cookie.setMaxAge(0);
		            resp.addCookie(cookie);
	        	}
	        }
	}

//
//	@GetMapping("/user/sign_in_mds")
//	public String signInFrom(ModelMap model) throws Exception {
//
//		${@environment.getProperty('mds.login.url')}
//		model.addAttribute("user", user);
//		return "user/sign_in_from";
//	}

}
