package org.lanqiao.educationaladministrationsystem.controller;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.apache.ibatis.annotations.Param;
import org.lanqiao.educationaladministrationsystem.dto.EasUser.EasUserLongin;
import org.lanqiao.educationaladministrationsystem.dto.PassWord.RestPassword;
import org.lanqiao.educationaladministrationsystem.pojo.EasRole;
import org.lanqiao.educationaladministrationsystem.pojo.EasStudent;
import org.lanqiao.educationaladministrationsystem.pojo.EasUser;
import org.lanqiao.educationaladministrationsystem.pojo.EasUserRole;
import org.lanqiao.educationaladministrationsystem.service.EasRoleService;
import org.lanqiao.educationaladministrationsystem.service.EasStudentService;
import org.lanqiao.educationaladministrationsystem.service.EasUserService;
import org.lanqiao.educationaladministrationsystem.utils.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

@RestController
@Transactional(rollbackFor = Exception.class)
public class LoginController {
    @Autowired
    private EasUserService easUserService;
    @Autowired
    private EasRoleService easRoleService;
    @Autowired
    private EasStudentService easStudentService;

    @RequestMapping("/login")
    public ResponseUtil Login(@RequestBody EasUserLongin easUserLongin, HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException {
        /**
         *  1.管理员在登录的时候要将管理员的id存入session 中为后期修改密码用
         *  2.在登录的时候
         *  3.先判断验证码
         */

        // 1.先判断验证码是否正确
        /* 拿到后端生成的验证码 */
        String  code = (String) request.getSession().getAttribute("code");
        /* 用户输入的验证码 */
        String userCode = easUserLongin.getCaptcha();
        if(userCode.equalsIgnoreCase(code)){
            //验证码正确
            /* 登录 */
            EasUser byUserName = easUserService.getByUserName(easUserLongin.getUsername());
            if(byUserName != null){
                /* 判断用户是否勾选了记住我 */
                if(easUserLongin.getRememberMe() == true){
                    // 勾选后将用户的用户名和密码存储在cookie中
                    Cookie cookie = new Cookie("username", URLEncoder.encode(easUserLongin.getUsername(), "UTF-8"));
                    Cookie cookie1 = new Cookie("password", URLEncoder.encode(easUserLongin.getPassword(), "UTF-8"));
                    cookie.setMaxAge(60 * 60 * 24 * 7);
                    cookie1.setMaxAge(60 * 60 * 24 * 7);
                    // 设置cookie的路径，使其在整个应用中可用
                    cookie.setPath("/");
                    cookie1.setPath("/");
                    response.addCookie(cookie);
                    response.addCookie(cookie1);
                }
                /* 登录成功 */
                /* 将用户的id存储到session中 */
                request.getSession().setAttribute("id",byUserName.getId());
                // 要拿到登录用户的id来获取角色id
                int roleId = easRoleService.getRoleId(byUserName.getId());
                if(roleId != 1){
                    EasStudent easStudent = easStudentService.selectOneByUsername(easUserLongin.getUsername());
                    System.out.println(easStudent);
                    return new ResponseUtil(200,"登录成功",easStudent);
                }
                return new ResponseUtil(200,"登录成功",roleId);


            }else{
                return new ResponseUtil(305,"用户不存在,请先注册");
            }
        }else{
            return new ResponseUtil(500,"验证码有误");
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

            if(byUserName != null){
                return new ResponseUtil(305,"用户已存在");
            }else{

                int result = easUserService.register(easUser);
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