package com.uxunchina.taling.service.impl;

import com.uxunchina.taling.entity.LoginLog;
import com.uxunchina.taling.mapper.LoginLogMapper;
import com.uxunchina.taling.service.LoginLogService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.uxunchina.taling.utils.AddressUtil;
import com.uxunchina.taling.utils.HttpContextUtil;
import com.uxunchina.taling.utils.IPUtil;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author chenfeng
 * @since 2019-10-02
 */
@Service
public class LoginLogServiceImpl extends ServiceImpl<LoginLogMapper, LoginLog> implements LoginLogService {

    @Override
    public void saveLoginLog(LoginLog loginLog) {
        loginLog.setLoginTime(new Date());
        HttpServletRequest request = HttpContextUtil.getHttpServletRequest();
        String ip = IPUtil.getIpAddr(request);
        loginLog.setIp(ip);
        loginLog.setLocation(AddressUtil.getCityInfo(ip));
        this.save(loginLog);
    }
}
