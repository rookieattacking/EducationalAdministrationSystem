package org.lanqiao.educationaladministrationsystem.service;

import org.apache.ibatis.annotations.Param;
import org.lanqiao.educationaladministrationsystem.dto.EasStudent.StudentPageList;
import org.lanqiao.educationaladministrationsystem.dto.EasTeacher.TeacherPageList;
import org.lanqiao.educationaladministrationsystem.pojo.EasStudent;
import org.lanqiao.educationaladministrationsystem.pojo.EasTeacher;
import org.lanqiao.educationaladministrationsystem.utils.PageHelperUtil;

import java.util.List;

/*
学生查询对应接口
 */
public interface EasStudentService {
    /*
    查询所有
     */
    List<EasStudent> selectAll();

    /*
    修改操作
     */
    int update(EasStudent easStudent);
    /*
   模糊查询
    */
    List<EasStudent> findListByUsername(EasStudent easStudent);

    /*
   删除功能
    */
    int delete(Long id);


        /*
    分页查询
    */

    PageHelperUtil<EasStudent> pageList(
            @Param("pageNum") int pageNum,
            @Param("pageSize") int pageSize
    );

    /* 分页查询模糊查询 */
    PageHelperUtil<StudentPageList> studentPageList(@Param("studentPageList") StudentPageList studentPageList);




}
