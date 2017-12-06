package com.pao11.readerapp.injector.qualifier;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;

import javax.inject.Qualifier;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * Created by pao11 on 2017/4/26.
 */

@Qualifier
@Documented
@Retention(RUNTIME)
public @interface GankUrl {

}
