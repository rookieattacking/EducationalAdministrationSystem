package org.lanqiao.educationaladministrationsystem.controller;

import org.lanqiao.educationaladministrationsystem.dto.EasCourse.EasCourseQuery;
import org.lanqiao.educationaladministrationsystem.dto.EasCourse.EaseCourseFuzzyQuery;
import org.lanqiao.educationaladministrationsystem.dto.page.Page;
import org.lanqiao.educationaladministrationsystem.service.EasCourseService;
import org.lanqiao.educationaladministrationsystem.utils.PageHelperUtil;
import org.lanqiao.educationaladministrationsystem.utils.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/easCourse")
public class EasCourseController {
    @Autowired
    private EasCourseService easCourseService;

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

}
