package org.lanqiao.educationaladministrationsystem.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.lanqiao.educationaladministrationsystem.pojo.EasUser;

import java.util.List;

@Mapper
public interface EasUserMapper {
    int addUserRole(@Param("userId") Integer userId, @Param("roleIds") Integer[] roleIds);

    int deleteUserRole(Integer id);

    EasUser getByUserName(String username);

    // List<EasUser> getList(@Param("easUser") EasUser easUser, @Param("pageUtil") PageUtil pageUtil);

    EasUser get(Integer id);

    int add(EasUser user);

    int delete(Integer id);

    int batchDelete(Integer[] ids);

    int updateUser(EasUser user);

    String findUsernameById(Integer userid);

    List<EasUser> findUserName(String username);

    Integer findRoleIdByUserId(@Param("userid") Integer userid);

    int getCount();

    List<Integer> findRoleIdByUserId2(@Param("userid") Integer userid);

    EasUser findUserById(@Param("id")Integer id);

    int getRoleCountByUid(@Param("userid")Integer userid);
    /* 登录 */
    EasUser login(String username,String password);
}
