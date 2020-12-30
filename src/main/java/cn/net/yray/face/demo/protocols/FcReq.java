package cn.net.yray.face.demo.protocols;

import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * 通用请求类
 *
 * @param <T>
 * @author yudeng
 * @since 2020-04-05
 */
@Data
public class FcReq<T> {

    /**
     * 请求体
     */
    @NotNull
    private T plain;
}
