package org.lanqiao.educationaladministrationsystem.dto.EasUser;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EasUserLongin {
    private String username;
    private String password;
    private String captcha;
    private Boolean rememberMe;
}
