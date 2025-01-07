package org.lanqiao.educationaladministrationsystem.service.impl;

import org.lanqiao.educationaladministrationsystem.dto.EasClass.EasClassFuzzyQuery;
import org.lanqiao.educationaladministrationsystem.dto.EasUser.EasUserQuery;
import org.lanqiao.educationaladministrationsystem.mapper.EasClassMapper;
import org.lanqiao.educationaladministrationsystem.pojo.EasClass;
import org.lanqiao.educationaladministrationsystem.service.EasClassService;
import org.lanqiao.educationaladministrationsystem.utils.PageHelperUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.imageio.plugins.tiff.TIFFImageReadParam;
import javax.management.RuntimeErrorException;
import java.util.List;

@Service
public class EasClassServiceImpl implements EasClassService {
    @Autowired
    private EasClassMapper easClassMapper;

    /* 获取所有的班级信息 */
    @Override
    public List<EasClass> getAll() {
        List<EasClass> result = easClassMapper.getAll();
        if(result != null){
            return result;
        }
        return null;
    }

    /* 添加班级信息 */
    @Override
    public int addClass(EasClass easClass) {
        int result = easClassMapper.addClass(easClass);
        if(result > 0){
            return result;
        }
        return 0;
    }

    /* 修改班级信息 */
    @Override
    public int updateClass(EasClass easClass) {
        int result = easClassMapper.updateClass(easClass);
        if(result > 0) {
            return result;
        }
        return 0;
    }

    /* 分页查询 */
    @Override
    public PageHelperUtil<EasClass> easClassList(int pageNum, int pageSize) {
        int count = easClassMapper.getCount();
        int offSet = (pageNum - 1) * pageSize;
        List<EasClass> easClassesList = easClassMapper.easClassList(pageNum, pageSize, offSet);
        //创建分页对象
        PageHelperUtil<EasClass> pageHelper = new PageHelperUtil<>();

        pageHelper.setPageNum(pageNum);
        pageHelper.setPageSize(pageSize);
        pageHelper.setPages((int) Math.ceil((double) count/ pageSize));
        pageHelper.setTotal(count);
        pageHelper.setList(easClassesList);
        return pageHelper;
    }


    /* 获取总页数 */
    @Override
    public int getCount() {
        int result = easClassMapper.getCount();
        if(result > 0 ){
            return result;
        }
        return 0;
    }



    /* 模糊查询获得所有的班级信息 分页查询 */
    @Override
    public PageHelperUtil<EasClassFuzzyQuery> getList(EasClassFuzzyQuery easClassFuzzyQuery) {
        int count = easClassMapper.getFuzzyCount(easClassFuzzyQuery.getClasses());
        Integer pageNum = easClassFuzzyQuery.getPageNum();
        Integer pageSize = easClassFuzzyQuery.getPageSize();
        int offSet = (pageNum - 1) * pageSize;
        List<EasClassFuzzyQuery> easClassMapperList = easClassMapper.getList(easClassFuzzyQuery, offSet);
        /* 创建分页对象 */
        PageHelperUtil<EasClassFuzzyQuery> pageHelper = new PageHelperUtil<>();
        pageHelper.setPageNum(pageNum);
        pageHelper.setPageSize(pageSize);
        pageHelper.setPages((int) Math.ceil((double) count/ pageSize));
        pageHelper.setTotal(count);
        pageHelper.setList(easClassMapperList);
        return pageHelper;
    }


    /* 批量删除 */
    @Override
    public int batchDeleteClass(Integer[] ids) {
        int result = easClassMapper.batchDeleteClass(ids);
        if(result > 0){
            return result;
        }
        return 0;
    }

    /* 单个删除 */
    @Override
    public int deleteById(Long id) {
        int result = easClassMapper.deleteById(id);
        if(result > 0){
            return result;
        }
        return 0;
    }

}
