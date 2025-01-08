package org.lanqiao.educationaladministrationsystem.service;

import jakarta.servlet.http.HttpServletRequest;
import org.apache.ibatis.annotations.Param;
import org.lanqiao.educationaladministrationsystem.dto.EasUser.EasUserQuery;
import org.lanqiao.educationaladministrationsystem.dto.EasUser.FuzzyQuery;
import org.lanqiao.educationaladministrationsystem.pojo.EasUser;
import org.lanqiao.educationaladministrationsystem.utils.PageHelperUtil;

import java.util.List;

public interface EasUserService {

    /* 登录 */
    EasUser login(String username,String password);

    /* 注册 */
    int register(EasUser easUser);


    /* 查询用户信息 */
    List<EasUserQuery> queryRole();


    /* 分页查询 */
    PageHelperUtil<EasUserQuery> pageList(
                                          @Param("pageNum") int pageNum,
                                          @Param("pageSize") int pageSize
    );

    /* 分页查询模糊查询 */
    PageHelperUtil<FuzzyQuery> fuzzyPageList(@Param("fuzzyQuery") FuzzyQuery fuzzyQuery);


    /* 模糊查询 */
    List<EasUserQuery> getList(EasUserQuery EasUserQuery);


    /* 根据用户名查询用户信息 */
    EasUser getByUserName(String username);

    /* 添加用户信息 */
    int add(EasUser user);

    /* 修改用户 */
    int updateUser(EasUserQuery easUserQuery);

    /* 批量删除 */
    int batchDelete(Integer[] ids);

    /* 单个删除 */
    int delete(Integer id);

    /* 查询总页数 */
    int getCount();

    /* 模糊查询总数 */
    int fuzzyCount(@Param("fuzzyQuery") FuzzyQuery fuzzyQuery);

    /* 根据id查询用户信息 */
    EasUser queryById(String id);

    /* 修改密码 */
    int updatePassword(@Param("easUser") EasUser easUser, @Param("password") String password);



}
