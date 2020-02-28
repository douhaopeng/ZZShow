package com.ys.yoosir.zzshow.common;

/**
 * Created by 窦浩鹏 on 2020/2/28.
 */

public interface RequestCallBack<T> {
    void beforeRequest();

    void success(T data);

    void onError(String errorMsg);
}
