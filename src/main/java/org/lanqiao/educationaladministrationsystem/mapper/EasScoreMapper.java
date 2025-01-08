package org.lanqiao.educationaladministrationsystem.mapper;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;
import org.lanqiao.educationaladministrationsystem.pojo.EasCourse;
import org.lanqiao.educationaladministrationsystem.pojo.EasScore;

import java.util.Date;
import java.util.List;

public interface EasScoreMapper {
    int insertSelective(EasScore easScore);

    int deleteScore(EasScore easScore);

    int updateScore(EasScore easScore);

    int updateScoreByScoreList(List<EasScore> scoreList);

    int getTotalItemsCount(@Param("sId") int sId, @Param("result") Integer result);

    // List<EasCourse> getCourseListBySid(@Param("sId") int sId, @Param("result") Integer result, @Param("pageUtil") PageUtil pageUtil);

    EasScore getcIdById(int id);


    String getStartDateByCourseId(Integer courseId);

}
