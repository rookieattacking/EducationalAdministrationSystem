package org.lanqiao.educationaladministrationsystem.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EasNotice {

  private long id;
  private String title;
  private String author;
  private String content;
  private long type;
  private String releasedate;
}
