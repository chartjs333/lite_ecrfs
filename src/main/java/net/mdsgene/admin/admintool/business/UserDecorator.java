package net.mdsgene.admin.admintool.business;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

@Component
public class UserDecorator {
    @Autowired
    private UserService userService;

    public boolean is_user_logged_in(HttpServletRequest req, String mdsDomain) {
        // Проверяем текущую аутентификацию
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (principal != null && !(principal instanceof String && "anonymousUser".equals(principal))) {
            return true;
        }

        // Если не аутентифицирован, проверяем куки
        try {
            Cookie[] cookies = req.getCookies();
            if (cookies != null) {
                for (Cookie cookie : cookies) {
                    if (cookie.getName().equals("loginToken")) {
                        String loginToken = cookie.getValue();
                        // Проверяем токен через UserService
                        try {
                            userService.loadUserByUsername(loginToken);
                            // Если пользователь найден, создаем новый токен аутентификации
                            UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(
                                loginToken, 
                                null, // credentials можно оставить null, так как аутентификация уже проверена
                                AuthorityUtils.createAuthorityList("USER")
                            );
                            SecurityContextHolder.getContext().setAuthentication(token);
                            return true;
                        } catch (Exception e) {
                            // Если пользователь не найден, устанавливаем анонимную аутентификацию
                            SecurityContextHolder.getContext().setAuthentication(
                                new UsernamePasswordAuthenticationToken(
                                    "anonymousUser",
                                    null,
                                    AuthorityUtils.createAuthorityList("ROLE_ANONYMOUS")
                                )
                            );
                        }
                        break;
                    }
                }
            }
        } catch (Exception ex) {
            // Логирование ошибки если нужно
        }
        return false;
    }

    public static boolean is_user_logged_in() {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return principal != null && 
               !(principal instanceof String && "anonymousUser".equals(principal));
    }
}
