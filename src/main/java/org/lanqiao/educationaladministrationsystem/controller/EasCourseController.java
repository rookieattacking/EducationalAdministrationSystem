package org.lanqiao.educationaladministrationsystem.controller;

import org.lanqiao.educationaladministrationsystem.dto.EasCourse.EasCourseQuery;
import org.lanqiao.educationaladministrationsystem.dto.EasCourse.EaseCourseFuzzyQuery;
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
import org.springframework.web.cors.reactive.PreFlightRequestWebFilter;

import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@RestController
@RequestMapping("/easCourse")
@Transactional(rollbackFor = Exception.class)
public class EasCourseController {
    @Autowired
    private EasCourseService easCourseService;
    @Autowired
    private EasTeacherService easTeacherService;
    @Autowired
    private EasBaseCourseService easBaseCourseService;

    /*分页查询 */
    @RequestMapping("/pageList")
    public ResponseUtil pageList(@RequestBody Page page){
        PageHelperUtil<EasCourseQuery> pageList = easCourseService.getPageList(page.getPageNum(), page.getPageSize());
        if(pageList != null){
            return new ResponseUtil(200,"查询成功",pageList);
        }else {
            return new ResponseUtil(305,"查询失败");
        }
    }

    /* 模糊分页查询 */
    @RequestMapping("/fuzzyPageList")
    public ResponseUtil fuzzyPageList(@RequestBody EaseCourseFuzzyQuery easeCourseFuzzyQuery){
        PageHelperUtil<EasCourseQuery> fuzzyPageList = easCourseService.getFuzzyPageList(easeCourseFuzzyQuery);
        if(fuzzyPageList != null){
            return new ResponseUtil(200,"查询成功",fuzzyPageList);
        }else {
            return new ResponseUtil(305,"查询失败");
        }
    }

    /* 查询所有的课程信息 */
    @RequestMapping("/courseList")
    public ResponseUtil courseList(){
        List<EasBaseCourse> easBaseCourse = easBaseCourseService.courseList();
        if(easBaseCourse != null) {
            return new ResponseUtil(200,"查询成功",easBaseCourse);
        }else{
            return new ResponseUtil(305,"查询失败");
        }
    }


    /* 获取所有的教师信息 */
    @RequestMapping("/teacherList")
    public ResponseUtil teacherList(){
        List<EasTeacher> teacherList = easTeacherService.selectAll();
        if(teacherList != null){
            return new ResponseUtil(200,"查询成功",teacherList);
        }else {
            return  new ResponseUtil(305,"查询失败");
        }
    }


    /* 新添加  */

    @RequestMapping("/newAdd")
    public ResponseUtil newAdd(@RequestBody EasCourseQuery easCourseQuery){
        /**
         *  1.先使用EasCourseQuery 实体类来接收用户输入的信息
         *  2.添加的时候，根据教师名查询出对应的Id和课程id之后在添加到eas_course这张中
         */
        /**
         *  1. 先根据课程名和教师姓名分别查询出他们个自的id
         *  2.
         */
        try {
            /* 查询出添加的课程id */
            int baseCourseId = easBaseCourseService.getBaseCourseId(easCourseQuery.getCoursename());
            // 创建一个 ZonedDateTime 对象
            ZonedDateTime zonedDateTime = ZonedDateTime.parse(easCourseQuery.getStartDate());
            ZonedDateTime zonedDateTime2 = ZonedDateTime.parse(easCourseQuery.getEndDate());
            // 定义日期时间格式化器，格式为 YYYY-MM-dd
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            /* 将时间转换成我们想要的 */
            String startDate = new String(zonedDateTime.format(formatter));
            String endDate = new String(zonedDateTime2.format(formatter));

            /* 查询出的教师id */
            int teacherId = easTeacherService.getTeacherId(easCourseQuery.getUsername());
            /* 添加 */
            int classHour = easCourseQuery.getClassHour();
            String testMode = easCourseQuery.getTestMode();
            int studentNum = easCourseQuery.getStudentNum();
            int result = easCourseService.addCourse(new EasCourse(startDate, endDate, classHour, testMode, studentNum, teacherId, baseCourseId));
            if(result > 0 ){
                return new ResponseUtil(200,"添加成功");
            }else{
                return new ResponseUtil(305,"添加失败");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseUtil(500,"添加失败");
        }

    }


    /* 根据id删除 */
    @RequestMapping("/deleteById")
    public ResponseUtil deleteById(@RequestBody EasCourse easCourse){
        int result = easCourseService.deleteById(easCourse.getId());
        if(result > 0){
            return new ResponseUtil(200,"删除成功");
        }else {
            return new ResponseUtil(305,"删除失败");
        }
    }

    /* 批量删除 */

    @RequestMapping("/deleteByids")
    public ResponseUtil deleteByids(@RequestBody Integer[] ids){
        int result = easCourseService.batchDeleteCourse(ids);
        if(result > 0){
            return new ResponseUtil(200,"删除成功");
        }else {
            return new ResponseUtil(305,"删除失败");
        }
    }



}
