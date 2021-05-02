package net.okur.blog.controller.response;

import lombok.Data;

@Data
public class UserResponse {
  private String username;
  private String name;
  private String surname;
  private String email;
  private String profileInfo;
}
