package org.lanqiao.educationaladministrationsystem.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Param;
import org.lanqiao.educationaladministrationsystem.dto.EasTeacher.TeacherPageBean;
import org.lanqiao.educationaladministrationsystem.dto.EasTeacher.TeacherPageList;
import org.lanqiao.educationaladministrationsystem.mapper.EasTeacherMapper;
import org.lanqiao.educationaladministrationsystem.pojo.EasTeacher;
import org.lanqiao.educationaladministrationsystem.service.EasTeacherService;
import org.lanqiao.educationaladministrationsystem.utils.PageHelperUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class EasTeacherServiceImpl  implements EasTeacherService {
    @Autowired
    private EasTeacherMapper easTeacherMapper;



    /* 查询所有的教师信息 */
    @Override
    public List<EasTeacher> selectAll() {
        List<EasTeacher> teacher = easTeacherMapper.selectAll();
        if (teacher != null){
            return teacher;
        }else {
            return null;
        }

    }

    /* 根据教师姓名获取教师的id */
    @Override
    public int getTeacherId(String username) {
        int teacherId = easTeacherMapper.getTeacherId(username);
        if(teacherId != 0){
            return teacherId;
        }
        return 0;
    }


    //修改功能
    @Override
    public int update(EasTeacher easTeacher) {
        int result=easTeacherMapper.updateTeacher(easTeacher);
        if(result>0){
            return 1;
        }else {
            return 0;
        }

    }

    //删除功能
    @Override
    public int delete(Long id) {
        int result=easTeacherMapper.deleteTeacher(id);
        if(result>0){
            return 1;
        }else {
            return 0;
        }

    }

    //模糊查询
    @Override
    public List<EasTeacher> findTeacherByUsername(EasTeacher easTeacher) {
        List<EasTeacher> teachers=easTeacherMapper.findTeacherByUsername(easTeacher);
        if(teachers!= null){
            return  teachers;
        }else {
            return null;
        }
    }

    //分页查询
    @Override
    public PageHelperUtil<EasTeacher> pageList(int pageNum, int pageSize) {
        // 获取一共有多少条数据
        int count = easTeacherMapper.selectTotal();
        System.out.println(count);
        // 初始索引
        int offset = (pageNum - 1) * pageSize;
        List<EasTeacher> easTeacherList = easTeacherMapper.selectByPage(pageNum, pageSize, offset);
        //创建分页对象
        PageHelperUtil<EasTeacher> pageHelper = new PageHelperUtil<>();
        pageHelper.setPageNum(pageNum);
        pageHelper.setPageSize(pageSize);
        pageHelper.setPages((int) Math.ceil((double) count/ pageSize));
        pageHelper.setTotal(count);
        pageHelper.setList(easTeacherList);
        return pageHelper;
    }

    //分页模糊查询
    @Override
    public PageHelperUtil<TeacherPageList> teacherPageList(TeacherPageList teacherPageList) {
        // 获取一共有多少条数据
        int count = easTeacherMapper.teacherCount(teacherPageList);
        Integer pageNum = teacherPageList.getPageNum();
        Integer pageSize = teacherPageList.getPageSize();

        // 初始索引
        int offset = (pageNum - 1) * pageSize;

        List<TeacherPageList> teacherPageLists = easTeacherMapper.BigPageList(teacherPageList, offset);
        //创建分页对象
        PageHelperUtil<TeacherPageList> pageHelper = new PageHelperUtil<>();
        pageHelper.setPageNum(pageNum);
        pageHelper.setPageSize(pageSize);
        pageHelper.setPages((int) Math.ceil((double) count/ pageSize));
        pageHelper.setTotal(count);
        pageHelper.setList(teacherPageLists);
        return pageHelper;
    }


}