# framework-platform：企业级Spring多模块开发底座


一款**企业级多模块Spring技术底座**，基于模块化拆分封装通用能力，覆盖基础工具、数据持久化、缓存、支付、安全等核心场景，支持业务系统快速复用与扩展。


## 📌 核心架构（模块化设计）
项目采用**“基础依赖+功能组件+Web封装”**的分层模块化结构，各模块独立维护、按需引入：

| 模块名                     | 功能定位     | 核心能力                                                     |
| -------------------------- | ------------ | ------------------------------------------------------------ |
| **framework-dependencies** | 统一依赖管理 | 管控所有第三方组件版本（SpringBoot、MyBatis-Plus等），避免版本冲突 |
| **framework-common**       | 通用基础组件 | 工具类（日期/加密/JSON）、全局异常、统一响应、枚举/常量规范  |
| **framework-mybatis-plus** | 数据持久层   | MyBatis-Plus增强（分页/逻辑删除）                            |
| **framework-redis**        | 缓存中间件   | RedisTemplate封装、分布式锁                                  |
| **framework-web-common**   | Web基础能力  | 拦截器/过滤器                                                |
| **framework-web-security** | 安全组件     | 权限认证、接口鉴权、JWT封装                                  |
| **framework-http**         | 网络请求     | 第三方接口调用封装（RestTemplate/OkHttp）                    |
| **framework-file**         | 文件处理     | 基于minio文件上传/下载                                       |
| **framework-pay**          | 支付集成     | 多渠道支付（微信/支付宝）、支付回调                          |
| **framework-message**      | 消息通知     | 目前仅支持微信(订阅和模板)消息                               |
| **framework-netty**        | 高性能通信   | 长连接服务                                                   |
| **framework-log**          | 日志组件     | 日志采集、暂时不完善                                         |
| **framework-swagger**      | 接口文档     | 自动生成API文档、接口调试、文档导出（Markdown/HTML）         |


## 🚀 快速使用
### 1. 环境要求
- JDK：8+
- 构建工具：Maven 3.6+
- 中间件：Redis 5.0+（按需）、MySQL 5.8+（按需）

## 🛠️ 项目优势

1. **模块化复用**：各能力拆分为独立模块，业务系统可按需引入，避免冗余
2. **版本统一**：通过`framework-dependencies`管控所有依赖版本，解决版本冲突
3. **企业级特性**：内置支付、安全、消息等高频业务组件，覆盖 80% 后端开发场景
4. **易扩展**：部分模块支持自定义实现替换默认逻辑，如framework-web-security中获取当前登录用户