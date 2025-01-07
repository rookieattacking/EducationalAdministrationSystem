package org.lanqiao.educationaladministrationsystem.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EasUser {

  private Integer id;
  private String username;
  private String password;
  private String salt;
  private String locked;

  public EasUser(String username, String password, String salt) {
    this.username = username;
    this.password = password;
    this.salt = salt;
  }
}
