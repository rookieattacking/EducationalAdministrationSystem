package org.lanqiao.educationaladministrationsystem.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EasCourse {

  private Integer id;
  private String startDate;
  private String endDate;
  private Integer classHour;
  private String testMode;
  private Integer studentNum;
  private Integer choiceNum;
  private Integer complete;
  private Integer tId;
  private Integer baseCourseId;
  private Integer did;

  public EasCourse(String startDate, String endDate, Integer classHour, String testMode, Integer studentNum, Integer tId, Integer baseCourseId) {
    this.startDate = startDate;
    this.endDate = endDate;
    this.classHour = classHour;
    this.testMode = testMode;
    this.studentNum = studentNum;
    this.tId = tId;
    this.baseCourseId = baseCourseId;
  }
}
