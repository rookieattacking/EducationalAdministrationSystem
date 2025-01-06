package org.lanqiao.educationaladministrationsystem.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EasTeacher {
  private long id;
  private String username;  //用户名
  private String name;     //老师的姓名
  private String sex;      //性别
  private String birthday;    //出生日期
  private String phone;     //电话
  private String education;   //学历
  private String motto;      //座右铭

}
