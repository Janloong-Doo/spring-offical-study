package com.janloong.boot.handle;

import com.janloong.boot.domain.Result;
import com.janloong.boot.exception.BussinesException;
import com.janloong.boot.utils.ResultUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 我是类描述
 * <p>
 * 我是类详细描述
 *
 * @author <a href = janloongdoo@gmail.com>Janloong</a>
 * @date 2017-12-28 11:27
 */
@ControllerAdvice
public class ExceptionHandle {

    private final static Logger logger = LoggerFactory.getLogger(ExceptionHandle.class);

    /**
     * 我是方法描述
     * <p>
     * 我是类详细描述
     *
     * @param e 我是参数 e
     * @return Result 我是返回类型
     * @throws Exception 我是异常
     * @author <a href ="mailto: janloongdoo@gmail.com">Janloong</a>
     * @date 2017 -12-28 15:03
     */
    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public Result handle(Exception e) throws Exception {
        if (e instanceof BussinesException) {
            BussinesException bussinesException = (BussinesException) e;
            return ResultUtil.error(bussinesException.getCode(), bussinesException.getMessage());
        } else {
            logger.error("【系统异常, master version】{}", e);
            return ResultUtil.error(-1, "未知错误");
        }
    }
}
