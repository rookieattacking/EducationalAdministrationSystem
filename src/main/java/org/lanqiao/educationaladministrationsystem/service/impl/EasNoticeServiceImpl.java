package org.lanqiao.educationaladministrationsystem.service.impl;

import org.apache.ibatis.annotations.Param;
import org.lanqiao.educationaladministrationsystem.mapper.EasNoticeMapper;
import org.lanqiao.educationaladministrationsystem.pojo.EasNotice;
import org.lanqiao.educationaladministrationsystem.service.EasNoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EasNoticeServiceImpl implements EasNoticeService {
    @Autowired
    private EasNoticeMapper easNoticeMapper;
    /* 获得所有的通知 */
    @Override
    public List<EasNotice> getAllList() {
        List<EasNotice> allList = easNoticeMapper.getAllList();
        if(allList != null){
            return allList;
        }
        return null;
    }

    @Override
    public List<EasNotice> getNoticeById(Long id) {
        List<EasNotice> noticeById = easNoticeMapper.getNoticeById(id);
        if(noticeById != null){
            return noticeById;
        }
        return null;
    }

    @Override
    public int deleteNotice(long id) {
        int result = easNoticeMapper.deleteNotice(id);
        if(result > 0){
            return 1;
        }
        return 0;
    }

    @Override
    public List<EasNotice> like(String title) {
        List<EasNotice> like = easNoticeMapper.like(title);
        if(like != null){
            return like;
        }
        return null;
    }

    @Override
    public int addNotice(EasNotice easNotice) {
        int result = easNoticeMapper.addNotice(easNotice);
        if(result > 0){
            return 1;
        }
        return 0;
    }

    @Override
    public int deleteNoticeList(List<Integer> list) {
        int deletedCount = 0;
        for (Integer id : list) {
            int result = easNoticeMapper.deleteNoticeList(list);  // 使用单个删除方法
            if (result > 0) {
                deletedCount++;
            }
        }
        return deletedCount;
    }


}
