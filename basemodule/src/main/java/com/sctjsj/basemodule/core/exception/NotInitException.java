package com.sctjsj.basemodule.core.exception;

import android.content.Context;

/**
 * Created by mayikang on 17/5/4.
 */

public class NotInitException extends RuntimeException{

    public NotInitException(Class<?> c){
        super("类未初始化异常",new Throwable(c.getSimpleName()));

    }
}
