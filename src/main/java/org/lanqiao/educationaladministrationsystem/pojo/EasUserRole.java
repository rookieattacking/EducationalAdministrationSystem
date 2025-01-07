package org.lanqiao.educationaladministrationsystem.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EasUserRole {
  private Integer id;
  private Integer easUserId;
  private Integer easRoleId;

  public EasUserRole(Integer easUserId, Integer easRoleId) {
    this.easUserId = easUserId;
    this.easRoleId = easRoleId;
  }
}
