package com.rtstjkx.jkx;

import com.rtstjkx.jkx.netty.BootNettyServer;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@MapperScan("com.rtstjkx.jkx.repository")
@SpringBootApplication
@EnableScheduling //开启定时任务
public class KjxApplication implements CommandLineRunner {

    @Value("${netty.port}")
    private Integer  port;

    @Autowired
    BootNettyServer bootNettyServer;
    public static void main(String[] args) throws Exception {
        SpringApplication.run(KjxApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        /**
         * 启动netty服务端服务
         */
        bootNettyServer.run(port);
    }
}
