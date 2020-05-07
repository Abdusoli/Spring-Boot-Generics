package com.practices.config;

import com.practices.services.UserService;
import com.practices.entities.User;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Random;

/**
 * @author Rayner MDZ
 */
@Component
public class Bootstrap implements CommandLineRunner {

  private final UserService service;

  public Bootstrap(UserService service) {
    this.service = service;
  }

  @Override
  public void run(String... args) throws Exception {

    for (int i = 0; i <= 10; i++) {
      User user = new User();
      user.setUsername(generateRandomString());
      user.setPassword(generateRandomString());

      service.save(user);

      List<User> users = fetchData();

      users.forEach(System.out::println);
    }
  }

  private List<User> fetchData() {
    return service.getAll();
  }

  private String generateRandomString() {
    int leftLimit = 97; // letter 'a'
    int rightLimit = 122; // letter 'z'
    int targetStringLength = 10;
    Random random = new Random();

    return random.ints(leftLimit, rightLimit + 1)
            .limit(targetStringLength)
            .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
            .toString();
  }
}
