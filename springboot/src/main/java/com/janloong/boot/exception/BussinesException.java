package com.janloong.boot.exception;

import com.janloong.boot.enums.ResultEnum;

/**
 * @author Janloong
 * @date 2017-12-28 11:25
 **/
public class BussinesException extends RuntimeException {

    private Integer code;

    private String des;

    public BussinesException(ResultEnum resultEnum) {
        super(resultEnum.getMsg());
        this.code = resultEnum.getCode();
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }
}
