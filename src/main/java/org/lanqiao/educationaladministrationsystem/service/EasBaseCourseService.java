package org.lanqiao.educationaladministrationsystem.service;

import org.apache.ibatis.annotations.Param;
import org.lanqiao.educationaladministrationsystem.dto.EasBaseCourse.FuzzyQueryCourse;
import org.lanqiao.educationaladministrationsystem.pojo.EasBaseCourse;
import org.lanqiao.educationaladministrationsystem.utils.PageHelperUtil;

import java.util.List;

public interface EasBaseCourseService {


    /*模糊查询获取集合分页*/
    PageHelperUtil<FuzzyQueryCourse> getList(@Param("fuzzyQueryCourse") FuzzyQueryCourse fuzzyQueryCourse,
                                             @Param("pageSize") int pageSize,
                                             @Param("pageNum") int pageNum
    );

    /*分页查询*/
    PageHelperUtil<EasBaseCourse> getPageList(
            @Param("pageSize") int pageSize,
            @Param("pageNum") int pageNum);


    /*修改基本课程信息*/
    int updateBaseCourse(EasBaseCourse easBaseCourse);

    /*添加基本课程信息*/
    int addBaseCourse(@Param("easBaseCourse") EasBaseCourse easBaseCourse);

    /* 根据id单个删除 */
    int getBaseCourseById(EasBaseCourse easBaseCourse);

    /* 批量删除 */
    int batchDeleteBaseCourse(@Param("ids") Integer[] ids);
}
