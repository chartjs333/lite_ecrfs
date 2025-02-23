package net.mdsgene.admin.admintool.entities;

import com.xdev.dal.DAO;
import com.xdev.util.Caption;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * User
 */
@Component 
@Scope(value="session", proxyMode = org.springframework.context.annotation.ScopedProxyMode.TARGET_CLASS)
@Caption("{%email}")
@Entity
@Table(name = "users", schema = "public", uniqueConstraints = { @UniqueConstraint(columnNames = "username"),
		@UniqueConstraint(columnNames = "reset_password_token") })
public class User implements Serializable {

	private int id;
	private String username;
	private String role;
	private String firstname;
	private String lastname;
	private boolean passwordChanged;
	private String password;
	private String resetPasswordToken;
	private Date resetPasswordSentAt;
	private Date rememberCreatedAt;
	private int signInCount;
	private Date currentSignInAt;
	private Date lastSignInAt;
//	private Serializable currentSignInIp;
//	private Serializable lastSignInIp;
	private Date createdAt;
	private Date updatedAt;
	private boolean active;

	public User() {
	}

	@Caption("Id")
	@Id

	@Column(name = "id", unique = true, nullable = false, columnDefinition = "serial")
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Caption("Username")
	@Column(name = "username", unique = true, nullable = false, columnDefinition = "varchar")
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
	

	@Caption("Role")
	@Column(name = "role", unique = false, nullable = false, columnDefinition = "varchar")
	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}	

	@Caption("Firstname")
	@Column(name = "firstname", nullable = false, columnDefinition = "varchar")
	public String getFirstname() {
		return this.firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	@Caption("Lastname")
	@Column(name = "lastname", nullable = false, columnDefinition = "varchar")
	public String getLastname() {
		return this.lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	@Caption("PasswordChanged")
	@Column(name = "password_changed", nullable = false, columnDefinition = "bool")
	public boolean isPasswordChanged() {
		return this.passwordChanged;
	}

	public void setPasswordChanged(boolean passwordChanged) {
		this.passwordChanged = passwordChanged;
	}

	@Caption("Password")
	@Column(name = "password", nullable = false, columnDefinition = "varchar")
	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Caption("ResetPasswordToken")
	@Column(name = "reset_password_token", unique = true, columnDefinition = "varchar")
	public String getResetPasswordToken() {
		return this.resetPasswordToken;
	}

	public void setResetPasswordToken(String resetPasswordToken) {
		this.resetPasswordToken = resetPasswordToken;
	}

	@Caption("ResetPasswordSentAt")
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "reset_password_sent_at", columnDefinition = "timestamp", length = 29)
	public Date getResetPasswordSentAt() {
		return this.resetPasswordSentAt;
	}

	public void setResetPasswordSentAt(Date resetPasswordSentAt) {
		this.resetPasswordSentAt = resetPasswordSentAt;
	}

	@Caption("RememberCreatedAt")
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "remember_created_at", columnDefinition = "timestamp", length = 29)
	public Date getRememberCreatedAt() {
		return this.rememberCreatedAt;
	}

	public void setRememberCreatedAt(Date rememberCreatedAt) {
		this.rememberCreatedAt = rememberCreatedAt;
	}

	@Caption("SignInCount")
	@Column(name = "sign_in_count", nullable = false, columnDefinition = "int4")
	public int getSignInCount() {
		return this.signInCount;
	}

	public void setSignInCount(int signInCount) {
		this.signInCount = signInCount;
	}

	@Caption("CurrentSignInAt")
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "current_sign_in_at", columnDefinition = "timestamp", length = 29)
	public Date getCurrentSignInAt() {
		return this.currentSignInAt;
	}

	public void setCurrentSignInAt(Date currentSignInAt) {
		this.currentSignInAt = currentSignInAt;
	}

	@Caption("LastSignInAt")
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "last_sign_in_at", columnDefinition = "timestamp", length = 29)
	public Date getLastSignInAt() {
		return this.lastSignInAt;
	}

	public void setLastSignInAt(Date lastSignInAt) {
		this.lastSignInAt = lastSignInAt;
	}

//	@Caption("CurrentSignInIp")
//	@Column(name = "current_sign_in_ip", columnDefinition = "inet")
//	public Serializable getCurrentSignInIp() {
//		return this.currentSignInIp;
//	}
//
//	public void setCurrentSignInIp(Serializable currentSignInIp) {
//		this.currentSignInIp = currentSignInIp;
//	}
//
//	@Caption("LastSignInIp")
//	@Column(name = "last_sign_in_ip", columnDefinition = "inet")
//	public Serializable getLastSignInIp() {
//		return this.lastSignInIp;
//	}
//
//	public void setLastSignInIp(Serializable lastSignInIp) {
//		this.lastSignInIp = lastSignInIp;
//	}

	@Caption("CreatedAt")
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "created_at", nullable = false, columnDefinition = "timestamp", length = 29)
	public Date getCreatedAt() {
		return this.createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	@Caption("UpdatedAt")
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "updated_at", nullable = false, columnDefinition = "timestamp", length = 29)
	public Date getUpdatedAt() {
		return this.updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

	@Caption("Active")
	@Column(name = "active", nullable = false, columnDefinition = "bool")
	public boolean isActive() {
		return this.active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

}
