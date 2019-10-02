package com.uxunchina.taling.service;

import com.uxunchina.taling.entity.LoginLog;
import com.baomidou.mybatisplus.extension.service.IService;

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
