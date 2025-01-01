package org.lanqiao.educationaladministrationsystem.mapper;

import org.apache.ibatis.annotations.Param;
import org.lanqiao.educationaladministrationsystem.pojo.EasClass;

import java.util.List;

public interface EasClassMapper {
    List<EasClass> getAll();

    int getCount();

    // 模糊查询
    List<EasClass> getList(String classes);

    List<EasClass> findClassName(String classes);

     int addClass(EasClass easClass);

     int batchDeleteClass(Integer[] ids);

    EasClass getClassView(Integer id);

    int updateClass(EasClass easClass);
}
