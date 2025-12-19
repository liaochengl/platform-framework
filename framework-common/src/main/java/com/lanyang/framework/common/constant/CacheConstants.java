package com.lanyang.framework.common.constant;

/**
 * 缓存常量信息
 *
 * @author lanyang
 */
public class CacheConstants {
    /**
     * 缓存有效期，默认720（分钟）
     */
    public final static long EXPIRATION = 720L;

    /**
     * 缓存刷新时间，默认120（分钟）
     */
    public final static long REFRESH_TIME = 120L;

    /**
     * 密码最大错误次数
     */
    public final static int PASSWORD_MAX_RETRY_COUNT = 5;

    /**
     * 密码锁定时间，默认10（分钟）
     */
    public final static long PASSWORD_LOCK_TIME = 10;

    /**
     * 权限缓存前缀
     */
    public final static String LOGIN_TOKEN_KEY = "LOGIN_TOKENS:";

    /**
     * 登录用户
     */
    public final static String LOGIN_USER = "LOGIN_USER:";

    /**
     * 管理后台登录用户
     */
    public final static String LOGIN_USER_MANAGE = "LOGIN_USER:MANAGE:";

    /**
     * 验证码 redis key
     */
    public static final String CAPTCHA_CODE_KEY = "captcha_codes:";

    /**
     * 参数管理 cache key
     */
    public static final String SYS_CONFIG_KEY = "sys_config:";

    /**
     * 字典管理 cache key
     */
    public static final String SYS_DICT_KEY = "sys_dict:";

    /**
     * 登录账户密码错误次数 redis key
     */
    public static final String PWD_ERR_CNT_KEY = "pwd_err_cnt:";

    /**
     * 登录IP黑名单 cache key
     */
    public static final String SYS_LOGIN_BLACKIPLIST = SYS_CONFIG_KEY + "sys.login.blackIPList";


    /**
     * 设备信息 redis key
     */
    public static final String DEVICES_CACHE_INFO_KEY = "devices_cache_info:";

    /**
     * 设备监控信息 redis key
     */
    public static final String DEVICES_MONITOR_WS_INFO_KEY = "device_monitor_ws_info:";

    /**
     * 数据看板信息 redis key
     */
    public static final String DATA_BOARD_WS_INFO_KEY = "storages_devices_ws_info:";
    /**
     * 驾驶舱 redis key
     */
    public static final String COCKPIT_WS_INFO_KEY = "cockpit_devices_ws_info:";

    /**
     * 一次性接线图 redis key
     */
    public static final String WIRING_DIAGRAM_WS_INFO_KEY = "wiring_diagram_devices_ws_info:";

    /**
     * 设备告警信息 redis key
     */
    public static final String DEVICES_WARNING_WS_INFO_KEY = "device_warning_ws_info:";

    /**
     * 全局限值设置信息 redis key
     */
    public static final String EMS_GLOBAL_KEY = "ems_global_config:";
}
