package org.lanqiao.educationaladministrationsystem.dto.EasClass;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EasClassFuzzyQuery {
    private Integer pageNum;   // 当前页码
    private Integer pageSize;  // 每页显示条数
    private long id;
    private String username;
    private String name;
    private String sex;
    private String birthday;
    private String phone;
    private long classId;
    private String motto;
    private String classes;
}
