package org.lanqiao.educationaladministrationsystem.controller;

import org.lanqiao.educationaladministrationsystem.dto.EasTeacher.TeacherDelete;
import org.lanqiao.educationaladministrationsystem.dto.EasTeacher.TeacherPageBean;
import org.lanqiao.educationaladministrationsystem.dto.EasTeacher.TeacherPageList;
import org.lanqiao.educationaladministrationsystem.pojo.EasTeacher;
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
@RequestMapping("/teacher")
@Transactional(rollbackFor = Exception.class)
public class EasTeacherController {
    @Autowired
    private EasTeacherService easTeacherService;


    //查询功能
    @RequestMapping("/select")
    public ResponseUtil select() {
        List<EasTeacher> All=easTeacherService.selectAll();
        if(All !=null){
            return new ResponseUtil(200,"查询成功",All);
        }else {
            return new ResponseUtil(305,"查询失败");
        }

    }

    //修改功能
    @RequestMapping("/update")
    public ResponseUtil update(@RequestBody EasTeacher easTeacher){
        System.out.println(easTeacher);
        int result=easTeacherService.update(easTeacher);
        try {
            if(result ==1){
                //表示修改成功
                return new ResponseUtil(200,"修改成功");
            }else {
                //修改失败
                return new ResponseUtil(300,"修改失败");
            }
        }catch (Exception e){
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    //删除功能
    @RequestMapping("/delete")
    public ResponseUtil delete(@RequestBody TeacherDelete teacherDelete){
        System.out.println(teacherDelete);
        try {
            int result = easTeacherService.delete(teacherDelete.getId());
            if (result == 1){
                // 删除成功
                return new ResponseUtil(200,"删除成功");
            }else {
                // 删除失败
                return new ResponseUtil(300,"删除失败");
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }

    }


    //模糊查询
    @RequestMapping("/selectLike")
    public ResponseUtil selectLike(@RequestBody EasTeacher easTeacher){
        List<EasTeacher> teachers = easTeacherService.findTeacherByUsername(easTeacher);
        if(teachers != null){
            return new ResponseUtil( 200,"查询成功",teachers);
        }else {
            return new ResponseUtil( 305,"查询失败");
        }

    }

    //分页查询
    @RequestMapping("/selectBypage")
    public ResponseUtil selectBypage(@RequestBody TeacherPageBean pageBean){
        PageHelperUtil<EasTeacher> easTeacherPageHelperUtil = easTeacherService.pageList(pageBean.getPageNum(), pageBean.getPageSize());
        if(easTeacherPageHelperUtil != null){
            return new ResponseUtil(200,"分页查询成功",easTeacherPageHelperUtil);
        }else {
            return new ResponseUtil(305, "查询失败");
        }
    }

    /* 分页模糊查询 */
    @RequestMapping("/selectBypageLike")
    public ResponseUtil selectBypageLike(@RequestBody TeacherPageList teacherPageList){
        PageHelperUtil<TeacherPageList> teacherPageListPageHelperUtil = easTeacherService.teacherPageList(teacherPageList);
        if(teacherPageListPageHelperUtil != null){
            return new ResponseUtil(200,"模糊分页查询成功",teacherPageListPageHelperUtil);
        }else{
            return new ResponseUtil(305,"查询失败");
        }
    }
}