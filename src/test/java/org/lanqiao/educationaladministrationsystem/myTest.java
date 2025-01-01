package org.lanqiao.educationaladministrationsystem;

import org.junit.jupiter.api.Test;
import org.lanqiao.educationaladministrationsystem.pojo.EasUser;
import org.lanqiao.educationaladministrationsystem.service.EasUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class myTest {
    @Autowired
    private EasUserService easUserService;
    @Test
    public void test1(){
        EasUser admin = easUserService.login("admin", "123456");
        System.out.println(admin);
    }
}
