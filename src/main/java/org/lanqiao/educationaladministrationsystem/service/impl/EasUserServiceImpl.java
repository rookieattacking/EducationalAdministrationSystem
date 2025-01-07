package org.lanqiao.educationaladministrationsystem.service.impl;

import org.lanqiao.educationaladministrationsystem.dto.EasUser.EasUserQuery;
import org.lanqiao.educationaladministrationsystem.dto.EasUser.FuzzyQuery;
import org.lanqiao.educationaladministrationsystem.mapper.EasUserMapper;
import org.lanqiao.educationaladministrationsystem.pojo.EasRole;
import org.lanqiao.educationaladministrationsystem.pojo.EasUser;
import org.lanqiao.educationaladministrationsystem.service.EasUserService;
import org.lanqiao.educationaladministrationsystem.utils.PageHelperUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class EasUserServiceImpl implements EasUserService {
    @Autowired
    private EasUserMapper easUserMapper;
    @Override
    public EasUser login(String username, String password) {
        EasUser login = easUserMapper.login(username, password);
        if(login != null){
            return login;
        }
        return null;
    }

    /* 查询用户信息 */
    @Override
    public List<EasUserQuery> queryRole() {
        List<EasUserQuery> easUserQuery = easUserMapper.queryRole();
        if(easUserQuery != null){
            return easUserQuery;
        }
        return null;
    }

    /* 分页查询 */
    @Override
    public PageHelperUtil<EasUserQuery> pageList(int pageNum, int pageSize) {
        // 获取一共有多少条数据
        int count = easUserMapper.getCount();
        // 初始索引
        int offset = (pageNum - 1) * pageSize;
        List<EasUserQuery> easUserQueryList = easUserMapper.pageList(pageNum, pageSize, offset);
        //创建分页对象
        PageHelperUtil<EasUserQuery> pageHelper = new PageHelperUtil<>();
        pageHelper.setPageNum(pageNum);
        pageHelper.setPageSize(pageSize);
        pageHelper.setPages((int) Math.ceil((double) count/ pageSize));
        pageHelper.setTotal(count);
        pageHelper.setList(easUserQueryList);
        return pageHelper;
    }

    /* 分页查询模糊查询 */
    @Override
    public PageHelperUtil<FuzzyQuery> fuzzyPageList(FuzzyQuery fuzzyQuery) {
        // 获取一共有多少条数据
        int count = easUserMapper.fuzzyCount(fuzzyQuery);
        Integer pageNum = fuzzyQuery.getPageNum();
        Integer pageSize = fuzzyQuery.getPageSize();

        // 初始索引
        int offset = (pageNum - 1) * pageSize;
        List<FuzzyQuery> easUserQueryList = easUserMapper.fuzzyPageList(fuzzyQuery,offset);
        //创建分页对象
        PageHelperUtil<FuzzyQuery> pageHelper = new PageHelperUtil<>();
        pageHelper.setPageNum(pageNum);
        pageHelper.setPageSize(pageSize);
        pageHelper.setPages((int) Math.ceil((double) count/ pageSize));
        pageHelper.setTotal(count);
        pageHelper.setList(easUserQueryList);
        return pageHelper;
    }



    /* 模糊查询 */
    @Override
    public List<EasUserQuery> getList(EasUserQuery easUserQuery) {
        List<EasUserQuery> list = easUserMapper.getList(easUserQuery);
        if(list != null){
            return list;
        }
        return null;
    }
    /* 根据用户名查询用户信息 */
    @Override
    public EasUser getByUserName(String username) {
        EasUser result = easUserMapper.getByUserName(username);
        if(result != null){
            return result;
        }
        return null;
    }

    /* 添加用户信息 */
    @Override
    public int add(EasUser user) {
        int result = easUserMapper.add(user);

        if(result > 0){
            return result;
        }
        return 0;
    }

    /* 修改用户 */
    @Override
    public int updateUser(EasUserQuery easUserQuery) {
        int result = easUserMapper.updateUser(easUserQuery);
        if(result > 0){
            return result;
        }
        return -1;
    }

    /* 批量删除 */
    @Override
    public int batchDelete(Integer[] ids) {
        int result = easUserMapper.batchDelete(ids);
        if(result > 0){
            return result;
        }
        return 0;
    }

    /* 单个删除 */
    @Override
    public int delete(Integer id) {
        int result = easUserMapper.delete(id);
        if(result > 0){
            return result;
        }
        return 0;
    }

    /* 查询总页数 */
    @Override
    public int getCount() {
        int total = easUserMapper.getCount();
        if(total > 0){
            return total;
        }
        return 0;
    }

    /* 模糊查询总数 */
    @Override
    public int fuzzyCount(FuzzyQuery fuzzyQuery) {
        int total = easUserMapper.fuzzyCount(fuzzyQuery);
        if(total > 0){
            return total;
        }
        return 0;
    }

    /* 根据id查询用户信息 */
    @Override
    public EasUser queryById(String id) {
        EasUser easUser = easUserMapper.queryById(id);
        if(easUser != null){
            return easUser;
        }
        return null;
    }



    /* 修改密码 */
    @Override
    public int updatePassword(EasUser easUser,String password) {
        int result = easUserMapper.updatePassword(easUser,password);
        if(result > 0) {
            return result;
        }
        return 0;
    }

}
