package com.pao11.readerapp.rx;

/**
 * Created by pao11 on 2017/3/10.
 */

public class RxBusBaseMessage {

    private  int code;
    private Object object;
    private RxBusBaseMessage(){}
    public RxBusBaseMessage(int code, Object object){
        this.code=code;
        this.object=object;
    }

    public int getCode() {
        return code;
    }

    public Object getObject() {
        return object;
    }
}
