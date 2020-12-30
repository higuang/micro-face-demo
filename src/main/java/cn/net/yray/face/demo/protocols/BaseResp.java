package cn.net.yray.face.demo.protocols;

import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * 通用响应体父类
 *
 * @author yudeng
 * @since 2020-04-05
 */
@Data
public class BaseResp {

    /**
     * 响应状态码
     */
    @NotBlank
    private String resultCode;

    /**
     * 响应提示信息
     */
    private String resultMsg;
}
