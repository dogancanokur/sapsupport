package net.okur.blog.controller.request;

import lombok.Data;

@Data
public class UserRequest {
  private String name;
  private String surname;
  private String username;
  private String email;
  private String password;
  private String profileInfo;
}
