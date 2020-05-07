package com.practices.services;

import com.practices.entities.BaseEntity;

import java.io.Serializable;
import java.util.List;

/**
 * @author Rayner MDZ
 */
public interface CrudService<T extends BaseEntity, ID extends Serializable> {
  List<T> getAll();
  T getById(ID id);
  T save(T object);
  Boolean deleteById(ID id);
}
