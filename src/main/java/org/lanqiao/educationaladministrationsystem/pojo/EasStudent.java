package org.lanqiao.educationaladministrationsystem.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EasStudent {
  private long id;   //id
  private String username;//用户名
  private String name;  //姓名
  private String sex;      //性别
  private String birthday;//出生日期
  private String phone;  //电脑
  private long classId;  //班级
  private String motto;  //座右铭
  private String classes;



}
