package org.lanqiao.educationaladministrationsystem.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EasUser {

  private long id;
  private String username;
  private String password;
  private String salt;
  private String locked;

}
