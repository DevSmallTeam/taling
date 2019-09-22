package com.uxunchina.taling.controller;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.uxunchina.taling.bean.Content;
import com.uxunchina.taling.bean.DataResponse;
import com.uxunchina.taling.entity.User;
import com.uxunchina.taling.service.UserService;
import com.uxunchina.taling.utils.ShiroUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (User)表控制层
 *
 * @author chenfeng
 * @since 2019-08-31 16:35:04
 */
@Controller
@RequestMapping("user")
public class UserController extends BaseController {


    /**
     * 服务对象
     */
    @Resource
    private UserService userService;


    /**
     * 进入修改密码页面
     * @return
     */
    @GetMapping("modifyPassword")
    public String modifyPassword(){
        return "user/modifyPassword";
    }

    /**
     * 修改用户密码
     * @return
     */
    @ResponseBody
    @PostMapping("modifyPassword")
    public DataResponse modifyPassword(@RequestParam("password") String password,
                                              @RequestParam("newPassword") String newPassword,
                                              @RequestParam("confirmPassword") String confirmPassword){
        if(StringUtils.isBlank(password)){
            msg = "原密码不能为空";
            return new DataResponse().failure(msg);
        }
        if(StringUtils.isBlank(newPassword)){
            msg = "新密码不能为空";
            return new DataResponse().failure(msg);
        }
        if(!newPassword.equals(confirmPassword)){
            msg = "两次密码输入不一致";
            return new DataResponse().failure(msg);
        }
        //根据userName查询出用户信息
        User user = userService.queryByUserName(getUser().getUserName());
        String oldPassword = ShiroUtils.MD5(password,user.getSalt());
        if(!oldPassword.equals(user.getPassword())){
            msg = "您输入的原密码不正确";
            return new DataResponse().failure(msg);
        }
        //必须先设置加密盐
        user.setSalt(ShiroUtils.getSalt());
        user.setPassword(ShiroUtils.MD5(newPassword,user.getSalt()));
        userService.updateById(user);
        //修改密码成功之后将用户信息注销
        logOut();
        return new DataResponse().ok(msg);
    }

    /**
     * 进入用户管理页面
     * @return
     */
    @GetMapping("userList")
    public String userList(){
        return "system/user";
    }

    /**
     * 分页查询用户数据
     * @param pageNumber
     * @param pageSize
     * @return
     */
    @PostMapping("userList")
    @ResponseBody
    public DataResponse userList(@RequestParam Integer pageNumber,
                                 @RequestParam(defaultValue = "10") Integer pageSize,
                                 User user){
        Page<User> page = getPage(pageNumber, pageSize);
        EntityWrapper<User> ew = new EntityWrapper<User>();
        if(user != null){
            if(StringUtils.isNotBlank(user.getUserName())){
                ew.like("user_name",user.getUserName());
            }
            if(StringUtils.isNotBlank(user.getNickName())){
                ew.like("nick_name",user.getNickName());
            }
        }
        Page<User> pageData = userService.selectPage(page,ew);
        return new DataResponse().okData(page.getTotal(),pageData.getRecords());
    }

    /**
     * 修改用户状态
     * @param userId
     * @param state
     * @return
     */
    @ResponseBody
    @PostMapping("editUser")
    public DataResponse editUser(@RequestParam(value = "type")String type,
                                 @RequestParam(value = "userId") Integer userId,
                                 @RequestParam(value = "state",required = false) String state){
        User user = userService.selectById(userId);
        //如果是修改用户状态
        if(Content.EDIT_TYPE_STATE.equals(type)){
            if(userId.equals(getUser().getUserId())){
                return new DataResponse().failure("不允许操作当前登录用户");
            }
            user.setState(state);
            userService.updateById(user);
            return new DataResponse().ok("修改用户状态成功");
        }
        //重置密码操作
        if(Content.EDIT_TYPE_RESET_PSW.equals(type)){
            user.setSalt(ShiroUtils.getSalt());
            //必须先设置加密盐
            user.setPassword(ShiroUtils.MD5(Content.DEFALT_PSW,user.getSalt()));
            userService.updateById(user);
            if(userId.equals(getUser().getUserId())){
                //如果重置密码为当前用户，则退出登录
                logOut();
                return new DataResponse().response(0,"当前用户重置密码成功");
            }
            return new DataResponse().ok("重置用户密码成功");
        }
        return null;
    }

}