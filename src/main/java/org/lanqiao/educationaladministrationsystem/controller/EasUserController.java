package org.lanqiao.educationaladministrationsystem.controller;

import org.lanqiao.educationaladministrationsystem.dto.EasUser.EasUserQuery;
import org.lanqiao.educationaladministrationsystem.dto.EasUser.FuzzyQuery;
import org.lanqiao.educationaladministrationsystem.dto.page.Page;
import org.lanqiao.educationaladministrationsystem.pojo.EasRole;
import org.lanqiao.educationaladministrationsystem.pojo.EasUser;
import org.lanqiao.educationaladministrationsystem.pojo.EasUserRole;
import org.lanqiao.educationaladministrationsystem.service.EasRoleService;
import org.lanqiao.educationaladministrationsystem.service.EasUserService;
import org.lanqiao.educationaladministrationsystem.utils.PageHelperUtil;
import org.lanqiao.educationaladministrationsystem.utils.ResponseUtil;
import org.lanqiao.educationaladministrationsystem.vo.EasUserVo.EasUserQueryVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/user")
@Transactional(rollbackFor = Exception.class)
public class EasUserController {
    @Autowired
    private EasRoleService easRoleService;
    @Autowired
    private EasUserService easUserService;
    @RequestMapping("/getUserAll")
    public ResponseUtil getUserAll(@RequestBody Page page){
        PageHelperUtil<EasUserQuery> easUserQueryPageHelperUtil = easUserService.pageList(page.getPageNum(), page.getPageSize());
        if(easUserQueryPageHelperUtil != null){
            return new ResponseUtil(200,"分页查询成功",easUserQueryPageHelperUtil);
        }else {
            return new ResponseUtil(305, "查询失败");
        }
        // List<EasUserQuery> easUserQueries = easUserService.queryRole();
        // if(easUserQueries != null){
        //     return new ResponseUtil(200,"查询成功",easUserQueries);
        // }else{
        //     return new ResponseUtil(305,"查询失败");
        // }
    }

    /* 模糊查询 */
    @RequestMapping("/fuzzyQueryByName")
    public ResponseUtil fuzzyQueryByName(@RequestBody FuzzyQuery fuzzyQuery){
        PageHelperUtil<FuzzyQuery> easUserQueryPageHelperUtil = easUserService.fuzzyPageList(fuzzyQuery);
        if(easUserQueryPageHelperUtil != null){
            return new ResponseUtil(200,"模糊分页查询成功",easUserQueryPageHelperUtil);
        }else{
            return new ResponseUtil(305,"查询失败");
        }
        // List<EasUserQuery> list = easUserService.getList(EasUserQuery);
        // if(list != null){
        //     return new ResponseUtil(200,"查询成功",list);
        // }else{
        //     return new ResponseUtil(305,"查询失败");
        // }

    }

    /* 修改用户信息 */
    @RequestMapping("/updateUser")
    public ResponseUtil updateUser(@RequestBody EasUserQuery easUserQuery){
        /* 修改
        *   1.先根据角色名查询出对应的角色id
        *   2.根据用户名查询出用户id
        *   3.修改eas_user表中的信息
        *    4.根据用户id以及角色id来修改角色表中的信息
        * */
        try {
            if(easUserQuery != null){
                //  1.先根据角色名查询出对应的角色id
                EasRole easRole = easRoleService.getRoleView(easUserQuery.getRole());
                System.out.println("角色的id: " +easRole.getId());

                // 2.根据用户名查询出用户id
                EasUser byUserName = easUserService.getByUserName(easUserQuery.getUsername());
                easUserQuery.setId(byUserName.getId());

                System.out.println(easUserQuery);
                // 3.修改eas_user表中的信息
                int result = easUserService.updateUser(easUserQuery);
                // 4.根据用户id以及角色id来修改角色表中的信息
                int result2 = easRoleService.updateBaseCourse(new EasUserRole(byUserName.getId(), easRole.getId()));
                if(result > 0 && result2 > 0){
                    return new ResponseUtil(200,"数据修改成功");
                }else {
                    return new ResponseUtil(305,"数据修改失败");
                }
            }else {
                return new ResponseUtil(305,"数据修改失败");
            }
        } catch (Exception e) {
            return new ResponseUtil(405,"数据查询有误,请联系管理员");
        }

    }

    /* 添加用户 */
    @RequestMapping("/addUser")
    public ResponseUtil addUser(@RequestBody EasUserQuery easUserQuery){
        if(easUserQuery != null){
            // 这里要拿到角色id
            EasRole easRole = easRoleService.getRoleView(easUserQuery.getRole());

            // 将用户添加到eas_user表中
            int result = easUserService.add(new EasUser(easUserQuery.getUsername(), easUserQuery.getPassword(), easUserQuery.getSalt()));

            // 添加后在查询出用户Id   byUserName.getId()
            EasUser byUserName = easUserService.getByUserName(easUserQuery.getUsername());

            // 还要添加到eas_user_role这张表中
            int result2 = easRoleService.addRole(new EasUserRole(byUserName.getId(),easRole.getId()));
            if(result > 0 && result2 > 0){
                return new ResponseUtil(200,"数据添加成功");
            }else{
                return new ResponseUtil(305,"数据添加失败");
            }

        }else{
            return new ResponseUtil(305,"数据添加失败");
        }
    }

    /* 单个删除 */
    @RequestMapping("/deleteById")
    public ResponseUtil deleteById(@RequestBody EasUserQuery easUserQuery){
        if(easUserQuery != null){
            int result = easRoleService.delete(easUserQuery.getId());
            int result2 = easUserService.delete(easUserQuery.getId());
            if(result > 0 && result2 > 0){
                return new ResponseUtil(200,"数据删除成功");
            }else{
                return new ResponseUtil(305,"数据删除失败");
            }
        } else{
            return new ResponseUtil(305,"数据删除失败");
        }
    }


    /* 批量删除 */
    @RequestMapping("/deleteByIds")
    public ResponseUtil deleteByIds(@RequestBody Integer[] ids){
        System.out.println(Arrays.toString(ids));
        if(ids.length > 0){
            int result = easRoleService.batchDeleteRole(ids);
            int result2 = easUserService.batchDelete(ids);
            if(result > 0 && result2 > 0){
                return new ResponseUtil(200,"删除成功");
            }else{
                return new ResponseUtil(305,"数据删除失败");
            }
        }else{
            return new ResponseUtil(305,"数据删除失败");
        }
    }


    /* 查询所有的角色 */
    @RequestMapping("/roleList")
    public ResponseUtil roleList(){
        List<EasRole> roleList = easRoleService.getAll();
        if(roleList != null){
            return new ResponseUtil(200,"查询成功",roleList);
        }else {
            return new ResponseUtil(305,"查询失败");
        }
    }


}
