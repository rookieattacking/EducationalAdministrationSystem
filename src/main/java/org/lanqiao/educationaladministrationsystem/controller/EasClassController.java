package org.lanqiao.educationaladministrationsystem.controller;

import org.lanqiao.educationaladministrationsystem.dto.EasClass.EasClassFuzzyQuery;
import org.lanqiao.educationaladministrationsystem.dto.page.Page;
import org.lanqiao.educationaladministrationsystem.pojo.EasClass;
import org.lanqiao.educationaladministrationsystem.service.EasClassService;
import org.lanqiao.educationaladministrationsystem.utils.PageHelperUtil;
import org.lanqiao.educationaladministrationsystem.utils.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Transactional(rollbackFor = Exception.class) // 回滚
@RequestMapping("/class")
public class EasClassController {
    @Autowired
    private EasClassService easClassService;

    /* 查询所有的班级信息分页 */
    @RequestMapping("/queryClassAll")
    public ResponseUtil getAll(@RequestBody Page page){
        PageHelperUtil<EasClass> pageHelperUtil = easClassService.easClassList(page.getPageNum(), page.getPageSize());
        if(pageHelperUtil != null){
            return new ResponseUtil(200,"查询成功",pageHelperUtil);
        }else {
            return new ResponseUtil(305,"查询失败");
        }
    }
    /* 添加班级信息 */
    @RequestMapping("/addClass")
    public ResponseUtil addClass(@RequestBody EasClass easClass){
        int result = easClassService.addClass(easClass);
        if(result > 0){
            return new ResponseUtil(200,"添加成功");
        }else {
            return new ResponseUtil(305,"添加失败");
        }
    }

    /* 修改班级信息 */
    @RequestMapping("/updateClass")
    public ResponseUtil updateClass(@RequestBody EasClass easClass){
        int result = easClassService.updateClass(easClass);
        if(result > 0){
            return new ResponseUtil(200,"修改成功");
        }else{
            return new ResponseUtil(305,"修改失败");
        }
    }

    /* 模糊查询 分页*/
    @RequestMapping("/fuzzyClassName")
    public ResponseUtil fuzzyClassName(@RequestBody EasClassFuzzyQuery EasClassFuzzyQuery){
        PageHelperUtil<EasClassFuzzyQuery> list = easClassService.getList(EasClassFuzzyQuery);
        if(list != null){
            return new ResponseUtil(200,"分页查询成功",list);
        }else{
            return new ResponseUtil(305,"分页查询失败");
        }
    }



    /*删除班级信息  */
    @RequestMapping("/deleteById")
    public ResponseUtil deleteById(@RequestBody EasClass easClass){
        System.out.println(easClass);
        int result = easClassService.deleteById(easClass.getId());

        if(result > 0){
            return new ResponseUtil(200,"删除成功");
        }else {
            return new ResponseUtil(305,"删除失败");
        }
    }

    /* 批量删除 */
    @RequestMapping("/deleteByIds")
    public ResponseUtil deleteByIds(@RequestBody Integer[] ids){
        int result = easClassService.batchDeleteClass(ids);
        if(result > 0){
            return new ResponseUtil(200,"批量删除成功");
        }else {
            return new ResponseUtil(305,"批量删除失败");
        }
    }

}
