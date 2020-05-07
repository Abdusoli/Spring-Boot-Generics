package com.practices.services;

import com.practices.entities.BaseEntity;
import com.practices.repositories.CrudRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.io.Serializable;
import java.util.List;

/**
 * @author Rayner MDZ
 */
@Service
@Transactional
public class CrudServiceImplementation<T extends BaseEntity, ID extends Serializable> implements CrudService<T, ID> {

  private final CrudRepository<T, ID> repository;

  public CrudServiceImplementation(CrudRepository<T, ID> repository) {
    this.repository = repository;
  }

  @Override
  public List<T> getAll() {
    return repository.findAll();
  }

  @Override
  public T getById(ID id) {
    return repository.getOne(id);
  }

  @Override
  public T save(T object) {
    return (T) repository.save(object);
  }

  @Override
  public Boolean deleteById(ID id) {
    repository.deleteById(id);
    return true;
  }
}
