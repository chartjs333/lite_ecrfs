package net.mdsgene.admin;

import org.apache.catalina.connector.Connector;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.web.client.RestTemplate;

import net.mdsgene.admin.admintool.business.UserService;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	@Autowired
	private UserService userService;

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
				.authorizeRequests()
				.antMatchers("/map").permitAll() // Разрешаем доступ ко всем пользователям без авторизации на /map
				.antMatchers("/d/0/gu/0").permitAll() // Разрешаем доступ ко всем пользователям без авторизации на /d/0/gu/0
				.antMatchers("/**/*").permitAll()
				.and()
				.formLogin()
				.loginPage("/user/sign_in")
				.defaultSuccessUrl("/survey", true)
				.failureUrl("/user/sign_in?error").permitAll()
				.and()
				.logout().logoutRequestMatcher(new AntPathRequestMatcher("/user/sign_out"))
				.logoutSuccessUrl("/user/sign_out_clean").permitAll()
				.and()
				.rememberMe().key(userService.getApplicationSecret())
				.tokenValiditySeconds(31536000);

		http.csrf().ignoringAntMatchers("/**/*", "/d/0/gu/0/");
	}

	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
}
