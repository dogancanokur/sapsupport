package net.okur.blog.service.input;

import lombok.Data;

@Data
public class UserInput {
  private String name;
  private String surname;
  private String username;
  private String email;
  private String password;
  private String profileInfo;
}
