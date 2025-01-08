package org.lanqiao.educationaladministrationsystem.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EasCourse {

  private long id;
  private String startDate;
  private String endDate;
  private long classHour;
  private String testMode;
  private long studentNum;
  private long choiceNum;
  private long complete;
  private long tId;
  private long baseCourseId;

  public EasCourse(String startDate, String endDate, long classHour, String testMode, long studentNum, long tId, long baseCourseId) {
    this.startDate = startDate;
    this.endDate = endDate;
    this.classHour = classHour;
    this.testMode = testMode;
    this.studentNum = studentNum;
    this.tId = tId;
    this.baseCourseId = baseCourseId;
  }
}
