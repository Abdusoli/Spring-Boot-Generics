package com.practices.repositories;

import com.practices.entities.User;
import org.springframework.stereotype.Repository;

import java.util.UUID;

/**
 * @author Rayner MDZ
 */
@Repository
public interface UserRepository extends CrudRepository<User, UUID> {
}
