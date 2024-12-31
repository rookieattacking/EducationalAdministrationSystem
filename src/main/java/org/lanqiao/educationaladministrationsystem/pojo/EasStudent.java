package org.lanqiao.educationaladministrationsystem.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EasStudent {

  private long id;
  private String username;
  private String name;
  private String sex;
  private String birthday;
  private String phone;
  private long classId;
  private String motto;



}
