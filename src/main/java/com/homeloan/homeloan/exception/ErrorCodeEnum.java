package com.homeloan.homeloan.exception;

import java.util.Collections;
import java.util.List;

import static com.homeloan.homeloan.common.ConstantUtils.BAD_REQUEST;
import static com.homeloan.homeloan.common.ConstantUtils.NO_RECORD_EXIST;

public enum ErrorCodeEnum {

    ENTITY_NOT_FOUND(NO_RECORD_EXIST, 1001),
    PARAMETER_BAD_REQUEST(BAD_REQUEST, 1002);

    private  final List<String> messages;
    private  final Integer code;
    ErrorCodeEnum(String msg, Integer code){
        this.messages= Collections.singletonList(msg);
        this.code=code;
    }

    public List<String> getMessages() {
        return messages;
    }

    public Integer getCode() {
        return code;
    }
}
