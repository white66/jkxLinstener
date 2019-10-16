package com.rtstjkx.jkx.controller;

import com.github.pagehelper.PageHelper;
import com.rtstjkx.jkx.bean.ResponseCode;
import com.rtstjkx.jkx.entity.systemInfo.User;
import com.rtstjkx.jkx.service.serviceImpl.UserServiceImpl;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * <p>
 *  管理用户前端控制器
 * </p>
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserServiceImpl userService;

    @Autowired
    private ResponseCode response;

    /**
     * 用户查询.
     * @return
     */
    @GetMapping("/userList")
    @RequiresPermissions("user:view")//权限管理;
    public ResponseCode listUsers(@RequestBody int pageNo, @RequestBody int pageNum){
        PageHelper.startPage(pageNo,pageNum);
        List<User> users = userService.listUsers();
        return response.success("查询成功！", users);
    }
    /**
     * 用户添加;
     * @return
     */
    @PostMapping("/userAdd")
    @RequiresPermissions("user:add")//权限管理;
    public ResponseCode userInfoAdd(@RequestBody User user){
        Map<String,Object> resultMap = userService.addUser(user);
        return response.success(resultMap);
    }
    /**
     * 用户删除;
     * @return
     */
    @DeleteMapping("/userDel")
    @RequiresPermissions("user:del")//权限管理;
    public ResponseCode userDel(@RequestBody User user){
        Map<String,Object> resultMap = userService.delUser(user);
        return response.success(resultMap);
    }
    /**
     * 通过用户名userName查询用户信息
     * @param userName
     * @return
     */
    @GetMapping("/userOne")
    public ResponseCode selectUserByUserName(@RequestBody String userName){
        User user = userService.findUserByAccount(userName);
        return response.success("查询成功！",user);
    }
    /**
     * 修改用户信息
     * @param user
     * @return
     */
    @PostMapping("/userUpdate")
    public ResponseCode updateUser(@RequestBody User user){
        Map<String,Object> resultMap = userService.updateUser(user);
        return response.success(resultMap);
    }
    /**
     * 重置用户密码，默认为123456
     * @param user
     * @return
     */
    @PostMapping("/userReSet")
    public ResponseCode reSetPassWord(@RequestBody User user){
        user.setPassWord("123456");
        Map<String,Object> resultMap = userService.updateUser(user);
        return response.success(resultMap);
    }
}
