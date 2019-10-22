package com.uxunchina.taling.system.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.uxunchina.taling.system.entity.LoginLog;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author chenfeng
 * @since 2019-10-02
 */
public interface LoginLogService extends IService<LoginLog> {
    /**
     * 保存登录日志
     *
     * @param loginLog 登录日志
     */
    void saveLoginLog(LoginLog loginLog);

}
