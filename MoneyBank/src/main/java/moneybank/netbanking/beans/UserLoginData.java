package moneybank.netbanking.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.beans.factory.annotation.Value;

@Entity
@Table(name = "Login_Mapping")
public class UserLoginData {
	
@Id
@Column(name = "username")
String username;

@Column(name = "password")
String password;

@Column(name = "role")	
String role;
@Column(name = "isActive")

boolean isActive=true;

public boolean isActive() {
	return isActive;
}
public void setActive(boolean isActive) {
	this.isActive = isActive;
}
public String getRole() {
	return role;
}
public void setRole(String role) {
	this.role = role;
}
public String getUsername() {
	return username;
}
public void setUsername(String username) {
	this.username = username;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
@Override
public String toString() {
	return "UserLoginData [username=" + username + ", password=" + password + ", role=" + role + ", isActive="
			+ isActive + "]";
}

}
