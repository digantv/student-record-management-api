package com.redpluto.dto;

public class StudentResponse {

  private String message;
  private Long studentId;
  private StudentRequest studentDetails;
  private int statusCode;

  public StudentResponse() {}

  public static StudentResponse getInstance() {
    return new StudentResponse();
  }

  public String getMessage() {
    return message;
  }

  public StudentResponse setMessage(String message) {
    this.message = message;
    return this;
  }

  public Long getStudentId() {
    return studentId;
  }

  public StudentResponse setStudentId(Long studentId) {
    this.studentId = studentId;
    return this;
  }

  public StudentRequest getStudentDetails() {
    return studentDetails;
  }

  public StudentResponse setStudentDetails(StudentRequest studentDetails) {
    this.studentDetails = studentDetails;
    return this;
  }

  public int getStatusCode() {
    return statusCode;
  }

  public StudentResponse setStatusCode(int statusCode) {
    this.statusCode = statusCode;
    return this;
  }
}
