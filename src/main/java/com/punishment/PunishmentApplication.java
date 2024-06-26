package com.punishment;

import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@Slf4j
@SpringBootApplication
@MapperScan(basePackages = "com.punishment.mapper")
public class PunishmentApplication {

    public static void main(String[] args) {
        SpringApplication.run(PunishmentApplication.class, args);
        log.info("项目启动成功！");
    }

}
