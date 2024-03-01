package com.punishment.config;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.util.Date;

@Slf4j
@Component
public class MyMetaObjectHandler implements MetaObjectHandler {

    @Override
    public void insertFill(MetaObject metaObject) {
        log.info("start insert fill ....");
        Date date = new Date();
        this.strictInsertFill(metaObject, "createTime", () -> date, Date.class); // 起始版本 3.3.3(推荐)
        this.strictUpdateFill(metaObject, "updateTime", () -> date, Date.class); // 起始版本 3.3.3(推荐)

    }

    @Override
    public void updateFill(MetaObject metaObject) {
        log.info("start update fill ....");
        // 或者
        this.strictUpdateFill(metaObject, "updateTime", Date::new, Date.class); // 起始版本 3.3.3(推荐)
    }
}