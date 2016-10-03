# jmm-start-demo

## 配置环境 
1. 安装 Gradle `sudo apt install gradle`
2. 安装 MySQL `sudo apt install mysql-server`，具体可以参考 [这里](https://help.ubuntu.com/16.04/serverguide/mysql.html)
    

## 初始化数据库
1. [~] $: cd jmm-start-demo
2. [jmm-start-demo] $: `mysql -u root -p < create_db.sh` （需要输入 mysql root 的密码）
3. [jmm-start-demo] $: `mysql -u root -p -e "select * from jmmStartDemo.users"` （需要输入 mysql root 的密码）  

看到如下输出，表示数据库初始化成功
```shell 
+----+--------+--------+
| id | name   | gender |
+----+--------+--------+
|  1 | Bulma  | female |
|  2 | Vegeta | male   |
|  3 | ChiChi | female |
|  4 | Goku   | male   |
+----+--------+--------+
```

##  运行 demo
1. [~] $: cd jmm-start-demo
2. [jmm-start-demo] $: gradle idea
3. [jmm-start-demo] $: gradle build
4. [jmm-start-deom] $: gradle jettyRun  

此时，在控制台下应该可以看到类似如下的输出：  
```shell
[jmm-start-demo]$ gradle jettyRun
:prepareInplaceWebAppFolder UP-TO-DATE
:createInplaceWebAppFolder UP-TO-DATE
:compileJava UP-TO-DATE
:processResources UP-TO-DATE
:classes UP-TO-DATE
:prepareInplaceWebAppClasses UP-TO-DATE
:prepareInplaceWebApp UP-TO-DATE
:jettyRun
09:53:49 INFO  Jetty 9.2.15.v20160210 started and listening on port 8080
09:53:49 INFO  jmm-start-demo runs at:
09:53:49 INFO    http://localhost:8080/jmm-start-demo
Press any key to stop the server.
> Building 87% > :jettyRun           
```
> 注意：  
1. 在运行 `gradle build` 时，因为第一次下载依赖的 jar 包会花费大约一小时时间，请耐心等候  
2. 运行 `gradle jettyRun` 时，如果出现端口占用情况，请先将占用的端口的进程杀死再运行此命令  

## 在浏览器中验证结果
打开浏览器，输入 `http://localhost:8080/jmm-start-demo/users/1`  
将看到页面打印出 `{"id":1}`  
改变 `1` 为其他数字，可以看到 `id` 随之改变 :)  


