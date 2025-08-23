package com.student.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {

  @Autowired LoginService loginService;

  @PostMapping(
      path = "/api/auth/login",
      consumes = {"application/json", "application/xml"},
      produces = {"application/json", "application/xml"})
  public LoginResponse validate(@RequestBody LoginRequest loginRequest) {

    return loginService.validateUser(loginRequest);
  }
}
