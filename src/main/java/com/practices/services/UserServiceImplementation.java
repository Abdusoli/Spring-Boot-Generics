package com.practices.services;

import com.practices.entities.User;
import com.practices.repositories.CrudRepository;
import org.springframework.stereotype.Service;

import java.util.UUID;

/**
 * @author Rayner MDZ
 */
@Service
public class UserServiceImplementation extends CrudServiceImplementation<User, UUID> implements UserService {

  public UserServiceImplementation(CrudRepository<User, UUID> repository) {
    super(repository);
  }
}
