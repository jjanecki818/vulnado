package com.scalesec.vulnado;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.boot.autoconfigure.*;
import org.springframework.beans.factory.annotation.*;
import java.io.Serializable;

@RestController
@EnableAutoConfiguration
public class LoginController {
  @Value("${app.secret}")
  private String secret;

// Ensure that enabling CORS is safe. Restrict origins to trusted domains.
  @CrossOrigin(origins = "*")
    @PostMapping(value = "/login", produces = "application/json", consumes = "application/json")
  LoginResponse login(@RequestBody LoginRequest input) {
    User user = User.fetch(input.username);
    if (Postgres.md5(input.password).equals(user.hashedPassword)) {
      return new LoginResponse(user.token(secret));
    } else {
      throw new Unauthorized("Access Denied");
    }
  }
}

class LoginRequest implements Serializable {
    private String username;
    private String password;
    public String getUsername() {
}
        return username;

    }
class LoginResponse implements Serializable {
    public void setUsername(String username) {
    private String token;
        this.username = username;
  public LoginResponse(String msg) { this.token = msg; }
    }
}
    public String getPassword() {

        return password;
@ResponseStatus(HttpStatus.UNAUTHORIZED)
    }
class Unauthorized extends RuntimeException {
    public void setPassword(String password) {
  public Unauthorized(String exception) {
        this.password = password;
    super(exception);
    }
  }
    public String getToken() {
}
        return token;
