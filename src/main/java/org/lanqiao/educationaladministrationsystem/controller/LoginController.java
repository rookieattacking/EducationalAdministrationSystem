package org.lanqiao.educationaladministrationsystem.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.apache.ibatis.annotations.Param;
import org.lanqiao.educationaladministrationsystem.dto.PassWord.RestPassword;
import org.lanqiao.educationaladministrationsystem.pojo.EasRole;
import org.lanqiao.educationaladministrationsystem.pojo.EasUser;
import org.lanqiao.educationaladministrationsystem.pojo.EasUserRole;
import org.lanqiao.educationaladministrationsystem.service.EasRoleService;
import org.lanqiao.educationaladministrationsystem.service.EasUserService;
import org.lanqiao.educationaladministrationsystem.utils.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Transactional(rollbackFor = Exception.class)
public class LoginController {
    @Autowired
    private EasUserService easUserService;
    @Autowired
    private EasRoleService easRoleService;

    @RequestMapping("/login")
    public ResponseUtil Login(@RequestBody EasUser easUser,HttpServletRequest request){
        /**
         *  1.管理员在登录的时候要将管理员的id存入session 中为后期修改密码用
         *  2.在登录的时候
         */
        EasUser byUserName = easUserService.getByUserName(easUser.getUsername());
        if(byUserName != null){
            /* 将用户的id存储到session中 */
            request.getSession().setAttribute("id",byUserName.getId());
            // 要拿到登录用户的id来获取角色id
            int roleId = easRoleService.getRoleId(byUserName.getId());
            return new ResponseUtil(200,"登录成功",roleId);

        }else{
            return new ResponseUtil(305,"用户不存在");
        }

    }
    @RequestMapping("/register")
    public ResponseUtil register(@RequestBody EasUser easUser){
        /**
         *  1.先将学生进行添加
         *  2.在根据用户名查询出需要的id
         */
        if(easUser != null){
            EasUser byUserName = easUserService.getByUserName(easUser.getUsername());
            System.out.println(easUser.getId());
            if(byUserName != null){
                return new ResponseUtil(305,"用户已存在");
            }else{
                int result = easUserService.add(easUser);
                /* 查询出的有id的数据 */
                EasUser easUserNew = easUserService.getByUserName(easUser.getUsername());
                /* 用户的Id */
                Integer id = easUserNew.getId();
                /* 注册角色默认为学生  2 默认为学生角色 */
                int result2 = easRoleService.addRole(new EasUserRole(id, 2));
                if(result > 0 && result2 > 0){
                    return new ResponseUtil(200,"注册成功");
                }else{
                    return new ResponseUtil(305,"注册失败");
                }
            }
        }else{
            return new ResponseUtil(305,"注册失败");
        }
    }
    @RequestMapping("/admin/updatePassword")
    public ResponseUtil updatePassword(@RequestBody RestPassword restPassword, HttpServletRequest request){
        HttpSession session = request.getSession();
        String adminId = (String) session.getAttribute("id");
        EasUser easUser = easUserService.queryById(adminId);
        int result = easUserService.updatePassword(easUser,restPassword.getNewPassword());
        if(result > 0){
            return new ResponseUtil(200,"密码修改成功");
        }else {
            return new ResponseUtil(305,"密码修改失败");
        }
    }
}
