package com.softuvo.frp.api;

public interface ApiCallBack<T> {
    void onSuccess(T t);

    void onFailure(String message);
}
