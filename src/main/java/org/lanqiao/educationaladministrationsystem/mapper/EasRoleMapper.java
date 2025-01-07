package org.lanqiao.educationaladministrationsystem.mapper;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.lanqiao.educationaladministrationsystem.pojo.EasRole;
import org.lanqiao.educationaladministrationsystem.pojo.EasUserRole;
import org.springframework.stereotype.Service;

import java.util.List;

@Mapper
public interface EasRoleMapper {


    /* 获取所有的角色信息 */
    List<EasRole> getAll();


    /* 根据角色id查询出对应的角色名 */
    String findRoleNameByRoleId(Integer roleid);



    /* 根据id查询角色信息 */
    EasRole getRoleView(String roleName);



    /* 修改角色信息eas_user_role */
    int updateBaseCourse(EasUserRole easUserRole);



    /* 添加用户角色信息 eas_user_role */
    int addRole(EasUserRole easUserRole);


    /* 根据用户Id删除角色信息 eas_user_role */
    @Delete("delete from eas_user_role where eas_user_id = #{easUserId}")
    int delete(Integer easUserId);


    /* 批量删除 */
    int batchDeleteRole(@Param("ids") Integer[] ids);

    /* 根据用户id来获取角色的id */
    @Select("select eas_role_id from eas_user_role where eas_user_id = #{easUserId} ")
    int getRoleId(Integer userId);
}
