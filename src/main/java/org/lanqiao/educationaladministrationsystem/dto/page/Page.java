package org.lanqiao.educationaladministrationsystem.dto.page;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Page {
    private Integer pageNum;   // 当前页码
    private Integer pageSize;  // 每页显示条数
}
