package com.punishment.listener;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.read.listener.ReadListener;
import com.punishment.domain.Cls;
import com.punishment.domain.vo.ExcelVo;
import com.punishment.service.ClsService;
import com.punishment.service.ClsUserService;
import com.punishment.service.PunishmentService;
import com.punishment.service.UserService;
import com.punishment.util.SpringUtils;
import lombok.extern.slf4j.Slf4j;

// 有个很重要的点 DemoDataListener 不能被spring管理，要每次读取excel都要new,然后里面用到spring可以构造方法传进去
@Slf4j
public class DataListener implements ReadListener<ExcelVo> {

    /**
     * 假设这个是一个DAO，当然有业务逻辑这个也可以是一个service。当然如果不用存储这个对象没用。
     */
    private ClsService clsService;
    private ClsUserService clsUserService;
    private UserService userService;
    private PunishmentService punishmentService;

    public DataListener() {
        // 获取bean
        clsService = SpringUtils.getBean(ClsService.class);
        clsUserService = SpringUtils.getBean(ClsUserService.class);
        userService = SpringUtils.getBean(UserService.class);
        punishmentService = SpringUtils.getBean(PunishmentService.class);
    }

    /**
     * 这个每一条数据解析都会来调用
     *
     * @param data    one row value. Is is same as {@link AnalysisContext#readRowHolder()}
     * @param context
     */
    @Override
    public void invoke(ExcelVo data, AnalysisContext context) {
        if(data.getNickName() == null || data.getNickName().equals("")) {
            return;
        }
        Long count = clsService.lambdaQuery().eq(Cls::getClsName, data.getClsName()).count();
        if(count == 0L) {
            Cls cls = new Cls();
            cls.setClsName(data.getClsName());
            clsService.save(cls);
        }
    }

    /**
     * 所有数据解析完成了 都会来调用
     *
     * @param context
     */
    @Override
    public void doAfterAllAnalysed(AnalysisContext context) {
        log.info("所有数据解析完成！");
    }

}