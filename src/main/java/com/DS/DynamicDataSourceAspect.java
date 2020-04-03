package com.DS;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Order(-1)
@Component
@Slf4j
public class DynamicDataSourceAspect {


    /**
     * 执行方法前更换数据源
     *
     * @param joinPoint        切点
     * @param targetDataSource 动态数据源
     */
    @Before("@annotation(targetDataSource)")
    public void doBefore(JoinPoint joinPoint, DS targetDataSource) {
        DataSourceKey dataSourceKey = targetDataSource.value() ;
        log.info(String.format("设置数据源为  %s", dataSourceKey.getName()));
        for(DataSourceKey e : DataSourceKey.values()) {
            if(dataSourceKey == e) {

                DynamicDataSourceContextHolder.set(e);
                return;
            }
        }
//        switch (dataSourceKey) {
//            case  DB_MASTER:
//                DynamicDataSourceContextHolder.set(DataSourceKey.DB_MASTER);
//                break;
//            case DB_SLAVE:
//                DynamicDataSourceContextHolder.set(DataSourceKey.DB_SLAVE);
//                break;
//            default:
//                DynamicDataSourceContextHolder.set(DataSourceKey.DB_MASTER);
//        }
//        log.info(String.format("设置数据源为  %s", dataSourceKey.getName()));


//        if (dataSourceKey == DataSourceKey.DB_SLAVE) {
//            log.info(String.format("设置数据源为  %s", DataSourceKey.DB_SLAVE));
//            DynamicDataSourceContextHolder.set(DataSourceKey.DB_SLAVE);
//        } else {
//            log.info(String.format("使用默认数据源  %s", DataSourceKey.DB_MASTER));
//            DynamicDataSourceContextHolder.set(DataSourceKey.DB_MASTER);
//        }
    }

    public static void main(String[] args) {
        //循环输出 值
        for (DataSourceKey e : DataSourceKey.values()) {
            System.out.println(e );
        }
    }

    /**
     * 执行方法后清除数据源设置
     *
     * @param joinPoint        切点
     * @param targetDataSource 动态数据源
     */
    @After("@annotation(targetDataSource)")
    public void doAfter(JoinPoint joinPoint, DS targetDataSource) {
        log.info(String.format("当前数据源  %s  执行清理方法", targetDataSource.value()));
        DynamicDataSourceContextHolder.clear();
    }

//    @Pointcut("execution(* com.zenvans.controller.wb..*.*(..))")
//    public void pointCut() {
//    }
//
//    @Before(value = "pointCut()")
//    public void doBeforeWithSlave(JoinPoint joinPoint) {
//        log.info(String.format("当前类的数据源为 %s", DataSourceKey.DB_SLAVE));
//            DynamicDataSourceContextHolder.set(DataSourceKey.DB_SLAVE);
//    }

}
