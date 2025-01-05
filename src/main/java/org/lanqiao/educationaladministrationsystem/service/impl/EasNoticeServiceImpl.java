package org.lanqiao.educationaladministrationsystem.service.impl;

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
}
