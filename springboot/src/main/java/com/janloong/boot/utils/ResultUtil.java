package com.janloong.boot.utils;

import com.janloong.boot.domain.Result;

/**
 * des: 描述xxx
 * <p>
 * 详细描述
 *
 * @author Janloong
 * @date 2017 -12-27 19:07
 */
public class ResultUtil {

    public static Result success(Object object) {
        Result result = new Result();
        result.setCode(0);
        result.setMsg("success");
        result.setData(object);
        return result;
    }

    /**
     * des:
     *
     * @return the result
     * @author Janloong
     * @date 2017 -12-28 15:17
     */
    public static Result success() {
        return success(null);
    }

    public static Result error(Integer code, String msg) {
        Result result = new Result();
        result.setCode(code);
        result.setMsg(msg);
        return result;
    }

}
