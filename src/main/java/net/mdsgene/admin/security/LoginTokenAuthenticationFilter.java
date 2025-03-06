package net.mdsgene.admin.security;

import net.mdsgene.admin.admintool.business.UserService;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoginTokenAuthenticationFilter extends OncePerRequestFilter {

    private final UserService userService;

    public LoginTokenAuthenticationFilter(UserService userService) {
        this.userService = userService;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, 
                                  HttpServletResponse response, 
                                  FilterChain filterChain) 
            throws ServletException, IOException {
        
        // Пропускаем, если пользователь уже аутентифицирован
        if (SecurityContextHolder.getContext().getAuthentication() != null &&
            SecurityContextHolder.getContext().getAuthentication().isAuthenticated() &&
            !"anonymousUser".equals(SecurityContextHolder.getContext().getAuthentication().getPrincipal())) {
            filterChain.doFilter(request, response);
            return;
        }

        // Проверяем куки
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("loginToken")) {
                    String loginToken = cookie.getValue();
                    try {
                        // Проверяем токен через UserService
                        userService.loadUserByUsername(loginToken);
                        
                        // Если пользователь найден, создаем новый токен аутентификации
                        UsernamePasswordAuthenticationToken authentication = 
                            new UsernamePasswordAuthenticationToken(
                                loginToken,
                                null,
                                AuthorityUtils.createAuthorityList("USER")
                            );
                        
                        SecurityContextHolder.getContext().setAuthentication(authentication);
                        break;
                    } catch (Exception e) {
                        // Если токен невалидный, удаляем куки
                        cookie.setMaxAge(0);
                        response.addCookie(cookie);
                    }
                }
            }
        }

        filterChain.doFilter(request, response);
    }
}