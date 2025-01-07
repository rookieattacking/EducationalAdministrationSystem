package org.lanqiao.educationaladministrationsystem;

import org.junit.jupiter.api.Test;
import org.lanqiao.educationaladministrationsystem.dto.EasUser.EasUserQuery;
import org.lanqiao.educationaladministrationsystem.dto.EasUser.FuzzyQuery;
import org.lanqiao.educationaladministrationsystem.mapper.EasClassMapper;
import org.lanqiao.educationaladministrationsystem.mapper.EasUserMapper;
import org.lanqiao.educationaladministrationsystem.pojo.EasClass;
import org.lanqiao.educationaladministrationsystem.pojo.EasRole;

import org.lanqiao.educationaladministrationsystem.service.EasRoleService;
import org.lanqiao.educationaladministrationsystem.service.EasUserService;
import org.lanqiao.educationaladministrationsystem.vo.EasUserVo.EasUserQueryVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
public class myTest {
    @Autowired
    private EasUserService easUserService;
    @Autowired
    private EasClassMapper easClassMapper;
    @Autowired
    private EasUserMapper easUserMapper;
    @Autowired
    private EasRoleService easRoleService;
    @Test
    public void test1(){
        int offSet = (1 - 1) * 10;
        // EasClassFuzzyQuery admin = new EasClassFuzzyQuery();
        // List<EasClassFuzzyQuery> easUserQueryList = easUserMapper.fuzzyPageList(admin,  offSet);

        List<EasClass> easClasses = easClassMapper.easClassList(1, 5, offSet);
        for (EasClass easClass : easClasses) {
            System.out.println(easClass);
        }
    }
}
