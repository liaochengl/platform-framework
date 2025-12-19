package com.lanyang.cloud.framework.log.service;

import com.lanyang.cloud.framework.log.domain.dto.SysOperateLog;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

/**
 * 异步调用日志服务
 *
 * @author lanyang
 */
@Service
@RequiredArgsConstructor
public class AsyncLogService {

//    private final OperateLogService operateLogService;

    /**
     * 保存系统日志记录
     */
    @Async
    public void saveSysLog(SysOperateLog sysOperLog) {
//        operateLogService.saveLog(sysOperLog, FeignHeaderConstants.INNER);
    }
}
