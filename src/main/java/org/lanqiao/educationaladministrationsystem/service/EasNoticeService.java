package org.lanqiao.educationaladministrationsystem.service;

import org.lanqiao.educationaladministrationsystem.pojo.EasNotice;

import java.util.List;

public interface EasNoticeService {
    /* 获取所有的通知 */
    List<EasNotice> getAllList();

    /* 根据id查询 */
    List<EasNotice> getNoticeById(Long id);
}
