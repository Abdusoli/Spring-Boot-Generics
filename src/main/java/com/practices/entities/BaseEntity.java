package com.practices.entities;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

import static javax.persistence.TemporalType.DATE;

/**
 * @author Rayner MDZ
 */
@MappedSuperclass
@JsonIdentityInfo(generator= ObjectIdGenerators.IntSequenceGenerator.class, property = "id")
public class BaseEntity implements Serializable {

  @Id
  @Column(name = "id")
  @JsonProperty("id")
  @GeneratedValue(strategy = GenerationType.AUTO)
  private UUID id;

  @Version
  private int version;

  @JsonProperty("created_at")
  @DateTimeFormat(pattern = "MM-dd-YYYY")
  @Column(name = "created_at", unique = false, nullable = true)
  private final LocalDateTime createdAt;

  @JsonProperty("updated_at")
  @DateTimeFormat (pattern = "dd-MMM-YYYY")
  @Column(name = "updated_at", unique = false, nullable = true)
  private LocalDateTime updatedAt;

  public BaseEntity() {
    this.createdAt = LocalDateTime.now();
    this.updatedAt = LocalDateTime.now();
  }

  public BaseEntity(UUID id) {
    this.id = id;
    this.createdAt = LocalDateTime.now();
    this.updatedAt = LocalDateTime.now();
  }

  public UUID getId() {
    return id;
  }

  public void setId(UUID id) {
    this.id = id;
  }

  public int getVersion() {
    return version;
  }

  public void setVersion(int version) {
    this.version = version;
  }

  public LocalDateTime getCreatedAt() {
    return createdAt;
  }

  public LocalDateTime getUpdatedAt() {
    return updatedAt;
  }

  public void setUpdatedAt(LocalDateTime updatedAt) {
    this.updatedAt = updatedAt;
  }
}
