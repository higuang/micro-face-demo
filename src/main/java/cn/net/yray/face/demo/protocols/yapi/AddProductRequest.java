package cn.net.yray.face.demo.protocols.yapi;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * 新增产品接口请求类
 *
 * @author yudeng
 * @since 2020-04-05
 */
@Data
public class AddProductRequest {

    /**
     * 接口编号
     * @mock @string(10)
     */
    @NotNull
    @Length(min=10,max = 10)
    private String productNo;

    /**
     * 接口名称
     * @mock @string(1,2)
     */
    @NotNull
    @Length(min = 1,max = 2)
    private String productName;

    /**
     * Id集合
     */
    @NotNull
    private List<Long> idList;

    /**
     * 创建人
     */
    private User creator;

    @Data
    class User {
        /**
         * 姓名
         */
        @NotNull
        private String name;

        /**
         * 年龄
         */
        @Max(150)
        @Min(0)
        private Integer age;

    }

}
