package org.lanqiao.educationaladministrationsystem.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EasRolePermission {
  private long id;
  private long easRoleId;
  private long easPermissionId;


}
