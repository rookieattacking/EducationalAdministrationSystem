package org.lanqiao.educationaladministrationsystem.service.impl;

import org.apache.ibatis.annotations.Param;
import org.lanqiao.educationaladministrationsystem.mapper.EasRoleMapper;
import org.lanqiao.educationaladministrationsystem.pojo.EasRole;
import org.lanqiao.educationaladministrationsystem.pojo.EasUserRole;
import org.lanqiao.educationaladministrationsystem.service.EasRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EasRoleServiceImpl implements EasRoleService {
    @Autowired
    private EasRoleMapper easRoleMapper;
    @Override
    public List<EasRole> getAll() {
        List<EasRole> all = easRoleMapper.getAll();
        if(all != null){
            return all;
        }
        return null;
    }


    /* 添加用户角色信息 eas_user_role */
    @Override
    public int addRole(EasUserRole easUserRole) {
        int result = easRoleMapper.addRole(easUserRole);
        if(result > 0){
            return result;
        }
        return 0;
    }

    /* 根据id查询角色信息 */
    @Override
    public EasRole getRoleView(String name) {
        EasRole result = easRoleMapper.getRoleView(name);
        if(result != null){
            return result;
        }
        return null;
    }

    /* 修改角色信息eas_user_role */
    @Override
    public int updateBaseCourse(EasUserRole easUserRole) {
        int result = easRoleMapper.updateBaseCourse(easUserRole);
        if(result > 0){
            return result;
        }else{
            return -1;
        }
    }

    /* 根据用户Id删除角色信息 eas_user_role */
    @Override
    public int delete(Integer easUserId) {
        int result = easRoleMapper.delete(easUserId);
        if(result > 0){
            return result;
        }
        return 0;
    }

    /* 批量删除 */
    @Override
    public int batchDeleteRole(@Param("ids") Integer[] ids) {
        int result = easRoleMapper.batchDeleteRole(ids);
        if(result > 0){
            return result;
        }
        return 0;
    }

    /* 根据用户id来获取角色的id */
    @Override
    public int getRoleId(Integer userId) {
        int result = easRoleMapper.getRoleId(userId);
        if(result > 0){
            return result;
        }
        return 0;
    }

}
