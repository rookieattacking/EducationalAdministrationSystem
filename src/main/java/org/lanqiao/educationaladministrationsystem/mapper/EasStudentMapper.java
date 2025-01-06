package org.lanqiao.educationaladministrationsystem.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.lanqiao.educationaladministrationsystem.dto.EasStudent.StudentPageList;
import org.lanqiao.educationaladministrationsystem.dto.EasTeacher.TeacherPageList;
import org.lanqiao.educationaladministrationsystem.pojo.EasStudent;
import org.lanqiao.educationaladministrationsystem.pojo.EasTeacher;


import java.util.List;

@Mapper
public interface EasStudentMapper {

    //查询所有
    @Select("select * from eas_student inner join eas_class on eas_student.class_id = eas_class.id")
    List<EasStudent> selectAll();


   //模糊查询
    List<EasStudent> findListByUsername(EasStudent easStudent);

    //修改
        int updateStudent(EasStudent easStudent);
    //删除操作
        int deleteStudent(Long id);


      /*
       分页查询
     */
    List<EasStudent> selectByPage(@Param("pageNum") int pageNum, @Param("pageSize") int pageSize, @Param("offSet") int offSet);


    //分页查询总记录数
    int selectTotal();


    /* 分页查询模糊查询 */
    List<StudentPageList> BigPageList(@Param("studentPageList") StudentPageList studentPageList,
                                      @Param("offSet") int offSet);


    /* 模糊查询总数 */
    int studentCount(@Param("studentPageList")StudentPageList studentPageList);



}
