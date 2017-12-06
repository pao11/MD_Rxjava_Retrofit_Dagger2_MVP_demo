package com.pao11.readerapp.injector.scope;

import java.lang.annotation.Retention;

import javax.inject.Scope;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * Created by pao11 on 2017/3/21.
 */
@Scope
@Retention(RUNTIME)
public @interface ActivityScope {
}
