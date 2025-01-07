package org.lanqiao.educationaladministrationsystem.controller;

import org.apache.ibatis.annotations.Param;
import org.lanqiao.educationaladministrationsystem.pojo.EasNotice;
import org.lanqiao.educationaladministrationsystem.service.EasNoticeService;
import org.lanqiao.educationaladministrationsystem.utils.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/notice")
public class EasNoticeController {
    @Autowired
    private EasNoticeService easNoticeService;
    @RequestMapping("/list")
    public ResponseUtil list(){
        List<EasNotice> allList = easNoticeService.getAllList();
        if(allList != null){
            return new ResponseUtil(200,"查询成功",allList);
        }else {
            return new ResponseUtil(305,"查询失败");
        }
    }
    @RequestMapping("detail")
    public ResponseUtil getNoticeDetail(@RequestBody EasNotice easNotice) {
        List<EasNotice> noticeById = easNoticeService.getNoticeById(easNotice.getId());
        if(noticeById != null){
            return new ResponseUtil(200,"查询成功",noticeById);
        }else {
            return new ResponseUtil(305,"查询失败");
        }
    }
    @RequestMapping("delete/{id}")
    public ResponseUtil noticedelete(@PathVariable long id) {
        try {
            int result = easNoticeService.deleteNotice(id);
            if (result > 0) {
                return new ResponseUtil(200, "删除成功");
            } else {
                return new ResponseUtil(305, "删除失败");
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    @RequestMapping(value = "like", method = RequestMethod.POST)
    public ResponseUtil NoticeLike(@RequestBody Map<String, String> params) {
        String title = params.get("title");  // 获取 title 参数
        List<EasNotice> like = easNoticeService.like(title);
        if(like != null){
            return new ResponseUtil(200, "查询成功", like);
        } else {
            return new ResponseUtil(305, "查询失败");
        }
    }
    @RequestMapping("/add")
    public ResponseUtil noticadd(@RequestBody EasNotice easNotice) {
        int result = easNoticeService.addNotice(easNotice);
        if(result>0){
            return new ResponseUtil(200, "添加成功");
        }
        return new ResponseUtil(305, "失败");
    }


    @RequestMapping("/deletlist")
    public ResponseUtil noticeDeleteList(@RequestBody List<Integer> ids) {
        int result = easNoticeService.deleteNoticeList(ids);  // 调用服务层批量删除方法
        if (result > 0) {
            return new ResponseUtil(200, "删除成功");
        }
        return new ResponseUtil(305, "删除失败");
    }

}