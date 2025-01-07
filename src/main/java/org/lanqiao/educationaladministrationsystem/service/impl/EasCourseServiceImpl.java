package org.lanqiao.educationaladministrationsystem.service.impl;

import lombok.AllArgsConstructor;
import org.lanqiao.educationaladministrationsystem.dto.EasCourse.EasCourseQuery;
import org.lanqiao.educationaladministrationsystem.dto.EasCourse.EaseCourseFuzzyQuery;
import org.lanqiao.educationaladministrationsystem.mapper.EasCourseMapper;
import org.lanqiao.educationaladministrationsystem.service.EasCourseService;
import org.lanqiao.educationaladministrationsystem.utils.PageHelperUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EasCourseServiceImpl implements EasCourseService {
    @Autowired
    private EasCourseMapper easCourseMapper;
    /* 分页查询 */
    @Override
    public PageHelperUtil<EasCourseQuery> getPageList(int pageNum, int pageSize) {
        int count = easCourseMapper.getCount();
        int offSet = (pageNum - 1) * pageSize;
        List<EasCourseQuery> pageList = easCourseMapper.getPageList(pageNum, pageSize, offSet);
        PageHelperUtil<EasCourseQuery> pageHelper = new PageHelperUtil<>();
        pageHelper.setPageNum(pageNum);
        pageHelper.setPageSize(pageSize);
        pageHelper.setPages((int) Math.ceil((double) count/ pageSize));
        pageHelper.setTotal(count);
        pageHelper.setList(pageList);
        return pageHelper;
    }


    /* 模糊查询 */
    @Override
    public PageHelperUtil<EasCourseQuery> getFuzzyPageList(EaseCourseFuzzyQuery easeCourseFuzzyQuery) {
        int count = easCourseMapper.getFuzzyCount(easeCourseFuzzyQuery);
        Integer pageNum = easeCourseFuzzyQuery.getPageNum();
        Integer pageSize = easeCourseFuzzyQuery.getPageSize();
        int offSet = (pageNum - 1) * pageSize;
        List<EasCourseQuery> fuzzyPageList = easCourseMapper.getFuzzyPageList(easeCourseFuzzyQuery, offSet);
        PageHelperUtil<EasCourseQuery> pageHelper = new PageHelperUtil<>();
        pageHelper.setPageNum(pageNum);
        pageHelper.setPageSize(pageSize);
        pageHelper.setPages((int) Math.ceil((double) count/ pageSize));
        pageHelper.setTotal(count);
        pageHelper.setList(fuzzyPageList);
        return pageHelper;
    }
}
