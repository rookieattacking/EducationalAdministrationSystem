package org.lanqiao.educationaladministrationsystem.service;

import org.apache.ibatis.annotations.Delete;
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

    /* 批量删除 */
    int batchDeleteCourse(Integer[] ids);

    /* 根据id删除 */
    int deleteById(Integer id);


    /* 模糊查询 */
    PageHelperUtil<EasCourseQuery> getFuzzyPageList(@Param("easeCourseFuzzyQuery") EaseCourseFuzzyQuery easeCourseFuzzyQuery);
}
