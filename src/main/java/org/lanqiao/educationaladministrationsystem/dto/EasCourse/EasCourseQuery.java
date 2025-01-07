package org.lanqiao.educationaladministrationsystem.dto.EasCourse;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EasCourseQuery {
    private Integer id; // 课程id
    private String username; // 老师姓名
    private String coursename; // 课程名称
    private String startDate; // 开始时间
    private String endDate; // 结束 时间
    private Integer classHour; // 课时
    private String testMode; // 考核方式
    private Integer studentNum; // 最大人数
    private Integer choiceNum; // 已选人
}
