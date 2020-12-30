package cn.net.yray.face.demo.config;

import cn.net.cfss.fgbp.base.config.BaseFaceExceptConf;
import cn.net.cfss.fgbp.base.constant.ErrCodeEnum;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class ExceptionConf extends BaseFaceExceptConf {

    @Override
    public ErrCodeEnum getErrCodeEnum() {
        return ErrCodeEnum.ERR;
    }


}
