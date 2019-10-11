package com.rtstjkx.jkx.controller;

import com.rtstjkx.jkx.bean.CacheUser;
import com.rtstjkx.jkx.bean.ResponseCode;
import com.rtstjkx.jkx.entity.systemInfo.User;
import com.rtstjkx.jkx.service.serviceImpl.UserServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class LoginController {
    @Autowired
    UserServiceImpl userService;
    @Autowired
    ResponseCode responseCode;
    /**
     * 登陆操作
     * @param user
     * @return
     */
    @PostMapping("/login")
    public ResponseCode login(User user){
        log.warn("进入登录....");
        String userName = user.getUserName();
        String passWord = user.getPassWord();
        if(null==userName||" ".equals(userName)){
            return  responseCode.failure("用户名不能为空！");
        }
        if(null==passWord||" ".equals(passWord)){
            return responseCode.failure("密码不能为空！");
        }
        CacheUser loginUser =  userService.login(userName,passWord);
        // 登录成功返回用户信息
        return responseCode.success("登录成功！", loginUser);
    }
    /**
     * description: 登出
     * create time: 2019/6/28 17:37
     */
    @GetMapping("/logout")
    public ResponseCode logOut() {
        userService.logout();
        return responseCode.success("登出成功！");
    }

    /**
     * 未登录，shiro应重定向到登录界面，此处返回未登录状态信息由前端控制跳转页面
     * create time: 2019/7/3 14:53
     * @return
     */
    @RequestMapping("/un_auth")
    public ResponseCode unAuth() {
        return responseCode.failure(HttpStatus.UNAUTHORIZED, "用户未登录！", null);
    }

    /**
     * 未授权，无权限，此处返回未授权状态信息由前端控制跳转页面
     * create time: 2019/7/3 14:53
     * @return
     */
    @RequestMapping("/unauthorized")
    public ResponseCode unauthorized() {
        return responseCode.failure(HttpStatus.FORBIDDEN, "用户无权限！", null);
    }
}
