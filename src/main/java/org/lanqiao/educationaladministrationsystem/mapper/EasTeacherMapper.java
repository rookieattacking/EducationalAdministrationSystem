package org.lanqiao.educationaladministrationsystem.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.lanqiao.educationaladministrationsystem.dto.EasTeacher.TeacherPageList;
import org.lanqiao.educationaladministrationsystem.pojo.EasTeacher;

import java.util.List;

/*/
  教师信息
 */
@Mapper
public interface EasTeacherMapper {
    //查询所有
    @Select("select * from eas_teacher")
    List<EasTeacher> selectAll();

    //根据姓名来模糊查询
    List<EasTeacher> findTeacherByUsername(EasTeacher easTeacher);

    //修改操作
    int updateTeacher(EasTeacher easTeacher);

    //根据id删除操作
    int deleteTeacher(Long id);


   /* 根据教师姓名获取教师的id */
    @Select("select id from eas_teacher where username = #{username}")
    int getTeacherId(String username);


    /* 查询所有的教师信息 */
    @Select("select * from eas_teacher")
    EasTeacher getTeacherList();

    /*
    分页查询
     */
//    List<EasTeacher> selectByPageAndCondition (@Param("begin") int begin,@Param("size") int size,@Param("easteacher") EasTeacher teacher);
    List<EasTeacher> selectByPage(@Param("pageNum") int pageNum, @Param("pageSize") int pageSize, @Param("offSet") int offSet);


    //查询总记录数
    int selectTotal();


    /* 分页查询模糊查询 */
    List<TeacherPageList> BigPageList(@Param("teacherPageList") TeacherPageList teacherPageList,
                                      @Param("offSet") int offSet);


    /* 模糊查询总数 */
    int teacherCount(@Param("teacherPageList")TeacherPageList teacherPageList);

}