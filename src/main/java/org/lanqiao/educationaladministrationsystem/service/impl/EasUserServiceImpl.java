package org.lanqiao.educationaladministrationsystem.service.impl;

import org.lanqiao.educationaladministrationsystem.mapper.EasUserMapper;
import org.lanqiao.educationaladministrationsystem.pojo.EasUser;
import org.lanqiao.educationaladministrationsystem.service.EasUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class EasUserServiceImpl implements EasUserService {
    @Autowired
    private EasUserMapper mapper;
    @Override
    public EasUser login(String username, String password) {
        EasUser login = mapper.login(username, password);
        if(login != null){
            return login;
        }
        return null;
    }
}
