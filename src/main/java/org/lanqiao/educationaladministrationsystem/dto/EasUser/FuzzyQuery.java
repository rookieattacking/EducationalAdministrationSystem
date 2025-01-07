package org.lanqiao.educationaladministrationsystem.dto.EasUser;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FuzzyQuery {
    private Integer id;
    private String username;
    private String salt;//别名
    private String role;
    private String password;
    private Integer pageNum;   // 当前页码
    private Integer pageSize;  // 每页显示条数
}
