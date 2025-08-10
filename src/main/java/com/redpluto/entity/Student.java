package com.redpluto.entity;

import org.springframework.stereotype.Component;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

@Entity
@Component
@Table
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long studentId;

    @NotBlank(message = "Student name is required")
    @Size(min = 2, max = 50, message = "Student name must be between 2 and 50 characters")
    @Pattern(regexp = "^[A-Za-z ]+$", message = "Student name must contain only letters and spaces")
    private String studentName;

    @Min(value = 5, message = "Age must be at least 5")
    @Max(value = 100, message = "Age must be less than or equal to 100")
    private int age;

    @Min(value = 0, message = "Marks must be at least 0")
    @Max(value = 100, message = "Marks cannot be more than 100")
    private int englishMarks;

    @Min(value = 0, message = "Marks must be at least 0")
    @Max(value = 100, message = "Marks cannot be more than 100")
    private int scienceMarks;

    @Min(value = 0, message = "Marks must be at least 0")
    @Max(value = 100, message = "Marks cannot be more than 100")
    private int mathMarks;

    @Min(value = 0, message = "Marks must be at least 0")
    @Max(value = 100, message = "Marks cannot be more than 100")
    private int historyMarks;

    @Min(value = 0, message = "Marks must be at least 0")
    @Max(value = 100, message = "Marks cannot be more than 100")
    private int hindiMarks;

    public static Student getInstance() {
	return new Student();
    }

    public Long getStudentId() {
	return studentId;
    }

    public Student setStudentId(Long studentId) {
	this.studentId = studentId;
	return this;
    }

    public String getStudentName() {
	return studentName;
    }

    public Student setStudentName(String studentName) {
	this.studentName = studentName;
	return this;
    }

    public int getAge() {
	return age;
    }

    public Student setAge(int age) {
	this.age = age;
	return this;
    }

    public int getEnglishMarks() {
	return englishMarks;
    }

    public Student setEnglishMarks(int englishMarks) {
	this.englishMarks = englishMarks;
	return this;
    }

    public int getScienceMarks() {
	return scienceMarks;
    }

    public Student setScienceMarks(int scienceMarks) {
	this.scienceMarks = scienceMarks;
	return this;
    }

    public int getMathMarks() {
	return mathMarks;
    }

    public Student setMathMarks(int mathMarks) {
	this.mathMarks = mathMarks;
	return this;
    }

    public int getHistoryMarks() {
	return historyMarks;
    }

    public Student setHistoryMarks(int historyMarks) {
	this.historyMarks = historyMarks;
	return this;
    }

    public int getHindiMarks() {
	return hindiMarks;
    }

    public Student setHindiMarks(int hindiMarks) {
	this.hindiMarks = hindiMarks;
	return this;
    }

    @Override
    public String toString() {
	return "Student [studentId=" + studentId + ", studentName=" + studentName + ", age=" + age + ", englishMarks="
		+ englishMarks + ", scienceMarks=" + scienceMarks + ", mathMarks=" + mathMarks + ", historyMarks="
		+ historyMarks + ", hindiMarks=" + hindiMarks + "]";
    }

}
