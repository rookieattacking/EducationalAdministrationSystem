package org.lanqiao.educationaladministrationsystem.mapper;

import org.apache.ibatis.annotations.Param;
import org.lanqiao.educationaladministrationsystem.pojo.EasRole;

import java.util.List;

public interface EasRoleMapper {
    /**
     * 根据用户编号查询对应的角色信息
     * @param userId
     * @return
     */
    List<EasRole> getByUserId(Integer userId);

    /**
     * 根据角色编号查询对应的权限编号集合
     * @param roleId
     * @return
     */
    List<Long> getPerIdsByRoleId(Integer roleId);

    int deleteRolePermissions(Integer roleId);

    int addRolePermissions(@Param("roleId") Integer roleId, @Param("perIds") String[] perIds);

    List<EasRole> getAll();

    // List<EasRole> getList(@Param("easRole") EasRole easRole,@Param("pageUtil") PageUtil pageUtil);

    String findRoleNameByRoleId(Integer roleid);

    int getCount();

    List<EasRole> findRoleName(String name);

    int addRole(EasRole easRole);

    int batchDeleteRole(Integer[] ids);

    EasRole getRoleView(Integer id);

    int updateBaseCourse(EasRole easRole);
}
