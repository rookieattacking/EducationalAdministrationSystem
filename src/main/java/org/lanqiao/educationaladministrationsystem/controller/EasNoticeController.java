package org.lanqiao.educationaladministrationsystem.controller;

import org.lanqiao.educationaladministrationsystem.pojo.EasNotice;
import org.lanqiao.educationaladministrationsystem.service.EasNoticeService;
import org.lanqiao.educationaladministrationsystem.utils.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
}
