package com.DS;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.METHOD) //声明应用在方法上
@Retention(RetentionPolicy.RUNTIME)  //运行期生效

/**
 * 自定义注解实现动态切换数据源
 */
public @interface DS {
    DataSourceKey value()  default DataSourceKey.DB_MASTER;
}
