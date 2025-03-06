package net.mdsgene.admin.web;

import net.mdsgene.admin.admintool.business.UserService;
import net.mdsgene.admin.dto.ChangePasswordDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

@Controller
public class ChangePasswordController {
    
    @Autowired
    private UserService userService;

    // Отображение формы изменения пароля
    @GetMapping("/change-password")
    public String showChangePasswordForm(Model model) {
        model.addAttribute("changePasswordDTO", new ChangePasswordDTO());
        return "changePassword";
    }

    // Обработка отправки формы
    @PostMapping("/change-password")
    public String handleChangePassword(@ModelAttribute("changePasswordDTO") ChangePasswordDTO dto, Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentUsername = authentication.getName();
        
        // Check if passwords match
        if (!dto.isPasswordConfirmed()) {
            model.addAttribute("error", "New password and confirmation do not match");
            return "changePassword";
        }
        
        // Validate new password
        if (!isPasswordValid(dto.getNewPassword())) {
            model.addAttribute("error", "Password does not meet requirements");
            return "changePassword";
        }
        
        try {
            // Change password
            boolean changed = userService.changePassword(currentUsername, 
                                                       dto.getCurrentPassword(), 
                                                       dto.getNewPassword());
            if (changed) {
                return "redirect:/survey"; // Redirect to survey page after successful change
            } else {
                model.addAttribute("error", "Failed to change password. Please check your current password");
            }
        } catch (Exception e) {
            model.addAttribute("error", "An error occurred while changing password: " + e.getMessage());
        }
        
        return "changePassword";
    }

    private boolean isPasswordValid(String password) {
        // Password must be 12-16 characters long
        if (password.length() < 12 || password.length() > 16) {
            return false;
        }
        
        // Must contain at least one uppercase letter
        if (!password.matches(".*[A-Z].*")) {
            return false;
        }
        
        // Must contain at least one lowercase letter
        if (!password.matches(".*[a-z].*")) {
            return false;
        }
        
        // Must contain at least one number
        if (!password.matches(".*[0-9].*")) {
            return false;
        }
        
        // Must contain at least one special character (!@#$%^*-_)
        if (!password.matches(".*[!@#$%^*\\-_].*")) {
            return false;
        }
        
        return true;
    }
}
