package org.lanqiao.educationaladministrationsystem.mapper;

import org.apache.ibatis.annotations.*;
import org.lanqiao.educationaladministrationsystem.dto.EasUser.EasUserQuery;
import org.lanqiao.educationaladministrationsystem.dto.EasUser.FuzzyQuery;
import org.lanqiao.educationaladministrationsystem.pojo.EasRole;
import org.lanqiao.educationaladministrationsystem.pojo.EasUser;

import java.util.List;

@Mapper
public interface EasUserMapper {

    /* 登录 */
    EasUser login(String username,String password);

    /* 注册 */
    int register(EasUser easUser);


    /* 分页查询 */
    List<EasUserQuery> pageList(
            @Param("pageNum") int pageNum,
            @Param("pageSize") int pageSize,
            @Param("offSet") int offSet); //  offSet 是 起始索引



    /* 分页查询模糊查询 */
    List<FuzzyQuery> fuzzyPageList(@Param("fuzzyQuery") FuzzyQuery fuzzyQuery,
                                      @Param("offSet") int offSet); //  offSet 是 起始索引

    /* 查询用户信息 */

    List<EasUserQuery> queryRole();

    /* 模糊查询 */
    List<EasUserQuery> getList(EasUserQuery easUserQuery);


    /* 根据用户名查询用户信息 */
    EasUser getByUserName(String username);

    /* 添加用户信息 */
    int add(EasUser user);


    /* 修改用户 */
    int updateUser(EasUserQuery easUserQuery);


    /* 批量删除 */
    int batchDelete(@Param("ids") Integer[] ids);

    /* 单个删除 */
    int delete(Integer id);


    /* 查询总页数 */
    int getCount();

    /* 模糊查询总数 */
    int fuzzyCount(@Param("fuzzyQuery")FuzzyQuery fuzzyQuery);


    /* 查询所有的角色 */
    @Select("select * from eas_role")
    List<EasRole> queryRoleList();

    /* 根据id查询用户信息 */
    @Select("select * from eas_user where id = #{id}" )
    EasUser queryById(String id);


    /* 修改密码 */
    @Update("update eas_user set password = #{password} where id = #{easUser.id}")
    int updatePassword(@Param("easUser") EasUser easUser, @Param("password") String password);


}
