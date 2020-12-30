package cn.net.yray.face.demo.protocols.yapi;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * 新增产品接口响应类
 *
 * @author yudeng
 * @since 2020-04-05
 */
@Data
public class AddProductResponse {

    /**
     * 姓名
     *
     * @mock @string(4,255)
     */
    @NotNull
    @Length(min = 4, max = 255)
    private String name;

    /**
     * 长度
     */
    @Max(5000)
    @Min(10)
    private Long length;

    /**
     * 数据集合
     */
    private List<Data> dataList;

    /**
     * 数据
     */
    @NotNull
    private Data data;

    @lombok.Data
    class Data {

        /**
         * 最大长度
         */
        @NotNull
        @Max(10)
        private Integer maxLength;

        /**
         * 邮箱
         */
        @Email
        private String email;
    }
}
