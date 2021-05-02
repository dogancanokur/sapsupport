package net.okur.blog.service;

import net.okur.blog.service.input.UserInput;
import net.okur.blog.service.output.UserOutput;

public interface UserService {
  UserOutput findByUsername(String username);

  UserOutput save(UserInput user);

}
