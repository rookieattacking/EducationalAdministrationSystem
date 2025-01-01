package org.lanqiao.educationaladministrationsystem.mapper;

import org.lanqiao.educationaladministrationsystem.pojo.EasBaseCourse;

import java.util.List;

public interface EasBaseCourseMapper {
    /* 添加课程信息 */
    int addBaseCourse(String coursename,String synopsis);

    //修改基本课程信息
    int updateBaseCourse(String coursename,String synopsis);

     // 批量删除根据id
    int batchDeleteBaseCourse(int[] ids);

    //查询表中所有的数据
    EasBaseCourse getAll();

    // 根据id获取数据
    List<EasBaseCourse> getListById(int id);

    // 根据id获取单个数据
    EasBaseCourse getBaseCourseById(int id);

    //模糊查询获取集合分页
    List<EasBaseCourse> getList(String coursename,String synopsis);

    // 获得总行数
    int getCount();


}
