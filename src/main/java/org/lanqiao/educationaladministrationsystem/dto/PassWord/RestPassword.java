package org.lanqiao.educationaladministrationsystem.dto.PassWord;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RestPassword {
    private String oldPassword;
    private String newPassword;

}
