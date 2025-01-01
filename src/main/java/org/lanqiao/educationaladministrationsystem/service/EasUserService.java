package org.lanqiao.educationaladministrationsystem.service;

import org.lanqiao.educationaladministrationsystem.pojo.EasUser;

public interface EasUserService {
    /* 登录 */
    EasUser login(String username,String password);
}
