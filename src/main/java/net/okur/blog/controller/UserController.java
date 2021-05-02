package net.okur.blog.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ma.glasnost.orika.MapperFacade;
import net.okur.blog.controller.request.UserRequest;
import net.okur.blog.controller.response.UserResponse;
import net.okur.blog.service.UserService;
import net.okur.blog.service.input.UserInput;
import net.okur.blog.service.output.UserOutput;

@RestController
@RequestMapping("api/v1/user")
public class UserController {
  private static Logger logger = LoggerFactory.getLogger(UserController.class);
  private final MapperFacade mapperFacade;
  private final UserService userService;

  @Autowired
  public UserController(@Qualifier("serviceMapper") MapperFacade mapperFacade, UserService userService) {
    this.mapperFacade = mapperFacade;
    this.userService = userService;
  }

  @GetMapping()
  public UserResponse getUserByUsername(String username) {
    logger.info("Queried with" + username + '.');
    return mapperFacade.map(userService.findByUsername(username), UserResponse.class);
  }

  @PostMapping("/save")
  public UserResponse saveUser(UserRequest userRequest) {
    logger.info("User saved");
    UserInput userInput = mapperFacade.map(userRequest, UserInput.class);
    UserOutput saveOutput = userService.save(userInput);
    return mapperFacade.map(saveOutput, UserResponse.class);
  }
}
