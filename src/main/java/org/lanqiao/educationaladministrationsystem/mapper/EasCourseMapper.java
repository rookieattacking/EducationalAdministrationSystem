package org.lanqiao.educationaladministrationsystem.mapper;

import org.apache.ibatis.annotations.Param;
import org.lanqiao.educationaladministrationsystem.pojo.EasCourse;

import java.util.Date;
import java.util.List;

public interface EasCourseMapper {
    int getCount();

    // List<EasCourse> getList(@Param("easCourse") EasCourse easCourse, @Param("pageUtil") PageUtil pageUtil);

    List<EasCourse> findCourseByBaseCourseIdAndTeacherId(@Param("baseCourseId") Integer baseCourseId,@Param("tId") Integer tId);

    int addCourse(EasCourse easCourse);

    EasCourse getCourseById(Integer id);

    int updateCourseById(EasCourse easCourse);

    int updateDate(@Param("id") Integer id, @Param("startDate") Date startDate, @Param("endDate") java.sql.Date endDate);

    int batchDeleteCourse(Integer[] ids);

    int getCountBytId(Integer tId);

    // List<EasCourse> getCourseListBytId(@Param("tId")Integer tId,@Param("pageUtil") PageUtil pageUtil);

    int completeCourse(EasCourse easCourse);

    int getTotalItemsCountBySid(@Param("isAll") int isAll,@Param("searchKey") String searchKey,@Param("sId") int sId);

    // List<EasCourse> getCourseListBySid(@Param("isAll") int isAll, @Param("searchKey") String searchKey, @Param("sId") int sId,@Param("pageUtil") PageUtil pageUtil);


    int findCompleteByCourseId(@Param("courseId") int courseId);

    int getTotalPass(@Param("baseCourseId") Integer baseCourseId);

    int getTotalNoPass(@Param("baseCourseId")Integer baseCourseId);
}
