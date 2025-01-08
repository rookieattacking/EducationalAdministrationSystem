package org.lanqiao.educationaladministrationsystem.service;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.lanqiao.educationaladministrationsystem.dto.EasTeacher.TeacherPageBean;
import org.lanqiao.educationaladministrationsystem.dto.EasTeacher.TeacherPageList;
import org.lanqiao.educationaladministrationsystem.pojo.EasStudent;
import org.lanqiao.educationaladministrationsystem.pojo.EasTeacher;
import org.lanqiao.educationaladministrationsystem.utils.PageHelperUtil;

import java.util.List;

/*
教师查询对应接口
 */
public interface EasTeacherService {
    /*
    查询所有
     */
    List<EasTeacher> selectAll();


    /* 根据教师姓名获取教师的id */
    int getTeacherId(String username);



    /*
    修改功能
     */
    int update(EasTeacher easTeacher);

    /*
    删除功能
     */
    int delete(Long id);

    /*
    模糊查询
     */
    List<EasTeacher> findTeacherByUsername(EasTeacher easTeacher);

    /*
    分页查询
    */

    PageHelperUtil<EasTeacher> pageList(
            @Param("pageNum") int pageNum,
            @Param("pageSize") int pageSize
    );

    /* 分页查询模糊查询 */
    PageHelperUtil<TeacherPageList> teacherPageList(@Param("teacherPageList") TeacherPageList teacherPageList);


}