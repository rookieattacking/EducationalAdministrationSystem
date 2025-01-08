package org.lanqiao.educationaladministrationsystem.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.lanqiao.educationaladministrationsystem.dto.EasCourse.EasCourseQuery;
import org.lanqiao.educationaladministrationsystem.dto.EasCourse.EaseCourseFuzzyQuery;
import org.lanqiao.educationaladministrationsystem.pojo.EasCourse;

import java.util.Date;
import java.util.List;

@Mapper
public interface EasCourseMapper {


    // List<EasCourse> getList(@Param("easCourse") EasCourse easCourse, @Param("pageUtil") PageUtil pageUtil);

    List<EasCourse> findCourseByBaseCourseIdAndTeacherId(@Param("baseCourseId") Integer baseCourseId,@Param("tId") Integer tId);


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






    /* 添加  */
    int addCourse(EasCourse easCourse);


    /* 分页查询计算总行数 */
    int getCount();

    /* 分页查询 */
    List<EasCourseQuery> getPageList(@Param("pageNum") int pageNum,
                                     @Param("pageSize") int pageSize,
                                     @Param("offSet") int offSet
    );

    /*模糊查询分页总行数 */
    int getFuzzyCount(@Param("easeCourseFuzzyQuery") EaseCourseFuzzyQuery easeCourseFuzzyQuery);


    /* 模糊查询 */
    List<EasCourseQuery> getFuzzyPageList(@Param("easeCourseFuzzyQuery")EaseCourseFuzzyQuery easeCourseFuzzyQuery,
                                          @Param("offSet") int offSet);
}
