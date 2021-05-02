package net.okur.blog.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.util.ObjectUtils;

import ma.glasnost.orika.MapperFacade;
import net.okur.blog.model.User;
import net.okur.blog.repository.UserRepository;
import net.okur.blog.service.input.UserInput;
import net.okur.blog.service.output.InfoOutput;
import net.okur.blog.service.output.UserOutput;

public class UserServiceImpl implements UserService {
  private final UserRepository repository;
  private final MapperFacade mapperFacade;

  @Autowired
  public UserServiceImpl(UserRepository repository, @Qualifier("serviceMapper") MapperFacade mapperFacade) {
    this.repository = repository;
    this.mapperFacade = mapperFacade;
  }

  @Override
  public UserOutput findByUsername(String username) {
    Optional<User> user = repository.findByUsername(username);
    UserOutput userOutput = new UserOutput();
    if (user.isPresent()) {
      userOutput = mapperFacade.map(user, UserOutput.class);
      userOutput.setInfoStatus(InfoOutput.InfoStatus.SUCCESS);
    } else {
      userOutput.setInfoMessage("User not found.");
      userOutput.setInfoStatus(InfoOutput.InfoStatus.ERROR);
    }
    return userOutput;
  }

  @Override
  public UserOutput save(UserInput userInput) {
    UserOutput userOutput = new UserOutput();
    if (ObjectUtils.isEmpty(userInput.getEmail())) {
      userOutput.setInfoStatus(InfoOutput.InfoStatus.ERROR);
      userOutput.setInfoMessage("email cannot be empty");
      return userOutput;

    }
    if (ObjectUtils.isEmpty(userInput.getUsername())) {
      userOutput.setInfoStatus(InfoOutput.InfoStatus.ERROR);
      userOutput.setInfoMessage("username cannot be empty");
      return userOutput;

    }
    if (ObjectUtils.isEmpty(userInput.getPassword())) {
      userOutput.setInfoStatus(InfoOutput.InfoStatus.ERROR);
      userOutput.setInfoMessage("password cannot be empty");
      return userOutput;

    }

    User user = repository.save(mapperFacade.map(userInput, User.class));
    userOutput = mapperFacade.map(user, UserOutput.class);
    userOutput.setInfoStatus(InfoOutput.InfoStatus.SUCCESS);
    userOutput.setInfoMessage("Saved");
    return null;
  }
}
