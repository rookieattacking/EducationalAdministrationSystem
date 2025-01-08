package org.lanqiao.educationaladministrationsystem.service;

import org.apache.ibatis.annotations.Param;
import org.lanqiao.educationaladministrationsystem.dto.EasCourse.EasCourseQuery;
import org.lanqiao.educationaladministrationsystem.dto.EasCourse.EaseCourseFuzzyQuery;
import org.lanqiao.educationaladministrationsystem.pojo.EasCourse;
import org.lanqiao.educationaladministrationsystem.utils.PageHelperUtil;


public interface EasCourseService {

    /* 添加 */
    int addCourse(EasCourse easCourse);

    /* 分页查询 */
    PageHelperUtil<EasCourseQuery> getPageList(@Param("pageNum") int pageNum,
                                     @Param("pageSize") int pageSize
    );


    /* 模糊查询 */
    PageHelperUtil<EasCourseQuery> getFuzzyPageList(@Param("easeCourseFuzzyQuery") EaseCourseFuzzyQuery easeCourseFuzzyQuery);
}
