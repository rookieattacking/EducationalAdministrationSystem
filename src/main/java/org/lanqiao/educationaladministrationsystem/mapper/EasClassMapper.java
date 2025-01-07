package org.lanqiao.educationaladministrationsystem.mapper;

import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.lanqiao.educationaladministrationsystem.dto.EasClass.EasClassFuzzyQuery;
import org.lanqiao.educationaladministrationsystem.pojo.EasClass;
import org.lanqiao.educationaladministrationsystem.utils.PageHelperUtil;

import java.util.List;

@Mapper
public interface EasClassMapper {

    /* 获取所有的班级信息 */
    @Select("select * for eas_class")
    List<EasClass> getAll();


    /* 获取所有的班级信息 分页查询 */
    List<EasClass> easClassList(
            @Param("pageNum") int pageNum,
            @Param("pageSize") int pageSize,
            @Param("offSet") int offSet
    );
    /* 获取总数 */
    int getCount();


    /* 模糊查询获得所有的班级信息 分页查询 */
    List<EasClassFuzzyQuery> getList(@Param("easClassFuzzyQuery") EasClassFuzzyQuery easClassFuzzyQuery,
                                     @Param("offSet") int offSet
                                     );

    /* 模糊查询总页数 */
    int getFuzzyCount(String classes);


    /* 添加班级信息 */
    int addClass(@Param("easClass") EasClass easClass);

    /* 修改班级信息 */
    int updateClass(EasClass easClass);

    /* 批量删除  */
    int batchDeleteClass(@Param("ids") Integer[] ids);

    /* 单个 删除 */

    int deleteById(@Param("id") Long id);


    List<EasClass> findClassName(String classes);




    EasClass getClassView(Integer id);


}
