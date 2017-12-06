package com.pao11.readerapp.http;

import rx.Subscription;

/**
 * Created by pao11 on 2017/3/21.
 */

public interface LifeSubscription{
    void bindSubscription(Subscription subscription);
}

