package net.mdsgene.admin.admintool.business;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Calendar;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import net.mdsgene.admin.admintool.dal.IUserDAO;
import net.mdsgene.admin.admintool.entities.User;

@Service
public class UserService implements UserDetailsService {
    @Value("${app.secret}") // some random stuff
    private String applicationSecret;

    @Autowired
    private IUserDAO userDAO;

    @Autowired
    private MDSUserVerificationHelper mdsUserVerificationHelper;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public final String CURRENT_USER_KEY = "CURRENT_USER";

    /**
     * A utility class for building parameter strings for HTTP requests.
     */
    public static class ParameterStringBuilder {
        public String getParamsString(Map<String, String> params)
                throws UnsupportedEncodingException {
            StringBuilder result = new StringBuilder();

            for (Map.Entry<String, String> entry : params.entrySet()) {
                result.append(URLEncoder.encode(entry.getKey(), "UTF-8"));
                result.append("=");
                result.append(URLEncoder.encode(entry.getValue(), "UTF-8"));
                result.append("&");
            }

            String resultString = result.toString();
            return resultString.length() > 0
                    ? resultString.substring(0, resultString.length() - 1)
                    : resultString;
        }
    }

    /**
     * Loads a user by their username.
     *
     * @param username the username to load the user by
     * @return the UserDetails object representing the loaded user
     * @throws UsernameNotFoundException if the user is not found
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = null;
        if (null != username && username.contains("@")) {
            user = userDAO.findOneByUsername(username);
        } else {
            try {
                int status = mdsUserVerificationHelper.getObjectAccessorValue(username);
                if (status == 200) {
                    user = new User();
                    user.setUsername("mds-member");
                    user.setPassword(username); // which is loginToken in this case;
                    user.setRole("USER");
                }
            } catch (Exception ex) {
                user = null;
            }
        }

        if (user == null) {
            throw new UsernameNotFoundException(username);
        }

        List<GrantedAuthority> auth = AuthorityUtils.commaSeparatedStringToAuthorityList(user.getRole());
        return new org.springframework.security.core.userdetails.User(
                user.getUsername().toLowerCase(),
                user.getPassword(),
                true, // enabled. Use whatever condition you like
                true, // accountNonExpired. Use whatever condition you like
                true, // credentialsNonExpired. Use whatever condition you like
                true, // accountNonLocked. Use whatever condition you like
                auth);
    }

    /**
     * Меняем пароль пользователя, если совпадает текущий.
     */
    public boolean changePassword(String username, String currentPassword, String newPassword) {
        User user = userDAO.findOneByUsername(username);
        if (user == null) {
            return false;
        }
        // Проверяем текущий пароль (хранимый пароль vs. currentPassword)
        if (!passwordEncoder.matches(currentPassword, user.getPassword())) {
            return false;
        }
        user.setPassword(passwordEncoder.encode(newPassword));
		user.setPasswordChanged(true);
		user.setResetPasswordSentAt(Calendar.getInstance().getTime());
        userDAO.save(user);
        return true;
    }

    public String getApplicationSecret() {
        return applicationSecret;
    }

}
