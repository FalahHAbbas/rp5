package com.falah.test.core;

import com.falah.test.models.Error;

import java.util.List;

public interface OnListCompleteListener<T> {
    void onComplete(List<T> result, Error error);
}
