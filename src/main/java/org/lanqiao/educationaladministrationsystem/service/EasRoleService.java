package org.lanqiao.educationaladministrationsystem.service;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Select;
import org.lanqiao.educationaladministrationsystem.pojo.EasRole;
import org.lanqiao.educationaladministrationsystem.pojo.EasUserRole;

import java.util.List;

public interface EasRoleService {
    //获取所有的角色信息
    List<EasRole> getAll();


    /* 添加用户角色信息 eas_user_role */
    int addRole(EasUserRole easUserRole);

    /* 根据角色名查询角色信息 */
    EasRole getRoleView(String name);


    /* 修改角色信息eas_user_role */
    int updateBaseCourse(EasUserRole easUserRole);


    /* 根据用户Id删除角色信息 eas_user_role */
    int delete(Integer easUserId);


    /* 批量删除 */
    int batchDeleteRole(Integer[] ids);


    /* 根据用户id来获取角色信息 */
    int getRoleId(Integer userId);

}
