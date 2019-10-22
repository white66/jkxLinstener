package com.rtstjkx.jkxlistener;

import com.rtstjkx.jkxlistener.netty.BootNettyServer;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@MapperScan("com.rtstjkx.jkxlistener.repository")
@EnableScheduling
@SpringBootApplication
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
