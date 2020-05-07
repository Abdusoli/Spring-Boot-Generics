package com.practices.repositories;

import com.practices.entities.BaseEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import java.io.Serializable;

/**
 * @author Rayner MDZ
 */
@NoRepositoryBean
public interface CrudRepository<T extends BaseEntity, ID extends Serializable> extends JpaRepository<T, ID> {
}
