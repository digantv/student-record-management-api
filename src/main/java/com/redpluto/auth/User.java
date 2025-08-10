package com.redpluto.auth;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonInclude;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Component
@Table(name = "users")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class User {
    @GeneratedValue // Auto generated (DB => sequence), primary key
    @Id
    @Column(name = "userCode", nullable = false, updatable = false, insertable = false)
    private long userCode;
    @Column(name = "userId", nullable = false, updatable = false)
    private long userId;
    @Column(name = "username", nullable = false, length = 50)
    private String username;
    @Column
    private String password;

    public long getUserCode() {
	return userCode;
    }

    public void setUserCode(long userCode) {
	this.userCode = userCode;
    }

    public long getUserId() {
	return userId;
    }

    public void setUserId(long userId) {
	this.userId = userId;
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
	return "User [userCode=" + userCode + ", userId=" + userId + ", username=" + username + ", password=" + password
		+ "]";
    }

}