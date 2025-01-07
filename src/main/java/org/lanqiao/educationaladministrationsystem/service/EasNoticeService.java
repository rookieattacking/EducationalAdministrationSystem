package org.lanqiao.educationaladministrationsystem.service;

import org.apache.ibatis.annotations.Param;
import org.lanqiao.educationaladministrationsystem.pojo.EasNotice;

import java.util.List;

public interface EasNoticeService {
    /* 获取所有的通知 */
    List<EasNotice> getAllList();

    /* 根据id查询 */
    List<EasNotice> getNoticeById(Long id);
    //    根据id删
    int deleteNotice(@Param("id") long id);
    //    模糊查询
    List<EasNotice> like(@Param("title") String title);
//    添加

    int addNotice(EasNotice easNotice);
    //批量删除
    int deleteNoticeList(List<Integer> list);
}
