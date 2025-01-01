package org.lanqiao.educationaladministrationsystem.mapper;

import org.apache.ibatis.annotations.Param;
import org.lanqiao.educationaladministrationsystem.pojo.EasStudent;

import java.util.List;

public interface EasStudentMapper {
    List<EasStudent> getList (EasStudent easStudent);

    //包含两个一对一关系
    List<EasStudent> findList(EasStudent easStudent);

    List<EasStudent> findListByUsername(String username);

    EasStudent getStudentByUsername(String username);

    int updateStudent(EasStudent easStudent);

    int getCountBytIdandcId(@Param("tId") Integer tId, @Param("baseCourseId") Integer baseCourseId, @Param("classId") Integer classId);

    int getEndingCountBytIdandcId(@Param("tId") Integer tId,@Param("baseCourseId") Integer baseCourseId,@Param("classId") Integer classId);

    // List<EasStudent> getStudentScoreListByTid(@Param("tId") Integer tId,@Param("baseCourseId") Integer baseCourseId,
    //                                           @Param("classId") Integer classId,@Param("pageUtil") PageUtil pageUtil);

    // List<EasStudent> getStudentSelectCourseListByTid(@Param("tId") Integer tId,@Param("baseCourseId") Integer baseCourseId,
    //                                                  @Param("classId") Integer classId,@Param("pageUtil") PageUtil pageUtil);


    int getTotal();

    int getTotalSex(String sex);

    int addUsername(String username);

    int deleteStudent(String username);
}
