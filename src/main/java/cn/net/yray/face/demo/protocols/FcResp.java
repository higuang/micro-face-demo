package cn.net.yray.face.demo.protocols;

import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * 通用响应类
 *
 * @param <T>
 * @author yudeng
 * @since 2020-04-05
 */
@Data
public class FcResp<T> {

    /**
     * 响应体
     */
    @NotNull
    private CommonResp<T> plain;
}
