package org.lanqiao.educationaladministrationsystem.dto.EasTeacher;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TeacherPageList {
    private long id;
    private String username;  //用户名
    private String name;     //老师的姓名
    private String sex;      //性别
    private String birthday;    //出生日期
    private String phone;     //电话
    private String education;   //学历
    //当前页码
    private  Integer pageSize;
    //每页显示条数
    private Integer pageNum;
}
