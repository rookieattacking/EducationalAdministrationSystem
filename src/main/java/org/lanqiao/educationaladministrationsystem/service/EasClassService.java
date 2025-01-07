package org.lanqiao.educationaladministrationsystem.service;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;
import org.lanqiao.educationaladministrationsystem.dto.EasClass.EasClassFuzzyQuery;
import org.lanqiao.educationaladministrationsystem.pojo.EasClass;
import org.lanqiao.educationaladministrationsystem.utils.PageHelperUtil;

import java.util.List;

public interface EasClassService {

    /* 获取所有的班级信息 */
    List<EasClass> getAll();

    /* 添加班级信息 */
    int addClass(EasClass easClass);

    /* 修改班级信息 */
    int updateClass(EasClass easClass);

    /* 分页查询所有班级信息 */
    PageHelperUtil<EasClass> easClassList(
            @Param("pageNum") int pageNum,
            @Param("pageSize") int pageSize
    );
    /* 查询总页数 */
    int getCount();



    /* 模糊查询获得所有的班级信息 分页查询 */
    PageHelperUtil<EasClassFuzzyQuery> getList(@Param("easClassFuzzyQuery") EasClassFuzzyQuery easClassFuzzyQuery);

    /* 批量删除  */
    int batchDeleteClass(@Param("ids") Integer[] ids);

    /* 单个 删除 */
    int deleteById(@Param("id") Long id);

}
