package org.lanqiao.educationaladministrationsystem.controller;


import org.lanqiao.educationaladministrationsystem.dto.EasStudent.StudentPageList;
import org.lanqiao.educationaladministrationsystem.pojo.EasStudent;
import org.lanqiao.educationaladministrationsystem.service.EasStudentService;
import org.lanqiao.educationaladministrationsystem.utils.PageHelperUtil;
import org.lanqiao.educationaladministrationsystem.utils.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Transactional(rollbackFor = Exception.class)
@RequestMapping("/student")
public class StudentController {
    @Autowired
    private EasStudentService easStudentService;


    //查询功能
    @RequestMapping("/select")
    public ResponseUtil select() {
        List<EasStudent> All = easStudentService.selectAll();
        if(All !=null){
            return new ResponseUtil(200,"查询成功",All);
        }else {
            return new ResponseUtil(305,"查询失败");
        }

    }

    //修改功能
    @RequestMapping("/update")
    public ResponseUtil update(@RequestBody EasStudent easStudent){
        System.out.println(easStudent);
        int result=easStudentService.update(easStudent);
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
    public ResponseUtil delete(@RequestBody EasStudent studentDelete){
        try {
            int result = easStudentService.delete(studentDelete.getId());
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
    public ResponseUtil selectLike(@RequestBody EasStudent easStudent){
        List<EasStudent> students = easStudentService.findListByUsername(easStudent);
        System.out.println(students);
        if(students != null){
            return new ResponseUtil( 200,"查询成功",students);
        }else {
            return new ResponseUtil( 305,"查询失败");
        }
    }

    //分页查询
    @RequestMapping("/selectBypage")
    public ResponseUtil selectBypage(@RequestBody StudentPageList pageBean){
        PageHelperUtil<EasStudent> easStudentPageHelperUtil = easStudentService.pageList(pageBean.getPageNum(), pageBean.getPageSize());
        if(easStudentPageHelperUtil != null){
            return new ResponseUtil(200,"分页查询成功",easStudentPageHelperUtil);
        }else {
            return new ResponseUtil(305, "查询失败");
        }
    }


    /* 分页模糊查询 */
    @RequestMapping("/selectBypageLike")
    public ResponseUtil selectBypageLike(@RequestBody StudentPageList studentPageList){
        PageHelperUtil<StudentPageList> studentPageListPageHelperUtil = easStudentService.studentPageList(studentPageList);
        if(studentPageListPageHelperUtil != null){
            return new ResponseUtil(200,"模糊分页查询成功",studentPageListPageHelperUtil);
        }else{
            return new ResponseUtil(305,"查询失败");
        }
    }
}