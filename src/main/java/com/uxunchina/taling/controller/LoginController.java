package com.uxunchina.taling.controller;

import com.uxunchina.taling.entity.User;
import com.uxunchina.taling.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.DisabledAccountException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author chenfeng
 * @Package com.uxunchina.taling.controller
 * @date 2019-08-31 10:13
 */
@Slf4j
@Controller
public class LoginController extends BaseController{

    @Autowired
    public UserService userService;

    @GetMapping("/index")
    public String index(Model model){
        Subject subject = SecurityUtils.getSubject();
        if(subject.isAuthenticated()){
            model.addAttribute("user",getUser());
            return "index";
        }
        return "user/login";
    }

    @GetMapping("/login")
    public String login(){
        return "user/login";
    }

    @PostMapping("/login")
    public String doLogin(@RequestParam( value = "userName",required = true)String userName,
                          @RequestParam(value = "password",required = true)String passWord,
                          @RequestParam(value = "rememberMe",required = true,defaultValue = "false")Boolean rememberMe,
                          Model model){
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken(userName,passWord,rememberMe);
        model.addAttribute("userName",userName);
        try {
            subject.login(usernamePasswordToken);
            User user = (User) subject.getPrincipal();
            model.addAttribute("user",user);
            return "index";
        }catch (UnknownAccountException e){
            msg = "账号不存在";
            log.error("账号不存在！{}",e.getMessage());
        }catch (DisabledAccountException e) {
            msg = "账户已被停用";
            log.error("账户已被停用！{}",e.getMessage());
        } catch (IncorrectCredentialsException e) {
            msg = "密码错误";
            log.error("密码错误！{}",e.getMessage());
        } catch (Throwable e) {
            msg = "未知错误";
            log.error("未知错误！{},{}",e.getMessage(),e);
        }
        model.addAttribute("message",msg);
        return "user/login";
    }
   @GetMapping("logout")
   public String logout(){
        logOut();
        return "user/login";
   }
}