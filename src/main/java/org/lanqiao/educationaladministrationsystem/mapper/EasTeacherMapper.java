package org.lanqiao.educationaladministrationsystem.mapper;

import org.lanqiao.educationaladministrationsystem.pojo.EasTeacher;

import java.util.List;

public interface EasTeacherMapper {
    List<EasTeacher> findTeacherList(EasTeacher easTeacher);

    List<EasTeacher> findListByUsername(String username);

    EasTeacher getTeacherByUsername(String username);

    int updateTeacher(EasTeacher easTeacher);

    List<EasTeacher> getAll();

    EasTeacher findTeacherByUsername(String username);

    int getTotal();

    int addUsername(String username);

    int deleteTeacher(String username);
}
