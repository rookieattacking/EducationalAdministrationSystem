package org.lanqiao.educationaladministrationsystem.controller;

import org.apache.ibatis.annotations.Param;
import org.lanqiao.educationaladministrationsystem.dto.EasBaseCourse.FuzzyQueryCourse;
import org.lanqiao.educationaladministrationsystem.dto.EasCourse.EasCourseQuery;
import org.lanqiao.educationaladministrationsystem.dto.page.Page;
import org.lanqiao.educationaladministrationsystem.pojo.EasBaseCourse;
import org.lanqiao.educationaladministrationsystem.pojo.EasCourse;
import org.lanqiao.educationaladministrationsystem.pojo.EasTeacher;
import org.lanqiao.educationaladministrationsystem.service.EasBaseCourseService;
import org.lanqiao.educationaladministrationsystem.service.EasCourseService;
import org.lanqiao.educationaladministrationsystem.service.EasTeacherService;
import org.lanqiao.educationaladministrationsystem.utils.PageHelperUtil;
import org.lanqiao.educationaladministrationsystem.utils.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/baseCourse")
@Transactional(rollbackFor = Exception.class)
public class EasBaseCourseController {
    @Autowired
    private EasBaseCourseService easBaseCourseService;

    /*分页查询*/
    @RequestMapping("/getAll")
    public ResponseUtil getAll(@RequestBody Page page){
        PageHelperUtil<EasBaseCourse> pageList =  easBaseCourseService.getPageList(page.getPageSize(), page.getPageNum());
        if(pageList != null){
            return new ResponseUtil(200,"查询成功",pageList);
        }else {
            return new ResponseUtil(305,"查询失败");
        }

    }
    /*模糊查询*/
    @RequestMapping("/fuzzyQuery")
    public ResponseUtil fuzzyQuery(@RequestBody FuzzyQueryCourse fuzzyQueryCourse){
        PageHelperUtil<FuzzyQueryCourse> pageHelperUtil = easBaseCourseService.getList(fuzzyQueryCourse, fuzzyQueryCourse.getPageSize(), fuzzyQueryCourse.getPageNum());
        if(pageHelperUtil != null){
            return new ResponseUtil(200,"查询成功",pageHelperUtil);
        }else {
            return new ResponseUtil(305,"查询失败");
        }

    }
    /*添加*/
    @RequestMapping("/addCourse")
    public ResponseUtil addCourse(@RequestBody EasBaseCourse easBaseCourse){
        int result = easBaseCourseService.addBaseCourse(easBaseCourse);
        if(result > 0){
            return new ResponseUtil(200,"数据添加成功");
        }else{
            return new ResponseUtil(305,"数据添加失败");
        }
    }

    /*修改*/
    @RequestMapping("/updateCourse")
    public ResponseUtil updateCourse(@RequestBody EasBaseCourse easBaseCourse){
        int result = easBaseCourseService.updateBaseCourse(easBaseCourse);
        if(result > 0){
            return new ResponseUtil(200,"数据修改成功");
        }else{
            return new ResponseUtil(305,"数据修改失败");
        }
    }


    /* 批量删除 */
    @RequestMapping("/deleteByIds")
    public ResponseUtil deleteByIds(@RequestBody Integer[] ids){
        int result = easBaseCourseService.batchDeleteBaseCourse(ids);
        if(result > 0){
            return new ResponseUtil(200,"删除成功");
        }else {
            return new ResponseUtil(305,"删除失败");
        }
    }

    /* 根据id删除 */
    @RequestMapping("/deleteById")
    public ResponseUtil deleteById(@RequestBody EasBaseCourse easBaseCourse){
        int result = easBaseCourseService.deleteById(easBaseCourse);
        if(result > 0){
            return new ResponseUtil(200,"删除成功");
        }else {
            return new ResponseUtil(305,"删除失败");
        }
    }








}
