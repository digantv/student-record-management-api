package com.redpluto.controller;

import com.redpluto.dto.StudentRequest;
import com.redpluto.dto.StudentResponse;
import com.redpluto.services.StudentRecordService;
import jakarta.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Component
@RestController
@RequestMapping("/api/students")
public class StudentController {
  private final StudentRecordService studentService;

  public StudentController(StudentRecordService studentService) {
    this.studentService = studentService;
  }

  @PostMapping
  public ResponseEntity<StudentResponse> createStudent(@Valid @RequestBody StudentRequest request) {

    StudentResponse response = studentService.createStudent(request);
    return ResponseEntity.status(response.getStatusCode()).body(response);
  }

  @GetMapping
  public ResponseEntity<?> getAllStudents() {
    List<StudentRequest> students = studentService.getAllStudents();
    if (students.isEmpty()) {
      Map<String, String> response = new HashMap<>();
      response.put("message", "No students found");
      return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
    }
    return ResponseEntity.ok(students);
  }

  @PutMapping("/{id}")
  public ResponseEntity<?> updateStudent(
      @PathVariable Long id, @RequestBody @Valid StudentRequest request) {
    StudentResponse response = studentService.updateStudent(id, request);
    if (response == null) {
      Map<String, String> error = new HashMap<>();
      error.put("message", "Student with ID " + id + " not found");
      return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
    }
    return ResponseEntity.ok(response);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<?> deleteStudent(@PathVariable Long id) {
    boolean deleted = studentService.deleteStudentById(id);
    if (deleted) {
      return ResponseEntity.ok(Map.of("message", "Student deleted successfully"));
    } else {
      return ResponseEntity.status(HttpStatus.NOT_FOUND)
          .body(Map.of("message", "Student not found"));
    }
  }
}
