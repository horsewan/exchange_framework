package com.zwan.bitrade.annotation;


import java.lang.annotation.*;

import com.zwan.bitrade.constant.AdminModule;

@Target({ElementType.METHOD})
@Documented
@Retention(RetentionPolicy.RUNTIME)
public @interface AccessLog {
    String operation();
    AdminModule module();
}

