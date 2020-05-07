package com.practices.services;

import com.practices.entities.BaseEntity;
import com.practices.entities.User;

import java.io.Serializable;
import java.util.UUID;

/**
 * @author Rayner MDZ
 */
public interface UserService extends CrudService<User, UUID> {
}
