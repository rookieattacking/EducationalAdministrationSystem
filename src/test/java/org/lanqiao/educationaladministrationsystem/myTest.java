package org.lanqiao.educationaladministrationsystem;

import org.junit.jupiter.api.Test;
import org.lanqiao.educationaladministrationsystem.dto.EasUser.EasUserQuery;
import org.lanqiao.educationaladministrationsystem.dto.EasUser.FuzzyQuery;
import org.lanqiao.educationaladministrationsystem.mapper.EasBaseCourseMapper;
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
    private EasBaseCourseMapper easBaseCourseMapper;
    @Autowired
    private EasRoleService easRoleService;
    @Test
    public void test1(){
        int baseCourseId = easBaseCourseMapper.getBaseCourseId("数据结构与算法");
        System.out.println(baseCourseId);
    }
}
