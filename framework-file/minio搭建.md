### 下载

```
# 下载服务端
wget https://dl.min.io/server/minio/release/linux-amd64/minio
# 将下载所得minio文件拷贝到自己的文件夹去并赋予权限
sudo cp minio /app/minio
sudo chmod +x /app/minio/minio
#在安装目录/app/minio下建立一个文件
sudo mkdir /data

#授权
chmod -R 777 /app/minio 
```

### 启动

```
/app/minio/minio server --console :9001 -address :9000 /app/minio/data
```

### 配置自动启动

####  配置文件

```
# 默认把配置文件放入/etc/default文件夹中，名称为minio
sudo vim /etc/default/minio
# 授权
chmod 777 /etc/default/minio
```

文件内容

```
# 指定数据存储目录(注意：这个目录要存在且拥有相对应的权限)
MINIO_VOLUMES="/app/minio/data"

# 监听端口 服务调用端口和浏览器访问端口
MINIO_OPTS="--address :9000 --console-address :9001"

# 新版本使用；指定默认的用户名和密码，其中用户名必须大于3个字母，否则不能启动
MINIO_ROOT_USER="minioadmin"
MINIO_ROOT_PASSWORD="minioadmin"

# 区域值，标准格式是“国家-区域-编号”，
MINIO_REGION="cn-north-1"
这个配置需要在构建MinioClient时设置，不然会报错 The authorization header is malformed; the region is wrong; expecting 'cn-north-1'
@Configuration
@EnableConfigurationProperties(MinioProperties.class)
public class MinioConfig {
    @Bean
    public MinioClient minioClient(MinioProperties properties) {
        return new MinioClient.Builder().region("cn-north-1")
                .endpoint(properties.getEndPoint())
                .credentials(properties.getUsername(), properties.getPassword())
                .build();
    }
}

# 域名
# MINIO_DOMAIN=minio.your_domain.com
```

#### 编写服务文件

创建minio.service服务文件，并写入配置信息

```
sudo vim /usr/lib/systemd/system/minio.service
```

文件内容

```
[Unit]
Description=MinIO
Documentation=https://docs.min.io
Wants=network-online.target
After=network-online.target
# 服务安装路径，指向到下载的minio文件
AssertFileIsExecutable=/app/minio/minio
[Service]
# 文件安装目录
WorkingDirectory=/app/minio


# 配置文件
EnvironmentFile=/etc/default/minio

ExecStartPre=/bin/bash -c "if [ -z \"${MINIO_VOLUMES}\" ]; then echo  \"Variable MINIO_VOLUMES not set in /etc/default/minio ${MINIO_VOLUMES} 1\"; exit 1; fi"
ExecStart=/app/minio/minio server $MINIO_OPTS $MINIO_VOLUMES

# Let systemd restart this service always
Restart=always

# Specifies the maximum (1M) file descriptor number that can be opened by this process
LimitNOFILE=1048576

# Specifies the maximum number of threads this process can create
TasksMax=infinity

# Disable timeout logic and wait until process is stopped
TimeoutStopSec=infinity
SendSIGKILL=no
SuccessExitStatus=0

[Install]
WantedBy=multi-user.target
Alias=minio.service
```

### 启动服务

```
# 重新加载服务配置文件，使服务生效
systemctl daemon-reload

# 将服务设置为开机启动
systemctl enable minio

# 服务立即启动
systemctl start minio

# 查看minio服务当前状态
systemctl status minio
```

```
● minio.service - MinIO
   Loaded: loaded (/usr/lib/systemd/system/minio.service; enabled; vendor preset: disabled)
   Active: active (running) since 四 2024-09-12 11:26:05 CST; 22min ago
     Docs: https://docs.min.io
  Process: 69909 ExecStartPre=/bin/bash -c if [ -z "${MINIO_VOLUMES}" ]; then echo  "Variable MINIO_VOLUMES not set in /etc/default/minio ${MINIO_VOLUMES} 1"; exit 1; fi (code=exited, status=0/SUCCESS)
 Main PID: 69910 (minio)
   CGroup: /system.slice/minio.service
           └─69910 /app/minio/minio server --address :9000 --console-address :9001 /app/minio/data

9月 12 11:26:05 localhost.localdomain systemd[1]: Started MinIO.
9月 12 11:26:05 localhost.localdomain minio[69910]: MinIO Object Storage Server
9月 12 11:26:05 localhost.localdomain minio[69910]: Copyright: 2015-2024 MinIO, Inc.
9月 12 11:26:05 localhost.localdomain minio[69910]: License: GNU AGPLv3 - https://www.gnu.org/licenses/agpl-3.0.html
9月 12 11:26:05 localhost.localdomain minio[69910]: Version: RELEASE.2024-09-09T16-59-28Z (go1.22.7 linux/amd64)
9月 12 11:26:05 localhost.localdomain minio[69910]: API: http://192.168.0.57:9000  http://127.0.0.1:9000
9月 12 11:26:05 localhost.localdomain minio[69910]: WebUI: http://192.168.0.57:9001 http://127.0.0.1:9001
9月 12 11:26:05 localhost.localdomain minio[69910]: Docs: https://docs.min.io
9月 12 11:26:05 localhost.localdomain minio[69910]: WARN: Detected Linux kernel version older than 4.0 release, there are some known potential performance problems with this kernel version. MinIO recomm...st performance
9月 12 11:26:05 localhost.localdomain minio[69910]: WARN: Detected default credentials 'minioadmin:minioadmin', we recommend that you change these values with 'MINIO_ROOT_USER' and 'MINIO_ROOT_PASSWORD'...ment variables
Hint: Some lines were ellipsized, use -l to show in full.

```

