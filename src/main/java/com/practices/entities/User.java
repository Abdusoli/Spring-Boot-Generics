package com.practices.entities;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;

/**
 * @author Rayner MDZ
 */
@Entity
@Table(
        name = "user",
        indexes = {@Index(columnList = "id", name = "user_id")})
@Data
public class User extends BaseEntity {

  @JsonProperty("username")
  private String username;

  @JsonProperty("password")
  private String password;

  public User() {
  }

  public User(UUID id, String username, String password) {
    super(id);
    this.username = username;
    this.password = password;
  }

  public User(String username, String password) {
    this.username = username;
    this.password = password;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof User)) return false;
    User user = (User) o;
    return Objects.equals(getId(), user.getId()) &&
            Objects.equals(getUsername(), user.getUsername()) &&
            Objects.equals(getPassword(), user.getPassword()) &&
            Objects.equals(getCreatedAt(), user.getCreatedAt()) &&
            Objects.equals(getUpdatedAt(), user.getUpdatedAt());
  }

  @Override
  public int hashCode() {
    return Objects.hash(getId(), getUsername(), getPassword(), getCreatedAt(), getUpdatedAt());
  }
}
