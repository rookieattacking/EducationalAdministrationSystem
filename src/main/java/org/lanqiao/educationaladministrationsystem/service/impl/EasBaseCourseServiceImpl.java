package org.lanqiao.educationaladministrationsystem.service.impl;

import org.lanqiao.educationaladministrationsystem.dto.EasBaseCourse.FuzzyQueryCourse;
import org.lanqiao.educationaladministrationsystem.mapper.EasBaseCourseMapper;
import org.lanqiao.educationaladministrationsystem.pojo.EasBaseCourse;
import org.lanqiao.educationaladministrationsystem.service.EasBaseCourseService;
import org.lanqiao.educationaladministrationsystem.utils.PageHelperUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EasBaseCourseServiceImpl implements EasBaseCourseService {
    @Autowired
    private EasBaseCourseMapper easBaseCourseMapper;

    /* 分页查询 */
    @Override
    public PageHelperUtil<EasBaseCourse> getPageList(int pageSize, int pageNum) {
        int count = easBaseCourseMapper.getCount();
        int offSet = (pageNum - 1) * pageSize;
        List<EasBaseCourse> pageList = easBaseCourseMapper.getPageList(offSet,pageSize,pageNum);
        PageHelperUtil<EasBaseCourse> pageHelper = new PageHelperUtil<>();
        pageHelper.setPageNum(pageNum);
        pageHelper.setPageSize(pageSize);
        pageHelper.setPages((int) Math.ceil((double) count/ pageSize));
        pageHelper.setTotal(count);
        pageHelper.setList(pageList);
        return pageHelper;
    }
    
    /* 模糊分页查询 */
    @Override
    public PageHelperUtil<FuzzyQueryCourse> getList(FuzzyQueryCourse fuzzyQueryCourse, int pageSize, int pageNum) {
        int count = easBaseCourseMapper.getFuzzyCount(fuzzyQueryCourse);
        int offSet = (pageNum - 1) * pageSize;
        List<FuzzyQueryCourse> list = easBaseCourseMapper.getFuzzyList(fuzzyQueryCourse,offSet);
        // 创建分页对象
        PageHelperUtil<FuzzyQueryCourse> pageHelper = new PageHelperUtil<>();
        pageHelper.setPageNum(pageNum);
        pageHelper.setPageSize(pageSize);
        pageHelper.setPages((int) Math.ceil((double) count/ pageSize));
        pageHelper.setTotal(count);
        pageHelper.setList(list);
        return pageHelper;
    }

    /*修改*/
    @Override
    public int updateBaseCourse(EasBaseCourse easBaseCourse) {
        int result = easBaseCourseMapper.updateBaseCourse(easBaseCourse);
        if(result > 0){
            return result;
        }else{
            return 0;
        }
    }

    /*添加*/
    @Override
    public int addBaseCourse(EasBaseCourse easBaseCourse) {
        int result = easBaseCourseMapper.addBaseCourse(easBaseCourse);
        if(result > 0){
            return result;
        }else{
            return 0;
        }
    }



    /* 根据id单个删除 */
    @Override
    public int deleteById(EasBaseCourse easBaseCourse) {
        int result = easBaseCourseMapper.deleteById(easBaseCourse);
        if(result > 0){
            return result;
        }
        return 0;
    }


    /* 批量删除 */
    @Override
    public int batchDeleteBaseCourse(Integer[] ids) {
        int result = easBaseCourseMapper.batchDeleteBaseCourse(ids);
        if(result > 0){
            return result;
        }
        return 0;
    }


    /*  查询出所有的基本课程信息 */
    @Override
    public List<EasBaseCourse> courseList() {
        List<EasBaseCourse> easBaseCourse = easBaseCourseMapper.courseList();
        if(easBaseCourse != null){
            return easBaseCourse;
        }
        return null;
    }

    /* 新添加基本课程信息 */
    @Override
    public int addNewBaseCourse(String cousername) {
        int result = easBaseCourseMapper.addNewBaseCourse(cousername);
        if(result > 0){
            return result;
        }
        return 0;
    }

    /* 根据基本课程名获取基本课程的id */
    @Override
    public int getBaseCourseId(String coursename) {
        int baseCourseId = easBaseCourseMapper.getBaseCourseId(coursename);
        if(baseCourseId != 0){
            return baseCourseId;
        }else {
            return 0;
        }
    }
}
