package com.redpluto.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class StudentRequest {

  @NotBlank(message = "Student name is required")
  @Size(min = 3, max = 50, message = "Student name must be between 2 and 50 characters")
  private String studentName;

  @Min(value = 5, message = "Age must be at least 5")
  @Max(value = 25, message = "Age must not exceed 25")
  private int age;

  @Min(value = 0, message = "English marks must be at least 0")
  @Max(value = 100, message = "English marks must not exceed 100")
  private int englishMarks;

  @Min(value = 0, message = "Science marks must be at least 0")
  @Max(value = 100, message = "Science marks must not exceed 100")
  private int scienceMarks;

  @Min(value = 0, message = "Math marks must be at least 0")
  @Max(value = 100, message = "Math marks must not exceed 100")
  private int mathMarks;

  @Min(value = 0, message = "History marks must be at least 0")
  @Max(value = 100, message = "History marks must not exceed 100")
  private int historyMarks;

  @Min(value = 0, message = "Hindi marks must be at least 0")
  @Max(value = 100, message = "Hindi marks must not exceed 100")
  private int hindiMarks;

  private double percentage;
  private String division;

  public StudentRequest() {}

  private StudentRequest(Builder builder) {
    this.studentName = builder.studentName;
    this.age = builder.age;
    this.englishMarks = builder.englishMarks;
    this.scienceMarks = builder.scienceMarks;
    this.mathMarks = builder.mathMarks;
    this.historyMarks = builder.historyMarks;
    this.hindiMarks = builder.hindiMarks;
    this.percentage = builder.percentage;
    this.division = builder.division;
  }

  public String getStudentName() {
    return studentName;
  }

  public int getAge() {
    return age;
  }

  public int getEnglishMarks() {
    return englishMarks;
  }

  public int getScienceMarks() {
    return scienceMarks;
  }

  public int getMathMarks() {
    return mathMarks;
  }

  public int getHistoryMarks() {
    return historyMarks;
  }

  public int getHindiMarks() {
    return hindiMarks;
  }

  public double getPercentage() {
    return percentage;
  }

  public String getDivision() {
    return division;
  }

  public void setPercentage(double percentage) {
    this.percentage = percentage;
  }

  public void setDivision(String division) {
    this.division = division;
  }

  public static class Builder {

    private String studentName;
    private int age;
    private int englishMarks;
    private int scienceMarks;
    private int mathMarks;
    private int historyMarks;
    private int hindiMarks;
    private double percentage;
    private String division;

    public Builder studentName(String studentName) {
      this.studentName = studentName;
      return this;
    }

    public Builder age(int age) {
      this.age = age;
      return this;
    }

    public Builder englishMarks(int englishMarks) {
      this.englishMarks = englishMarks;
      return this;
    }

    public Builder scienceMarks(int scienceMarks) {
      this.scienceMarks = scienceMarks;
      return this;
    }

    public Builder mathMarks(int mathMarks) {
      this.mathMarks = mathMarks;
      return this;
    }

    public Builder historyMarks(int historyMarks) {
      this.historyMarks = historyMarks;
      return this;
    }

    public Builder hindiMarks(int hindiMarks) {
      this.hindiMarks = hindiMarks;
      return this;
    }

    public Builder percentage(double percentage) {
      this.percentage = percentage;
      return this;
    }

    public Builder division(String division) {
      this.division = division;
      return this;
    }

    public StudentRequest build() {
      return new StudentRequest(this);
    }
  }

  public static Builder getInstance() {
    return new Builder();
  }

  @Override
  public String toString() {
    return "StudentRequest [studentName="
        + studentName
        + ", age="
        + age
        + ", englishMarks="
        + englishMarks
        + ", scienceMarks="
        + scienceMarks
        + ", mathMarks="
        + mathMarks
        + ", historyMarks="
        + historyMarks
        + ", hindiMarks="
        + hindiMarks
        + ", percentage="
        + percentage
        + ", division="
        + division
        + "]";
  }
}
