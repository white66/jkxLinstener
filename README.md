# kjx
平安城市监控箱采集
技术：springboot+springMVC+mybatis+RabbitMQ+Redis+Netty+Shiro
这是一个自己写的第一个与硬件相关联的项目，目前还在摸搜中
    springboot和springMVC做基础的平台架构，Netty作为NIO框架对监控箱中的下位机的数据进行采集后，通过RabbitMQ消息队列来把采集的数据存入mysql数据库，通过Shiro来对用户进行权限的管理，Redis对Session中的用户信息进行缓存  
