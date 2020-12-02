package com.jcuesoft.cuebridge.common.pagination;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ ElementType.TYPE })
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@Documented
public @interface TableSeg {
    /**
     * 表名
     * 
     * @return
     */
    public String tableName();

    /**
     * 
     * @return
     */
    public String shardType();

    /**
     * 
     * @return
     */
    public String shardBy();

}