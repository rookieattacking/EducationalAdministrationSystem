package org.lanqiao.educationaladministrationsystem.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.lanqiao.educationaladministrationsystem.dto.EasBaseCourse.FuzzyQueryCourse;
import org.lanqiao.educationaladministrationsystem.pojo.EasBaseCourse;
import org.lanqiao.educationaladministrationsystem.service.EasBaseCourseService;

import java.util.List;

@Mapper
public interface EasBaseCourseMapper {

    /*模糊查询获取集合分页*/
    List<FuzzyQueryCourse> getFuzzyList(@Param("fuzzyQueryCourse") FuzzyQueryCourse fuzzyQueryCourse,
                                   @Param("offSet") int offSet
    );

    /*模糊查询获取总行数*/
    int getFuzzyCount(@Param("fuzzyQueryCourse") FuzzyQueryCourse fuzzyQueryCourse);


    /*获得总行数分页查询*/
    int getCount();



    /*分页查询*/
    List<EasBaseCourse> getPageList(
            @Param("offSet") int offSet,
            @Param("pageSize") int pageSize,
            @Param("pageNum") int pageNum);

    /*修改基本课程信息*/
    int updateBaseCourse(EasBaseCourse easBaseCourse);

    /*添加基本课程信息*/
    int addBaseCourse(@Param("easBaseCourse") EasBaseCourse easBaseCourse);


    /* 根据id单个删除 */
    int deleteById(EasBaseCourse easBaseCourse);

    /* 批量删除 */
    int batchDeleteBaseCourse(@Param("ids") Integer[] ids);

    /*  查询出所有的基本课程信息 */
    @Select("select * from eas_base_course")
    List<EasBaseCourse> courseList();

    /* 新添加基本课程信息 */
    int addNewBaseCourse(String cousername);

    /* 根据基本课程名获取基本课程的id */
    @Select("select id from eas_base_course where coursename = #{coursename}")
    int getBaseCourseId(String coursename);

}
