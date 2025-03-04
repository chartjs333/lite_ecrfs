package net.mdsgene.admin.dto;

public class ChangePasswordDTO {
    private String currentPassword;
    private String newPassword;
    private String confirmNewPassword;

    // ... конструкторы, геттеры и сеттеры ...
    public String getCurrentPassword() {
        return currentPassword;
    }
    public void setCurrentPassword(String currentPassword) {
        this.currentPassword = currentPassword;
    }
    public String getNewPassword() {
        return newPassword;
    }
    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }
    public String getConfirmNewPassword() {
        return confirmNewPassword;
    }
    public void setConfirmNewPassword(String confirmNewPassword) {
        this.confirmNewPassword = confirmNewPassword;
    }

    // Добавляем новый метод для проверки совпадения паролей
    public boolean isPasswordConfirmed() {
        return newPassword != null && newPassword.equals(confirmNewPassword);
    }
}
