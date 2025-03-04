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
        // Получаем текущего пользователя из контекста безопасности
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentUsername = authentication.getName();
        
        // Проверка совпадения паролей
        if (!dto.isPasswordConfirmed()) {
            model.addAttribute("error", "Новый пароль и подтверждение не совпадают");
            return "changePassword";
        }
        
        try {
            // Вызываем сервис для смены пароля текущего пользователя
            boolean changed = userService.changePassword(currentUsername, 
                                                         dto.getCurrentPassword(), 
                                                         dto.getNewPassword());
            if (changed) {
                model.addAttribute("message", "Пароль успешно изменён");
            } else {
                model.addAttribute("error", "Не удалось изменить пароль. Проверьте введенный текущий пароль");
            }
        } catch (Exception e) {
            model.addAttribute("error", "Произошла ошибка при смене пароля: " + e.getMessage());
        }
        
        return "changePassword";
    }
}
