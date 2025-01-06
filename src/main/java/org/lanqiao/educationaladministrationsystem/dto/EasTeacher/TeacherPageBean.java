package org.lanqiao.educationaladministrationsystem.dto.EasTeacher;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.poi.ss.formula.functions.T;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TeacherPageBean {
    //当前页码
    private  Integer pageSize;
    //每页显示条数
    private Integer pageNum;
}
