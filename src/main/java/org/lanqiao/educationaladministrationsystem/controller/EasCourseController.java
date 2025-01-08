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
        System.out.println(easCourseQuery);
        /**
         *  1.先使用EasCourseQuery 实体类来接收用户输入的信息
         *  2.添加的时候，根据教师名查询出对应的Id和课程id之后在添加到eas_course这张中
         */
        /* 先添加新的基本课程信息 */
        int result1 = easBaseCourseService.addNewBaseCourse(easCourseQuery.getCoursename());

        /* 要查询出新的基本课程id */
        int baseCourseId = easBaseCourseService.getBaseCourseId(easCourseQuery.getCoursename());
        /* 获取教师id */
        int teacherId = easTeacherService.getTeacherId(easCourseQuery.getCoursename());
        /* 最后添加  */
        String startDate = easCourseQuery.getStartDate();
        String endDate = easCourseQuery.getEndDate();
        Integer classHour = easCourseQuery.getClassHour();
        String testMode = easCourseQuery.getTestMode();
        Integer studentNum = easCourseQuery.getStudentNum();

        EasCourse easCourse = new EasCourse(startDate,endDate,classHour,testMode,studentNum,teacherId,baseCourseId);
        int result2 = easCourseService.addCourse(easCourse);
        if(result1 > 0 && result2 > 0){
            return new ResponseUtil(200,"添加成功");
        }else{
            return new ResponseUtil(305,"添加失败");
        }

    }


}
