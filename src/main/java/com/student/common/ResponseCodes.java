package com.student.common;

public enum ResponseCodes {
  LOGIN_SUCCESS("Success", "Login successful"),
  LOGIN_FAIL("Fail", "Login failed"),
  USER_ADDED("Success", "User added successfuly"),
  USER_SEARCH("Success", "User found successfully"),
  USER_NOT_FOUND("Fail", "User not found");

  private final String status;
  private final String message;

  ResponseCodes(String status, String message) {
    this.status = status;
    this.message = message;
  }

  public String getStatus() {
    return status;
  }

  public String getMessage() {
    return message;
  }
}
