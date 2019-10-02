package com.uxunchina.taling.controller;

import com.google.code.kaptcha.Constants;
import com.google.code.kaptcha.servlet.KaptchaExtend;
import com.uxunchina.taling.entity.LoginLog;
import com.uxunchina.taling.entity.User;
import com.uxunchina.taling.service.LoginLogService;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.DisabledAccountException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import java.io.IOException;

/**
 * @author chenfeng
 * @Package com.uxunchina.taling.controller
 * @date 2019-08-31 10:13
 */
@Slf4j
@Controller
public class LoginController extends BaseController{


    @Resource
    private LoginLogService loginLogService;

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
    public String doLogin(@RequestParam( value = "userName")String userName,
                          @RequestParam(value = "password")String passWord,
                          @RequestParam(value = "captcha")String captcha,
                          @RequestParam(value = "rememberMe",defaultValue = "false")Boolean rememberMe,
                          Model model){
        model.addAttribute("userName",userName);
        // 验证图形验证码
        KaptchaExtend kaptchaExtend = new KaptchaExtend();
        String codeimg = kaptchaExtend.getGeneratedKey(request);
        // 图形验证码为一次性的
        session.removeAttribute(Constants.KAPTCHA_SESSION_KEY);
        // 验证
        if (codeimg == null || !codeimg.equalsIgnoreCase(captcha)) {
            msg = "验证码错误";
            model.addAttribute("message",msg);
            return "user/login";
        }

        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken(userName,passWord,rememberMe);
        try {
            subject.login(usernamePasswordToken);
            // 保存登录日志
            LoginLog loginLog = new LoginLog();
            loginLog.setUserName(userName);
            loginLog.setSystemBrowserInfo();
            this.loginLogService.saveLoginLog(loginLog);

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

    /**
     * 验证码
     */
    @RequestMapping("/captcha")
    @ResponseBody
    public void captcha() throws ServletException, IOException {
        KaptchaExtend kaptchaExtend = new KaptchaExtend();
        kaptchaExtend.captcha(request, response);
    }

   @GetMapping("logout")
   public String logout(){
        logOut();
        return "user/login";
   }
}