package org.lanqiao.educationaladministrationsystem.dto.EasBaseCourse;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FuzzyQueryCourse {
    private Integer pageNum;
    private Integer pageSize;
    private long id;
    private String coursename;
    private String synopsis;
}
