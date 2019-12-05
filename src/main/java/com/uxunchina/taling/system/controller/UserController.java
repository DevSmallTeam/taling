package com.uxunchina.taling.system.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.uxunchina.taling.common.controller.BaseController;
import com.uxunchina.taling.common.entity.Content;
import com.uxunchina.taling.common.entity.DataResponse;
import com.uxunchina.taling.system.entity.SysRole;
import com.uxunchina.taling.system.entity.User;
import com.uxunchina.taling.system.service.SysRoleService;
import com.uxunchina.taling.system.service.UserService;
import com.uxunchina.taling.common.utils.ShiroUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * (User)表控制层
 *
 * @author chenfeng
 * @since 2019-08-31 16:35:04
 */
@Api(tags = "用户操作接口")
@Controller
@RequestMapping("user")
public class UserController extends BaseController {


    /**
     * 服务对象
     */
    @Resource
    private UserService userService;
    /**
     * 系统角色 service
     */
    @Resource
    private SysRoleService sysRoleService;


    /**
     * 进入修改密码页面
     * @return
     */
    @ApiOperation("进入修改密码页面")
    @GetMapping("modifyPassword")
    public String modifyPassword(){
        return "user/modifyPassword";
    }

    /**
     * 修改用户密码
     * @return
     */
    @ApiOperation("修改用户密码")
    @ResponseBody
    @PostMapping("modifyPassword")
    public DataResponse modifyPassword(@RequestParam("password") String password,
                                              @RequestParam("newPassword") String newPassword,
                                              @RequestParam("confirmPassword") String confirmPassword){
        if(StringUtils.isBlank(password)){
            msg = "原密码不能为空";
            return new DataResponse().fail().message(msg);
        }
        if(StringUtils.isBlank(newPassword)){
            msg = "新密码不能为空";
            return new DataResponse().fail().message(msg);
        }
        if(!newPassword.equals(confirmPassword)){
            msg = "两次密码输入不一致";
            return new DataResponse().fail().message(msg);
        }
        //根据userName查询出用户信息
        User user = userService.queryByUserName(getUser().getUserName());
        String oldPassword = ShiroUtils.MD5(password,user.getSalt());
        if(!oldPassword.equals(user.getPassword())){
            msg = "您输入的原密码不正确";
            return new DataResponse().fail().message(msg);
        }
        //必须先设置加密盐
        user.setSalt(ShiroUtils.getSalt());
        user.setPassword(ShiroUtils.MD5(newPassword,user.getSalt()));
        userService.updateById(user);
        //修改密码成功之后将用户信息注销
        logOut();
        return new DataResponse().success().message(msg);
    }

    /**
     * 进入用户管理页面
     * @return
     */
    @ApiOperation(value = "进入用户列表页面")
    @RequiresPermissions("user:view")
    @GetMapping("userList")
    public String userList(Model model){
        return "system/user";
    }

    /**
     * 分页查询用户数据
     * @param pageNumber
     * @param pageSize
     * @return
     */
    @ApiOperation(value = "分页查询用户信息")
    @PostMapping("userList")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pageNumber",value = "当前页 ",required = true),
            @ApiImplicitParam(name = "pageSize",value = "每页总页数",defaultValue = "10"),
            @ApiImplicitParam(name = "userName",value = "用户名"),
            @ApiImplicitParam(name = "nickName",value = "用户昵称"),
    })
    @RequiresPermissions("user:view")
    @ResponseBody
    public DataResponse userList(@RequestParam Integer pageNumber,
                                 @RequestParam(defaultValue = "10") Integer pageSize,
                                 User user){
        Page<User> page = getPage(pageNumber, pageSize);
        QueryWrapper<User>  ew = new QueryWrapper<User>();
        if(user != null){
            if(StringUtils.isNotBlank(user.getUserName())){
                ew.like("user_name",user.getUserName());
            }
            if(StringUtils.isNotBlank(user.getNickName())){
                ew.like("nick_name",user.getNickName());
            }
        }
        IPage<User> pageData = userService.queryAllUser(page,ew);
        return new DataResponse().success().count(page.getTotal()).data(pageData.getRecords());
    }

    /**
     * 修改用户信息
     * @param type
     * @param userId
     * @param state
     * @return
     */
    @ApiOperation(value = "修改用户信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "type",value = "操作类型 "+Content.EDIT_TYPE_STATE+"：修改用户状态，"+Content.EDIT_TYPE_RESET_PSW+"：重置用户密码",required = true),
            @ApiImplicitParam(name = "userId",value = "用户ID",required = true),
            @ApiImplicitParam(name = "state",value = "用户状态 0：锁定 1：正常")
    })
    @ResponseBody
    @RequiresPermissions("user:edit")
    @PostMapping("editUser")
    public DataResponse editUser(@RequestParam(value = "type") String type,
                                 @RequestParam(value = "userId") Long userId,
                                 @RequestParam(value = "state",required = false) String state){
        User user = userService.getById(userId);
        //如果是修改用户状态
        if(Content.EDIT_TYPE_STATE.equals(type)){
            if(userId.equals(getUser().getUserId())){
                return new DataResponse().fail().message("不允许操作当前登录用户");
            }
            user.setState(state);
            userService.updateById(user);
            return new DataResponse().success().message("修改用户状态成功");
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
                return new DataResponse().code(Content.RESTPSW_SUCCESS).message("当前用户重置密码为【"+Content.DEFALT_PSW+"】成功");
            }
            return new DataResponse().success().message("重置用户密码为【"+Content.DEFALT_PSW+"】成功");
        }
        return new DataResponse().fail().message("服务器异常，请联系管理员");
    }

    @ApiOperation(value = "删除用户")
    @ApiImplicitParam(name = "userId",value = "用户ID")
    @RequiresPermissions("user:del")
    @ResponseBody
    @PostMapping("delUser")
    public DataResponse delUser(@RequestParam(value = "userId")Long userId){
        if(userId.equals(getUser().getUserId())){
            return new DataResponse().fail().message("不允许删除当前登录用户");
        }
        userService.deleteUser(userId);
        return new DataResponse().success().message("删除用户成功");
    }

    /**
     * 查询所有的角色
     * @return
     */
    @RequiresPermissions("role:view")
    @ResponseBody
    @PostMapping("role")
    public DataResponse role(){
        List<SysRole> sysRoleList = sysRoleService.list(new QueryWrapper<SysRole>().lambda().eq(SysRole::getAvailable,true));
        return new DataResponse().success().data(sysRoleList);
    }

    /**
     * 新增用户
     * @param user
     * @return
     */
    @RequiresPermissions("user:add")
    @ResponseBody
    @PostMapping("addUser")
    public DataResponse addUser(User user){
        User u = userService.queryByUserName(user.getUserName());
        if(u != null){
            return new DataResponse().fail().message("该账号已存在");
        }
        this.userService.createUser(user);
        return new DataResponse().success().message("新增用户成功");
    }

    @RequiresPermissions("user:edit")
    @ResponseBody
    @PostMapping("updateUser")
    public DataResponse updateUser(User user){
        if(user.getUserId() == null){
            return new DataResponse().fail().message("用户ID不能为空");
        }
        this.userService.updateUser(user);
        return new DataResponse().success().message("修改用户信息成功");
    }


}