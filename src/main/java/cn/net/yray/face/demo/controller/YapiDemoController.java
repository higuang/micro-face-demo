package cn.net.yray.face.demo.controller;

import cn.net.yray.face.demo.protocols.FcReq;
import cn.net.yray.face.demo.protocols.FcResp;
import cn.net.yray.face.demo.protocols.yapi.AddProductRequest;
import cn.net.yray.face.demo.protocols.yapi.AddProductResponse;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * YAPI接口文档演示
 *
 * @author yudeng
 * @module 演示项目
 * @since 2020-04-05
 */
@RestController
@RequestMapping("/yapi")
public class YapiDemoController {

    /**
     * 新增产品接口
     *
     * @param fcReq 新增产品接口请求参数
     * @return
     * @undone
     * @deprecated 改用{@link #addProduct3()}
     */
    @PostMapping(value = "/addProduct")
    public FcResp<AddProductResponse> addProduct(@RequestBody FcReq<AddProductRequest> fcReq) {
        return null;
    }

    /**
     * 新增产品接口2
     *
     * @param fcReq 新增产品接口请求参数
     * @return
     * @ignore
     */
    @PostMapping(value = "/addProduct2")
    public FcResp<AddProductResponse> addProduct2(@RequestBody FcReq<AddProductRequest> fcReq) {
        return null;
    }

    /**
     * 新增产品接口3
     *
     * @param fcReq 新增产品接口请求参数
     * @return
     */
    @PostMapping(value = "/addProduct3")
    public FcResp<AddProductResponse> addProduct3(@RequestBody FcReq<AddProductRequest> fcReq) {
        return null;
    }
}
