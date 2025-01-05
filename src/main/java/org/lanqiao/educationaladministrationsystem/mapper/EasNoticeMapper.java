package org.lanqiao.educationaladministrationsystem.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.lanqiao.educationaladministrationsystem.pojo.EasNotice;

import java.util.List;

@Mapper
public interface EasNoticeMapper {
    int getCountByType(@Param("type") int type, @Param("searchKey") String searchKey);

    // List<EasNotice> getNoticeListByType(@Param("type")int type, @Param("searchKey") String searchKey, @Param("pageUtil") PageUtil pageUtil);

    int addNotice(EasNotice easNotice);

    int updateNotice(EasNotice easNotice);

    int deleteNotice(EasNotice easNotice);

    int deleteNoticeList(List<Integer> list);

    int getCountByTypeAndEasNotice(@Param("type") int type,@Param("easNotice") EasNotice easNotice);

    // List<EasNotice> getNoticeListByTypeAndEasNotice(@Param("type") int type,@Param("easNotice") EasNotice easNotice,@Param("pageUtil") PageUtil pageUtil);



    List<EasNotice> getNoticeById(Long id);


    /* 获取所有的通知 */
    @Select("select * from eas_notice")
    List<EasNotice> getAllList();
}
