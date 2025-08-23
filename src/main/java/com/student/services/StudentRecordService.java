package com.student.services;

import com.student.dto.StudentRequest;
import com.student.dto.StudentResponse;
import com.student.entity.Student;
import com.student.repository.StudentRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;

@Service
public class StudentRecordService {
  private final StudentRepository studentRepository;

  public StudentRecordService(StudentRepository studentRepository) {
    this.studentRepository = studentRepository;
  }

  public StudentResponse createStudent(StudentRequest request) {

    Student student =
        Student.getInstance()
            .setStudentName(request.getStudentName())
            .setAge(request.getAge())
            .setEnglishMarks(request.getEnglishMarks())
            .setHindiMarks(request.getHindiMarks())
            .setHistoryMarks(request.getHistoryMarks())
            .setMathMarks(request.getMathMarks())
            .setScienceMarks(request.getScienceMarks());

    Student savedStudent = studentRepository.save(student);
    double percentage =
        (savedStudent.getEnglishMarks()
                + savedStudent.getScienceMarks()
                + savedStudent.getMathMarks()
                + savedStudent.getHistoryMarks()
                + savedStudent.getHindiMarks())
            / 5.0;
    String division;
    if (percentage >= 60) {
      division = "First Division";
    } else if (percentage >= 50) {
      division = "Second Division";
    } else {
      division = "Fail";
    }
    StudentRequest requestData =
        new StudentRequest.Builder()
            .studentName(savedStudent.getStudentName())
            .age(savedStudent.getAge())
            .englishMarks(savedStudent.getEnglishMarks())
            .hindiMarks(savedStudent.getHindiMarks())
            .historyMarks(savedStudent.getHistoryMarks())
            .mathMarks(savedStudent.getMathMarks())
            .scienceMarks(savedStudent.getScienceMarks())
            .percentage(percentage)
            .division(division)
            .build();

    return StudentResponse.getInstance()
        .setStudentId(savedStudent.getStudentId())
        .setStudentDetails(requestData)
        .setMessage("Student created successfully")
        .setStatusCode(200);
  }

  public List<StudentRequest> getAllStudents() {
    List<Student> students = studentRepository.findAll();
    List<StudentRequest> studentRequests =
        students.stream()
            .map(
                s -> {
                  double percentage =
                      (s.getEnglishMarks()
                              + s.getScienceMarks()
                              + s.getMathMarks()
                              + s.getHistoryMarks()
                              + s.getHindiMarks())
                          / 5.0;

                  String division;
                  if (percentage >= 60) {
                    division = "First Division";
                  } else if (percentage >= 50) {
                    division = "Second Division";
                  } else {
                    division = "Fail";
                  }

                  return StudentRequest.getInstance()
                      .studentName(s.getStudentName())
                      .age(s.getAge())
                      .englishMarks(s.getEnglishMarks())
                      .scienceMarks(s.getScienceMarks())
                      .mathMarks(s.getMathMarks())
                      .historyMarks(s.getHistoryMarks())
                      .hindiMarks(s.getHindiMarks())
                      .percentage(percentage)
                      .division(division)
                      .build();
                })
            .toList();

    return studentRequests;
  }

  public StudentResponse updateStudent(Long id, StudentRequest request) {
    Optional<Student> optionalStudent = studentRepository.findById(id);
    if (optionalStudent.isEmpty()) {
      return null;
    }

    Student student = optionalStudent.get();

    student.setStudentName(request.getStudentName());
    student.setAge(request.getAge());
    student.setEnglishMarks(request.getEnglishMarks());
    student.setScienceMarks(request.getScienceMarks());
    student.setMathMarks(request.getMathMarks());
    student.setHistoryMarks(request.getHistoryMarks());
    student.setHindiMarks(request.getHindiMarks());

    Student updatedStudent = studentRepository.save(student);

    double percentage =
        (updatedStudent.getEnglishMarks()
                + updatedStudent.getScienceMarks()
                + updatedStudent.getMathMarks()
                + updatedStudent.getHistoryMarks()
                + updatedStudent.getHindiMarks())
            / 5.0;

    String division;
    if (percentage >= 60) {
      division = "First Division";
    } else if (percentage >= 50) {
      division = "Second Division";
    } else {
      division = "Fail";
    }

    StudentRequest responseRequest =
        StudentRequest.getInstance()
            .studentName(updatedStudent.getStudentName())
            .age(updatedStudent.getAge())
            .englishMarks(updatedStudent.getEnglishMarks())
            .scienceMarks(updatedStudent.getScienceMarks())
            .mathMarks(updatedStudent.getMathMarks())
            .historyMarks(updatedStudent.getHistoryMarks())
            .hindiMarks(updatedStudent.getHindiMarks())
            .percentage(percentage)
            .division(division)
            .build();

    return StudentResponse.getInstance()
        .setStudentId(updatedStudent.getStudentId())
        .setStudentDetails(responseRequest)
        .setMessage("Student updated successfully")
        .setStatusCode(200);
  }

  public boolean deleteStudentById(Long id) {
    Optional<Student> studentOpt = studentRepository.findById(id);
    if (studentOpt.isPresent()) {
      studentRepository.deleteById(id);
      return true;
    }
    return false;
  }
}
