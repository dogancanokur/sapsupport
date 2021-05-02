package net.okur.blog.service.output;

import lombok.Data;

@Data
public class UserOutput extends InfoOutput {
  private String username;
  private String name;
  private String surname;
  private String email;
  private String profileInfo;
}
