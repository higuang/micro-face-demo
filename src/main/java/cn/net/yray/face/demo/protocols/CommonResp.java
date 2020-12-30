package cn.net.yray.face.demo.protocols;

import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * 通用响应类
 *
 * @author yudeng
 * @since 2020-04-05
 */
@Data
public class CommonResp<T> extends BaseResp {

    /**
     * 响应数据
     */
    @NotNull
    private T details;
}
