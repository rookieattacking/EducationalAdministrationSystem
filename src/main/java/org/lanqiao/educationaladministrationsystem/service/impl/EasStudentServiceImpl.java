package org.lanqiao.educationaladministrationsystem.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.lanqiao.educationaladministrationsystem.dto.EasStudent.StudentPageList;
import org.lanqiao.educationaladministrationsystem.mapper.EasStudentMapper;
import org.lanqiao.educationaladministrationsystem.pojo.EasStudent;
import org.lanqiao.educationaladministrationsystem.service.EasStudentService;
import org.lanqiao.educationaladministrationsystem.utils.PageHelperUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class EasStudentServiceImpl implements EasStudentService {
    @Autowired
    private EasStudentMapper easStudentMapper;

    @Override
    public EasStudent selectOneByUsername(String username) {
        EasStudent easStudent = easStudentMapper.selectOneByUsername(username);
        if(easStudent != null){
            return easStudent;
        }
        return null;
    }

    /*
        查询所有操作
         */
    @Override
    public List<EasStudent> selectAll() {
        List<EasStudent> student=easStudentMapper.selectAll();
        if(student != null){
            return student;
        }else {
            return null;
        }

    }

    /*
    修改操作
     */
    @Override
    public int update(EasStudent easStudent) {
        int result =easStudentMapper.updateStudent(easStudent);
        if(result>0){
            return 1;
        }else {
            return 0;
        }

    }

    /*
    模糊查询操作
     */
    @Override
    public List<EasStudent> findListByUsername(EasStudent easStudent) {
        List<EasStudent> students=easStudentMapper.findListByUsername(easStudent);
        if(students!= null){
            return  students;
        }else {
            return null;
        }
    }

    @Override
    public int delete(Long id) {
        int result=easStudentMapper.deleteStudent(id);
        if(result>0){
            return 1;
        }
        return 0;
    }

    //分页查询
    @Override
    public PageHelperUtil<EasStudent> pageList(int pageNum, int pageSize) {
        // 获取一共有多少条数据
        int count = easStudentMapper.selectTotal();
        // 初始索引
        int offset = (pageNum - 1) * pageSize;
        List<EasStudent> easStudentList = easStudentMapper.selectByPage(pageNum, pageSize, offset);
        //创建分页对象
        PageHelperUtil<EasStudent> pageHelper = new PageHelperUtil<>();
        pageHelper.setPageNum(pageNum);
        pageHelper.setPageSize(pageSize);
        pageHelper.setPages((int) Math.ceil((double) count/ pageSize));
        pageHelper.setTotal(count);
        pageHelper.setList(easStudentList);
        return pageHelper;
    }


    //分页模糊查询
    @Override
    public PageHelperUtil<StudentPageList> studentPageList(StudentPageList studentPageList) {
        // 获取一共有多少条数据
        int count = easStudentMapper.studentCount(studentPageList);
        Integer pageNum = studentPageList.getPageNum();
        Integer pageSize = studentPageList.getPageSize();

        // 初始索引
        int offset = (pageNum - 1) * pageSize;

        List<StudentPageList> studentPageLists = easStudentMapper.BigPageList(studentPageList, offset);
        //创建分页对象
        PageHelperUtil<StudentPageList> pageHelper = new PageHelperUtil<>();
        pageHelper.setPageNum(pageNum);
        pageHelper.setPageSize(pageSize);
        pageHelper.setPages((int) Math.ceil((double) count/ pageSize));
        pageHelper.setTotal(count);
        pageHelper.setList(studentPageLists);
        return pageHelper;
    }


}
