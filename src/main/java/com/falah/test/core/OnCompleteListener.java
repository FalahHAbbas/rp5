package com.falah.test.core;

import com.falah.test.models.Error;

public interface OnCompleteListener<T> {
    void onComplete(T result, Error error);
}
